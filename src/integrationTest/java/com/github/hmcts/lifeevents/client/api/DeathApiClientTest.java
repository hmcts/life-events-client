package com.github.hmcts.lifeevents.client.api;

import com.github.hmcts.lifeevents.client.config.ClientConfiguration;
import com.github.hmcts.lifeevents.client.config.ServiceConfiguration;
import com.github.hmcts.lifeevents.client.model.V1Death;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
    classes = { ClientConfiguration.class, ServiceConfiguration.class, TestOAuth2Config.class }
)
@EnableAutoConfiguration
@EnableFeignClients(clients = DeathApiClient.class)
@ActiveProfiles("test")
class DeathApiClientTest {

    @Autowired
    private DeathApiClient deathApiClient;

    @Test
    public void shouldRetreiveDeathRecordFromAPIByNameAndDate() {
        String foreNames = "Joan";
        String surname = "Smith";
        LocalDate date = LocalDate.of(2008,8,8);
        ResponseEntity<List<V1Death>> results = deathApiClient.searchV1Death(foreNames, surname, date);
        assertThat(results.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void shouldRetreiveDeathRecordFromAPIById() {
        ResponseEntity<V1Death> result = deathApiClient.readV1Death(123456789);
        assertThat(result.getStatusCode().is2xxSuccessful());
    }
}
