package com.github.hmcts.lifeevents.client.config;

import java.util.Collection;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.ClientAuthorizationException;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.registration.ClientRegistration;

import static java.util.Objects.isNull;

public class OAuthClientCredentialsFeignManager {
    private static final Logger logger = LoggerFactory.getLogger(OAuthClientCredentialsFeignManager.class);

    private final OAuth2AuthorizedClientManager manager;
    private final Authentication principal;
    private final ClientRegistration clientRegistration;

    public OAuthClientCredentialsFeignManager(OAuth2AuthorizedClientManager manager, ClientRegistration clientRegistration) {
        this.manager = manager;
        this.clientRegistration = clientRegistration;
        this.principal = createPrincipal();
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
            OAuth2AuthorizeRequest oAuth2AuthorizeRequest = OAuth2AuthorizeRequest
                .withClientRegistrationId(clientRegistration.getRegistrationId())
                .principal(principal)
                .build();

            logger.info("OAuthClientCredentialsFeignManager.getAccessToken() clientId: " + clientRegistration.getClientId());
            OAuth2AuthorizedClient client = null;
            try {
                logger.info("Token Request LEV: " + manager.toString());
                client = manager.authorize(oAuth2AuthorizeRequest);
            } catch (ClientAuthorizationException cae) {
                if("Token is not active".equals(cae.getError().getDescription())){
                    client = manager.authorize(oAuth2AuthorizeRequest);
                }
            }
            if (isNull(client)) {
                throw new IllegalStateException("Password flow on " + clientRegistration.getRegistrationId() + " failed, client is null");
            }
            logger.info("access Token: " + client.getAccessToken().getTokenValue());
            logger.info("refresh Token: " + client.getRefreshToken().getTokenValue());
            return client.getAccessToken().getTokenValue();
        } catch (Exception exp) {
            logger.error("client credentials error " + exp.getMessage(), exp);
        }
        return null;
    }
}
