package de.telran.project_redirect_service.service;

import com.google.common.hash.Hashing;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Service
public class ShortUrlGeneratorService {

    private static UrlValidator validator = new UrlValidator(new String[]{"http", "https"});


    static protected String generateShortUrlString (String url) {
        String generatedShortUrl;
        if (validator.isValid(url) && url != null) {
            generatedShortUrl = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
        } else {
            return "Invalid url: " + url;
        }
        return generatedShortUrl;
    }

    public LocalDateTime createUrlExpirationDate(LocalDateTime expirationDate) {

        if (expirationDate == null) {
            return LocalDateTime.now().plusMinutes(3);  //with minutes for testing only
        } else {
            return LocalDateTime.parse(expirationDate.toString());
        }
    }
}
