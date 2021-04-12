package de.telran.projectredirectservice.service;

import de.telran.projectredirectservice.repository.UrlRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WorkSchedule {

    final UrlRepository urlRepository;

    static Logger logger = LogManager.getLogger(WorkSchedule.class);

    public WorkSchedule(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Scheduled(initialDelay = 10000, fixedDelayString = "10000")
    public void deleteExpiredURLs(){

        Integer numberOfRemovedUrls=urlRepository.deleteUrlByExpirationDateBefore( LocalDateTime.now());
        logger.debug( "number of deleted Urls with : "+numberOfRemovedUrls );

    }
}
