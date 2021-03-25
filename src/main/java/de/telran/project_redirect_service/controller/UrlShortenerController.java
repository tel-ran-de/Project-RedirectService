package de.telran.project_redirect_service.controller;

import de.telran.project_redirect_service.dto.LongUrlDto;
import de.telran.project_redirect_service.dto.ShortUrlDto;
import de.telran.project_redirect_service.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UrlShortenerController {

    @Autowired
    UrlShortenerService service;

    @PostMapping("/urls")
    public ShortUrlDto generateShortUrl(LongUrlDto longUrlDto) {
        ShortUrlDto shortUrlDto = new ShortUrlDto();
        shortUrlDto.setShortUrl(service.generateShortUrl(longUrlDto.getCustomerNumber(), longUrlDto.getLongUrl(), longUrlDto.getExpirationDate()));
        return shortUrlDto;
    }

}
