package de.telran.project_redirect_service.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ShortLongUrlController {

    @GetMapping("short_server/{urlCode}")
    public String redirectFromShortToLongUrl(@PathVariable String urlCode) {
        String longUrl = urlCode.toUpperCase();
        return "redirect:/" + longUrl;
    }
}
