package de.telran.projectredirectservice.service;

import de.telran.projectredirectservice.model.Url;
import de.telran.projectredirectservice.repository.UrlRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RedirectService {
    final UrlRepository urlRepository;

    public RedirectService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public Optional<String> getRedirectUrl(String shortUrlCode) {
        Optional<String> longUrl = Optional.empty();

        LocalDateTime currentDay = LocalDateTime.now();
        Optional<Url> optionalUrl = urlRepository.getByShortUrlAndExpirationDate( shortUrlCode, currentDay);

        if (optionalUrl.isPresent()) {
            longUrl =urlRepository.getByShortUrlAndExpirationDate( shortUrlCode, currentDay).map(Url::getLongUrl);
        }

        return longUrl;
    }
}
