package de.telran.projectredirectservice.service;

import de.telran.projectredirectservice.model.Url;
import de.telran.projectredirectservice.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class UrlShortenerService {
    private final UrlRepository urlRepository;
    private final GeneratorShortStringImp generatorString;

    public UrlShortenerService(UrlRepository urlRepository,
                               GeneratorShortStringImp generatorString) {
        this.urlRepository = urlRepository;
        this.generatorString = generatorString;
    }

    public Url create(String longUrl, int customerNumber, LocalDateTime expirationDate){
        Url url;
        String shortUrl=generatorString.generateShortUrl( longUrl );

        if(expirationDate==null){
            url=new Url(longUrl, customerNumber, LocalDateTime.now().plusDays(3), shortUrl);
        } else{
            url = new Url(longUrl, customerNumber, expirationDate, shortUrl);
        }
        return urlRepository.save( url );
    }
}
