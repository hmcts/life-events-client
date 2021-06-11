package com.github.hmcts.lifeevents.client.service;

import java.time.LocalDate;
import java.util.List;

import com.github.hmcts.lifeevents.client.api.DeathApiClient;
import com.github.hmcts.lifeevents.client.model.V1Death;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    
    @MockBean
    private ResponseEntity<V1Death> result;
    
    @MockBean
    private V1Death record;
    
    @Test
    void test(){
        when(deathApiClient.searchV1Death(any(),any(),any())).thenReturn(results);
        when(results.getBody()).thenReturn(list);

        final List<V1Death> v1Deaths = deathService.searchForDeathRecordsByNamesAndDate("", "", LocalDate.now());
        assertThat(v1Deaths).isEqualTo(list);
    }
    
    @Test
    void shouldReturnDeathRecord(){
        
        when(deathApiClient.readV1Death(any())).thenReturn(result);
        when(result.getBody()).thenReturn(record);

        V1Death v1Death = deathService.getDeathRecordById(123456);
        assertThat(v1Death).isEqualTo(record);
    }

    @Test
    void shouldReturnNullWhenDeathRecordNotFound(){
        when(deathApiClient.readV1Death(any())).thenThrow(FeignException.FeignClientException.NotFound.class);
        V1Death v1Death = deathService.getDeathRecordById(123456);
        assertNull(v1Death);
    }

    @Test
    void testException(){
        when(deathApiClient.searchV1Death(any(),any(),any())).thenThrow(new RuntimeException("Exception test"));
        assertThrows(RuntimeException.class, () -> deathService.searchForDeathRecordsByNamesAndDate("", "", LocalDate.now()));
    }
}
