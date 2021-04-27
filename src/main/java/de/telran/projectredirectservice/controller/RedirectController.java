package de.telran.projectredirectservice.controller;

import de.telran.projectredirectservice.dto.StatDto;
import de.telran.projectredirectservice.service.RedirectService;
import de.telran.projectredirectservice.service.kafka.StatisticsProducerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;


@RestController
public class RedirectController {
    private final RedirectService redirectService;
    final StatisticsProducerService statisticsProducerService;

    public RedirectController(RedirectService redirectService, StatisticsProducerService statisticsProducerService) {
        this.redirectService = redirectService;
        this.statisticsProducerService = statisticsProducerService;
    }

    @GetMapping("short_server/{url_code}")
    public ResponseEntity<String> redirectByShortURL(@PathVariable String url_code) {
        Optional<String> longURL = redirectService.getRedirectUrl( url_code );

        if (longURL.isPresent()) {
            // add statistics
            statisticsProducerService.sendRedirectSat( new StatDto(url_code, longURL.get()) );

            final URI location = URI.create( longURL.get() );
            final HttpHeaders headers = new HttpHeaders();
            headers.setLocation( location );

            return new ResponseEntity( headers, HttpStatus.FOUND );
        } else {
            return new ResponseEntity( HttpStatus.NOT_FOUND );
        }
    }


}
