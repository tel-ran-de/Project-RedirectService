package de.telran.projectredirectservice.service;

import de.telran.projectredirectservice.model.Url;
import de.telran.projectredirectservice.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import static java.time.LocalDate.now;

@Service
public class RedirectService {
    final UrlRepository urlRepository;

    public RedirectService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }


    public Optional<String> getRedirectUrl(String shortUrlCode) {
        Optional<String> longUrl = Optional.empty();

        LocalDate currentDay = now();
        Optional<Url> optionalUrl = urlRepository.getByShortUrlAndExpirationDate( shortUrlCode, currentDay);

        if (optionalUrl.isPresent()) {
            longUrl =urlRepository.getByShortUrlAndExpirationDate( shortUrlCode, currentDay).map(Url::getLongUrl);
        }

        return longUrl;

    }

//    public Optional<Url> getRedirectUrl(String shortUrlCode) {
//        LocalDate currentDay = now();
//        Optional<Url> optionalUrl = urlRepository.getByShortUrlAndExpirationDate( shortUrlCode, currentDay);
//
//        if (optionalUrl.isPresent()) {
//            return optionalUrl;
//        } else {
//            return Optional.empty();
//        }
//    }
}
