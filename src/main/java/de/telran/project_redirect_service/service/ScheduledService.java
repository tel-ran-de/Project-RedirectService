package de.telran.project_redirect_service.service;

import de.telran.project_redirect_service.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduledService {

    @Autowired
    private UrlRepository urlRepository;

    // fixedRate in ms
    @Scheduled(fixedRate = 3600000)// 1 Hour
    public void deleteOldLinks() {
        urlRepository.deleteByExpirationDateBefore(LocalDateTime.now());
    }
}
