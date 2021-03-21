package de.telran.project_redirect_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShortLongUrlController {

    @Autowired
    private UrlService urlService;

    @GetMapping("short_server/{urlCode}")
    public String redirectFromShortToLongUrl(@PathVariable String urlCode) {
        String longUrl = urlCode.toUpperCase();
        return "redirect:/" + longUrl;
    }

    @PostMapping("server/urls")
    public ShortUrl createShortUrlFromLong(@RequestBody LongUrl longUrl){
        ShortUrl shortUrl = urlService.createShortUrl(longUrl);
        return shortUrl;
    }
}
