package de.telran.projectredirectservice.service;

import de.telran.projectredirectservice.model.Url;
import de.telran.projectredirectservice.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedirectService {
    final UrlRepository urlRepository;

    public RedirectService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public Optional<Url> getRedirectUrl(String shortUrlCode) {
        Optional<Url> optionalUrl = urlRepository.findByShortUrl( shortUrlCode );
        if (optionalUrl.isPresent()) {
            return optionalUrl;
        } else {
            return Optional.empty();
        }
    }
}
