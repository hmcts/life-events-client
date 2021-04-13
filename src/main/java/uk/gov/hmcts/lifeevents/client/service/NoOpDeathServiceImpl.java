package uk.gov.hmcts.lifeevents.client.service;

import uk.gov.hmcts.lifeevents.client.model.V1Death;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NoOpDeathServiceImpl implements DeathService  {
    private static final Logger logger = LoggerFactory.getLogger(NoOpDeathServiceImpl.class);

    public static final String NOT_IMPLEMENTED = "Not implemented";

    public NoOpDeathServiceImpl() {
        logger.info("NoOpDeathServiceImpl");
    }

    public List<V1Death> searchForDeathRecordsByNamesAndDate(String forenames, String surname, LocalDate date){
        return null;
    }

    public V1Death getDeathRecordById(Integer id){
        return null;
    }
}
