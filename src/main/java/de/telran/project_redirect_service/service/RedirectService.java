package de.telran.project_redirect_service.service;

import com.google.common.hash.Hashing;
import de.telran.project_redirect_service.dto.ShortUrlDto;
import de.telran.project_redirect_service.entity.Url;
import de.telran.project_redirect_service.repository.UrlRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class RedirectService {

    @Autowired
    private UrlRepository urlRepository;

    private Url url;

    //Do not redirect to expired links

    public Optional<String> getRedirectUrl(String shortUrl) {
        Optional<String> longUrl = Optional.empty();
        if (!shortUrl.isEmpty()) {
            url = urlRepository.findByShortUrl(shortUrl);
            if (LocalDateTime.parse(url.getExpirationDate()).isAfter(LocalDateTime.now())) {
                longUrl = Optional.of(url.getLongUrl());
            }
        }
        return longUrl;
    }

    //2 way
    public Optional<String> getRedirectUrl2(String shortUrl) {
        Optional<String> longUrl = Optional.empty();
        if (!shortUrl.isEmpty()) {
            longUrl = urlRepository.findByShortUrlAndExpirationDateAfter(shortUrl, LocalDateTime.now()).map(Url::getLongUrl);
        }
        return longUrl;
}

}
