package com.github.hmcts.lifeevents.client.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;


public class OAuthClientCredentialsFeignManager {
    private static final Logger logger = LoggerFactory.getLogger(OAuthClientCredentialsFeignManager.class);

    private final ClientRegistration clientRegistration;
    private final RestTemplate restTemplate;
    private final String username;
    private final String password;


    public OAuthClientCredentialsFeignManager(ClientRegistration clientRegistration,
                                              RestTemplate restTemplate,
                                              String username,
                                              String password) {
        this.clientRegistration = clientRegistration;
        this.restTemplate = restTemplate;
        this.username = username;
        this.password = password;
    }

    public String getAccessToken() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("grant_type", clientRegistration.getAuthorizationGrantType().getValue());
            map.add("client_id", clientRegistration.getClientId());
            map.add("client_secret", clientRegistration.getClientSecret());
            map.add("username", username);
            map.add("password", password);
            logger.info("OAuthClientCredentialsFeignManager getAccessToken with grant_type: {}, client_id: {}",
                    clientRegistration.getAuthorizationGrantType().getValue(), clientRegistration.getClientId());
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

            ResponseEntity<OAuth2AccessTokenResponse> response = restTemplate.exchange(
                    clientRegistration.getProviderDetails().getTokenUri(),
                    HttpMethod.POST,
                    request,
                    OAuth2AccessTokenResponse.class
            );

            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new HttpClientErrorException(response.getStatusCode(), "Failed to get LEV token");
            }
            return Objects.requireNonNull(response.getBody()).getAccessToken().getTokenValue();
        } catch (RestClientException exp) {
            logger.error("client credentials error {}", exp.getMessage(), exp);
        }
        return null;
    }
}
