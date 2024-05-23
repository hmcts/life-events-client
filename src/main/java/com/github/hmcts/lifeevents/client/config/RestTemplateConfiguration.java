package com.github.hmcts.lifeevents.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.security.oauth2.client.http.OAuth2ErrorResponseErrorHandler;
import org.springframework.security.oauth2.core.http.converter.OAuth2AccessTokenResponseHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.function.Supplier;

@Service
public class RestTemplateConfiguration {

    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateConfiguration(@Qualifier("client-http-request-factory") Supplier<ClientHttpRequestFactory> clientHttpRequestFactory) {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        this.restTemplate = builder
                .requestFactory(clientHttpRequestFactory)
                .messageConverters(Arrays.asList(
                        new FormHttpMessageConverter(),
                        new OAuth2AccessTokenResponseHttpMessageConverter()))
                .errorHandler(new OAuth2ErrorResponseErrorHandler())
                .build();
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
}
