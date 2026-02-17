package com.github.hmcts.lifeevents.client.api;

import com.github.hmcts.lifeevents.client.model.V1Death;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RestClientTest(DeathApiClient.class)
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
