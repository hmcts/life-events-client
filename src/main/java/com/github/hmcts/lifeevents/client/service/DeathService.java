package com.github.hmcts.lifeevents.client.service;

import com.github.hmcts.lifeevents.client.model.V1Death;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface DeathService {
    List<V1Death> searchForDeathRecordsByNamesAndDate(String forenames, String surname, LocalDate date);

    V1Death getDeathRecordById(Integer id);
}
