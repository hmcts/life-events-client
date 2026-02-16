package com.github.hmcts.lifeevents.client.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class TestOAuth2Config {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        // Dummy registration to satisfy Spring Security
        ClientRegistration registration = ClientRegistration.withRegistrationId("test")
                .clientId("dummy-client")
                .clientSecret("dummy-secret")
                .authorizationGrantType(
                        org.springframework.security.oauth2.core.AuthorizationGrantType.CLIENT_CREDENTIALS)
                .tokenUri("https://dummy/token")
                .build();
        return new InMemoryClientRegistrationRepository(registration);
    }
}