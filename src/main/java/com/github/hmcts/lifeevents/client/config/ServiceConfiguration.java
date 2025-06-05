package com.github.hmcts.lifeevents.client.config;

import com.github.hmcts.lifeevents.client.api.DeathApiClient;
import com.github.hmcts.lifeevents.client.service.DeathService;
import com.github.hmcts.lifeevents.client.service.DeathServiceImpl;
import com.github.hmcts.lifeevents.client.service.NoOpDeathServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@AutoConfiguration
@EnableConfigurationProperties
@EnableFeignClients(clients = DeathApiClient.class)
public class ServiceConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(ServiceConfiguration.class);

    private Environment environment;

    private DeathApiClient deathApiClient;

    public ServiceConfiguration(final DeathApiClient deathApiClient, Environment environment) {
        this.deathApiClient = deathApiClient;
        this.environment = environment;
        logger.info("spring.security.oauth2.client.provider.homeoffice.authorization-uri: "
                + environment.getProperty("spring.security.oauth2.client.provider.homeoffice.authorization-uri"));
    }

    @Bean
    @ConditionalOnProperty(name = "lev.ssl.publicCertificate")
    public DeathService deathService() {
        logger.info("lev.ssl.publicCertificate: " + environment.getProperty("lev.ssl.publicCertificate"));
        return new DeathServiceImpl(deathApiClient);
    }

    @Bean
    @ConditionalOnMissingBean(value = DeathService.class)
    public DeathService noOpDeathService() {
        logger.info("lev.ssl.publicCertificate: " + environment.getProperty("lev.ssl.publicCertificate"));
        return new NoOpDeathServiceImpl();
    }
}
