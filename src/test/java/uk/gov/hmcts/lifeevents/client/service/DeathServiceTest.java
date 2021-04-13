package uk.gov.hmcts.lifeevents.client.service;

import uk.gov.hmcts.lifeevents.client.api.DeathApiClient;
import uk.gov.hmcts.lifeevents.client.model.V1Death;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DeathServiceImpl.class)
public class DeathServiceTest {

    @Autowired
    private DeathServiceImpl deathService;

    @MockBean
    private DeathApiClient deathApiClient;

    @MockBean
    private ResponseEntity<List<V1Death>> results;

    @MockBean
    private List<V1Death> list;

    @Test
    void test(){
        when(deathApiClient.searchV1Death(any(),any(),any())).thenReturn(results);
        when(results.getBody()).thenReturn(list);

        final List<V1Death> v1Deaths = deathService.searchForDeathRecordsByNamesAndDate("", "", LocalDate.now());
        assertThat(v1Deaths).isEqualTo(list);
    }
}
