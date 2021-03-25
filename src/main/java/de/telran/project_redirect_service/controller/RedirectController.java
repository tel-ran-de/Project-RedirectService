package de.telran.project_redirect_service.controller;

import de.telran.project_redirect_service.service.RedirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@RestController
public class RedirectController {
    @Autowired
    RedirectService redirectService;

    @GetMapping("/{urlCode}")
    public RedirectView redirect(@RequestParam String shortUrlCode) {
        Optional optional = redirectService.getRedirectUrl(shortUrlCode);
        RedirectView redirectView = new RedirectView();
        if (optional.isPresent()) {
            redirectView = new RedirectView(optional.toString());
            return redirectView;
//            return "redirect:" + optional.toString();
        }
        return null;
    }
}
