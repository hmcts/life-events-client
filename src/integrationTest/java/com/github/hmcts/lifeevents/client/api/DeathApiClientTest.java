package com.github.hmcts.lifeevents.client.api;

import com.github.hmcts.lifeevents.client.config.ClientConfiguration;
import com.github.hmcts.lifeevents.client.config.ServiceConfiguration;
import com.github.hmcts.lifeevents.client.model.V1Death;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = { ClientConfiguration.class, ServiceConfiguration.class }, properties = {
        "lev.death.url=https://api.life-event-verification.homeoffice.gov.uk"
})
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration()
@EnableAutoConfiguration
class DeathApiClientTest {

    @Autowired
    private DeathApiClient deathApiClient;

    @Test
    public void shouldRetreiveDeathRecordFromAPIById() {
        ResponseEntity<V1Death> result = deathApiClient.readV1Death(123456789);
        assertThat(result.getStatusCode().is2xxSuccessful());
    }
}
