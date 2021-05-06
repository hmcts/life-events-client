package uk.gov.hmcts.lifeevents.client.service;

import uk.gov.hmcts.lifeevents.client.model.V1Death;

import java.time.LocalDate;
import java.util.List;

public interface DeathService {
    List<V1Death> searchForDeathRecordsByNamesAndDate(String forenames, String surname, LocalDate date);

    V1Death getDeathRecordById(Integer id);
}
