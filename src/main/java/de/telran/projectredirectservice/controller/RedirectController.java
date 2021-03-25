package de.telran.projectredirectservice.controller;

import de.telran.projectredirectservice.service.RedirectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedirectController {
    final RedirectService redirectService;

    public RedirectController(RedirectService redirectService) {
        this.redirectService = redirectService;
    }

    @GetMapping("short_server/{url_code}")
    public String redirectByShortURL(@PathVariable String url_code){
        String longURL=redirectService.getRedirectUrl(url_code).get().getLongUrl();
        return "redirect: "+longURL;
    }
}
