package de.telran.project_redirect_service.service;

import de.telran.project_redirect_service.repository.UrlRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduledService {

    private static final Logger logger = LogManager.getLogger(ScheduledService.class);


    @Autowired
    private UrlRepository urlRepository;

    // fixedRate in ms
    @Scheduled(fixedRate = 3600000)// 1 Hour
    public void deleteOldLinks() {
        Integer quantityRemovedUrls = urlRepository.deleteUrlByExpirationDateBefore(LocalDateTime.now());
        logger.info("Quantity of removed expired Urls is - " + quantityRemovedUrls);
    }
}
