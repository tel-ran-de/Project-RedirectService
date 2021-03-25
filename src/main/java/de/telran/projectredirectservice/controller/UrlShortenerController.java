package de.telran.projectredirectservice.controller;

import de.telran.projectredirectservice.dto.LongUrlDto;
import de.telran.projectredirectservice.dto.ShortUrlDto;
import de.telran.projectredirectservice.model.Url;
import de.telran.projectredirectservice.service.UrlShortenerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {
    final UrlShortenerService service;

    public UrlShortenerController(UrlShortenerService service) {
        this.service = service;
    }

    @PostMapping("/urls")
    public ShortUrlDto createShortURLFromLong(@RequestBody LongUrlDto longUrlDto) {
        Url url = service.create(longUrlDto.getLongUrl(), longUrlDto.getCustomerNumber(),
                longUrlDto.getExpirationDate());

        return new ShortUrlDto(url.getId(), url.getShortUrl());
    }
}
