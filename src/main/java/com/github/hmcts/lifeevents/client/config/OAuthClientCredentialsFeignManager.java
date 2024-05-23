package com.github.hmcts.lifeevents.client.config;

import java.util.Collection;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.ClientAuthorizationException;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static java.util.Objects.isNull;

public class OAuthClientCredentialsFeignManager {
    private static final Logger logger = LoggerFactory.getLogger(OAuthClientCredentialsFeignManager.class);

    private final OAuth2AuthorizedClientManager manager;
    private final Authentication principal;
    private final ClientRegistration clientRegistration;
    private final OAuth2AuthorizedClientService authorizedClientService;
    private final RestTemplateConfiguration restTemplateConfiguration;


    @Value("${lev.bearertoken.username}")
    private String username;

    @Value("${lev.bearertoken.password}")
    private String password;


    public OAuthClientCredentialsFeignManager(OAuth2AuthorizedClientManager manager,
                                              ClientRegistration clientRegistration,
                                              OAuth2AuthorizedClientService oAuth2AuthorizedClientService,
                                              RestTemplateConfiguration restTemplateConfiguration) {
        this.manager = manager;
        this.clientRegistration = clientRegistration;
        this.restTemplateConfiguration = restTemplateConfiguration;
        this.principal = createPrincipal();
        this.authorizedClientService = oAuth2AuthorizedClientService;
    }

    private Authentication createPrincipal() {

        return new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return Collections.emptySet();
            }

            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return this;
            }

            @Override
            public boolean isAuthenticated() {
                return false;
            }

            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
            }

            @Override
            public String getName() {
                return clientRegistration.getClientId();
            }
        };
    }

    public String getAccessToken() {
        try {
            if (authorizedClientService.loadAuthorizedClient(clientRegistration.getRegistrationId(), clientRegistration.getClientId()) != null) {
                logger.info("loadAuthorizedClient refresh token" + authorizedClientService.loadAuthorizedClient(clientRegistration.getRegistrationId(), clientRegistration.getClientId()).getRefreshToken().getTokenValue());
                return refreshAccessToken().getAccessToken().getTokenValue();
            }
            OAuth2AuthorizeRequest oAuth2AuthorizeRequest = OAuth2AuthorizeRequest
                .withClientRegistrationId(clientRegistration.getRegistrationId())
                .principal(principal)
                .build();

            logger.info("OAuthClientCredentialsFeignManager.getAccessToken() clientId: " + clientRegistration.getClientId());
            OAuth2AuthorizedClient client = null;
            try {
                logger.info("Authorizing LEV OAuth2 request");
                client = manager.authorize(oAuth2AuthorizeRequest);
                if (client != null && client.getRefreshToken() != null) {
                    logger.info("OAuth2AuthorizedClient Refresh token: {}", client.getRefreshToken().getTokenValue());
                }
            } catch (ClientAuthorizationException cae) {
                logger.info("ClientAuthorizationException message: " + cae.getMessage());
                logger.info("ClientAuthorizationException description: " + cae.getError().getDescription());
                if("No refresh token".equals(cae.getError().getDescription())){
                    client = manager.authorize(oAuth2AuthorizeRequest);
                }
            }
            if (isNull(client)) {
                throw new IllegalStateException("Password flow on " + clientRegistration.getRegistrationId() + " failed, client is null");
            }
            return client.getAccessToken().getTokenValue();
        } catch (Exception exp) {
            logger.error("client credentials error " + exp.getMessage(), exp);
        }
        return null;
    }

    public OAuth2AccessTokenResponse refreshAccessToken() throws RestClientException {
        RestTemplate restTemplate = restTemplateConfiguration.getRestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "password");
        map.add("client_id", clientRegistration.getClientId());
        map.add("client_secret", clientRegistration.getClientSecret());
        map.add("username", username);
        map.add("password", password);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<OAuth2AccessTokenResponse> response = restTemplate.exchange(
                clientRegistration.getProviderDetails().getTokenUri(),
                HttpMethod.POST,
                request,
                OAuth2AccessTokenResponse.class
        );
        logger.info("refreshAccessToken() response body:" +response.getBody().toString());
        logger.info("refreshAccessToken() response token:" +response.getBody().getAccessToken().getTokenValue());

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new HttpClientErrorException(response.getStatusCode(), "Failed to refresh token");
        }

        return response.getBody();
    }
}
