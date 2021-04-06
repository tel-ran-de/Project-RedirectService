package de.telran.projectredirectservice.service;

import com.google.common.hash.Hashing;
import de.telran.projectredirectservice.model.Url;
import de.telran.projectredirectservice.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class UrlShortenerService {
    final UrlRepository urlRepository;

    public UrlShortenerService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public Url create(String longUrl, int customerNumber, String expirationDate){
        String shortUrl=generateShortUrl(longUrl);

        Url url = new Url(longUrl, customerNumber, expirationDate, shortUrl);
        return urlRepository.save( url );
    }

    private String generateShortUrl(String longUrl){
        return Hashing.murmur3_32()
                .hashString( longUrl, StandardCharsets.UTF_8 )
                .toString();
    }
}
