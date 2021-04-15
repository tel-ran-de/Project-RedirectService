package de.telran.project_redirect_service.controller;

import de.telran.project_redirect_service.service.RedirectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RedirectController {

    @Autowired
    private RedirectServiceImpl redirectService;

    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> redirect(@PathVariable String shortUrl) {
        Optional<String> optional = redirectService.getRedirectUrl(shortUrl);
        return optional.map(c->ResponseEntity.status(302).header("Location", c).body(""))
                .orElse(ResponseEntity.notFound().build());
    }
}
