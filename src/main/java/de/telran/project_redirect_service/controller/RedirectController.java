package de.telran.project_redirect_service.controller;

import de.telran.project_redirect_service.service.RedirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@RestController
public class RedirectController {

    @Autowired
    private RedirectService redirectService;

    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> redirect(@PathVariable String shortUrl) {
        Optional<String> optional = redirectService.getRedirectUrl(shortUrl);
        RedirectView redirectView = new RedirectView();
        return optional.map(c->ResponseEntity.status(302).header("Location", c).body(""))
                .orElse(ResponseEntity.notFound().build());
    }
}
