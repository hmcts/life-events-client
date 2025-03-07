package com.github.hmcts.lifeevents.client.api;

import com.github.hmcts.lifeevents.client.config.ClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="death", url="${spring.security.oauth2.client.provider.homeoffice.authorization-uri:https://api.life-event-verification.homeoffice.gov.uk}", configuration = ClientConfiguration.class)
public interface DeathApiClient extends DeathApi {
}
