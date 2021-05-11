package com.github.hmcts.lifeevents.client.service;

import com.github.hmcts.lifeevents.client.api.DeathApiClient;
import com.github.hmcts.lifeevents.client.model.V1Death;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DeathServiceImpl implements DeathService {
    private static final Logger logger = LoggerFactory.getLogger(DeathServiceImpl.class);

    private final DeathApiClient deathApiClient;

    public DeathServiceImpl(DeathApiClient deathApiClient) {
        logger.info("DeathServiceImpl");
        this.deathApiClient = deathApiClient;
    }

    @Override
    public List<V1Death> searchForDeathRecordsByNamesAndDate(String forenames, String surname, LocalDate date){
        return deathApiClient.searchV1Death(forenames, surname, date).getBody();
    }

    @Override
    public V1Death getDeathRecordById(Integer id){
        return deathApiClient.readV1Death(id).getBody();
    }
}
