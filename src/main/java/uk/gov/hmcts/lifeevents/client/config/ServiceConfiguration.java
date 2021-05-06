package uk.gov.hmcts.lifeevents.client.config;

import uk.gov.hmcts.lifeevents.client.api.DeathApiClient;
import uk.gov.hmcts.lifeevents.client.service.DeathService;
import uk.gov.hmcts.lifeevents.client.service.DeathServiceImpl;
import uk.gov.hmcts.lifeevents.client.service.NoOpDeathServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@EnableConfigurationProperties
@EnableFeignClients(clients = DeathApiClient.class)
public class ServiceConfiguration {

  private static final Logger logger = LoggerFactory.getLogger(ServiceConfiguration.class);

  @Autowired
  Environment environment;

  private DeathApiClient deathApiClient;

  public ServiceConfiguration(final DeathApiClient deathApiClient) {
    this.deathApiClient = deathApiClient;
  }

  @Bean
  @ConditionalOnProperty(name = "lev.ssl.publicCertificate")
  public DeathService deathService() {
    logger.info("lev.ssl.publicCertificate" + environment.getProperty("lev.ssl.publicCertificate"));
    logger.info("lev.bearertoken.clientId" + environment.getProperty("lev.bearertoken.clientId"));
    return new DeathServiceImpl(deathApiClient);
  }

  @Bean
  @ConditionalOnMissingBean(value = DeathService.class)
  public DeathService noOpDeathService() {
    logger.info("lev.ssl.publicCertificate" + environment.getProperty("lev.ssl.publicCertificate"));
    logger.info("lev.bearertoken.clientId" + environment.getProperty("lev.bearertoken.clientId"));
    return new NoOpDeathServiceImpl();
  }
}
