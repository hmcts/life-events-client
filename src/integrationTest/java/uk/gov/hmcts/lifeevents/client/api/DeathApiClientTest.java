package uk.gov.hmcts.lifeevents.client.api;

import uk.gov.hmcts.lifeevents.client.config.ClientConfiguration;
import uk.gov.hmcts.lifeevents.client.model.V1Death;

import java.time.LocalDate;
import java.util.List;

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

@SpringBootTest(classes = { ClientConfiguration.class }, properties = {
        "lev.death.url=https://api.uat.notprod.lev.homeoffice.gov.uk"
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
