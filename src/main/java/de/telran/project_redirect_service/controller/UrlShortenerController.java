package de.telran.project_redirect_service.controller;

import de.telran.project_redirect_service.dto.LongUrlDto;
import de.telran.project_redirect_service.dto.ShortUrlDto;
import de.telran.project_redirect_service.entity.Url;
import de.telran.project_redirect_service.service.UrlShortenerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/urls")
public class UrlShortenerController {

    @Autowired
    private UrlShortenerServiceImpl urlService;

    @PostMapping
    public ResponseEntity<ShortUrlDto> create(@Valid @RequestBody LongUrlDto longUrlDto) {

        Url url = urlService.createUrl(longUrlDto.getLongUrl(), longUrlDto.getCustomerNumber(), longUrlDto.getExpirationDate());
        return new ResponseEntity<>(new ShortUrlDto(url.getId(), url.getShortUrl()), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public String deleteUrl(@PathVariable Long id) {
        urlService.deleteUrl(id);

        return "Url with id " + id + " was deleted.";
    }
}
