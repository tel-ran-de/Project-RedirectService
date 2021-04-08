package de.telran.projectredirectservice.service;

import de.telran.projectredirectservice.repository.UrlRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class WorkSchedule {
    final UrlRepository urlRepository;

    public WorkSchedule(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Scheduled(initialDelay = 10000, fixedDelayString = "10000")
    public void deleteExpiredURLs(){

        urlRepository.deleteUrlByExpirationDateBefore( LocalDateTime.now());

    }
}
