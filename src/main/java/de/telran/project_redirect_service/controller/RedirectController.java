package de.telran.project_redirect_service.controller;

import de.telran.project_redirect_service.service.RedirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@RestController
public class RedirectController {
    @Autowired
    RedirectService redirectService;

    @GetMapping("/{urlCode}")
    public String redirect(@RequestParam String shortUrlCode) {
        Optional optional = redirectService.getRedirectUrl(shortUrlCode);
        if (optional.isPresent()) {
            return "redirect:" + optional.toString();
        }
        return Optional.empty().toString();
    }
}
