package de.telran.project_redirect_service.service;

import de.telran.project_redirect_service.dto.ShortUrlDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedirectService {

    public Optional getRedirectUrl(String shortUrlCode) {
        return Optional.of(shortUrlCode + "f");
    }
}
