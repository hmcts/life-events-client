package com.github.hmcts.lifeevents.client.service;

import com.github.hmcts.lifeevents.client.model.V1Death;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface DeathService {
    List<V1Death> searchForDeathRecordsByNamesAndDate(String forenames, String surname, LocalDate date);

    V1Death getDeathRecordById(Integer id);
}
