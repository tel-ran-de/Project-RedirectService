package de.telran.projectredirectservice.controller;

import de.telran.projectredirectservice.service.RedirectService;
import org.springframework.web.bind.annotation.*;


@RestController
public class RedirectRestController {

    final RedirectService redirectService;

    public RedirectRestController(RedirectService redirectService) {
        this.redirectService = redirectService;
    }

    @PostMapping("server/urls")
    public String createShortURLFromLong(@RequestBody String longURL) {
        return redirectService.create(longURL);
    }

    @GetMapping("short_server/{url_code}")
    public String redirectByShortURL(@PathVariable String url_code){
        String longURL=redirectService.getLongURL(url_code);
        return "redirect:/"+longURL;
    }
}
