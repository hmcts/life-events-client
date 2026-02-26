package com.github.hmcts.lifeevents.client.api;

import com.github.hmcts.lifeevents.client.config.ClientConfiguration;
import com.github.hmcts.lifeevents.client.config.ServiceConfiguration;
import com.github.hmcts.lifeevents.client.model.V1Death;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
    classes = { ClientConfiguration.class, ServiceConfiguration.class, TestOAuth2Config.class },
    properties = {"death.api.base-url=http://localhost:${wiremock.server.port}"}
)

@EnableAutoConfiguration
@EnableFeignClients(clients = DeathApiClient.class)
@ActiveProfiles("test")
class DeathApiClientTest {

    private static WireMockServer server;

    @Autowired
    private DeathApiClient deathApiClient;

    @BeforeAll
    static void startWireMock() {
        WireMockServerManager.start();
        server = WireMockServerManager.getServer();
    }

    @AfterAll
    static void stopWireMock() {
        WireMockServerManager.stop();
    }


    @Test
    void shouldRetrieveDeathRecordFromAPIByNameAndDate() {

        server.stubFor(WireMock.get(WireMock.urlPathEqualTo("/v1/registration/death"))
                .withQueryParam("forenames", equalTo("Joan"))
                .withQueryParam("surname", equalTo("Smith"))
                .withQueryParam("date", equalTo("2008-08-08"))
                .willReturn(WireMock.okJson("""
                [
                  {
                    "id": 123456789,
                    "date": "2008-08-08",
                    "deceased": {
                      "forenames": "Joan",
                      "surname": "Smith"
                    },
                    "status": { "blocked": false }
                  }
                ]
                """)));
        var response = deathApiClient.searchV1Death(
                "Joan", "Smith", LocalDate.of(2008,8,8));

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    public void shouldRetreiveDeathRecordFromAPIById() {
        server.stubFor(WireMock.get(WireMock.urlPathEqualTo("/v1/registration/death/123456789"))
                .willReturn(WireMock.okJson("""
            {
              "id": 123456789,
              "date": "2008-08-08",
              "deceased": {
                "forenames": "Joan",
                "surname": "Smith"
              },
              "status": { "blocked": false }
            }
            """)));
        ResponseEntity<V1Death> result = deathApiClient.readV1Death(123456789);
        assertThat(result.getStatusCode().is2xxSuccessful());
    }
}
