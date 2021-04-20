package de.telran.projectredirectservice.service;

import de.telran.projectredirectservice.model.Url;
import de.telran.projectredirectservice.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UrlShortenerService {
    private final UrlRepository urlRepository;
    private final GeneratorShortStringImp generatorString;
    private final CacheService cacheService;

    public UrlShortenerService(UrlRepository urlRepository,
                               GeneratorShortStringImp generatorString, CacheService cacheService) {
        this.urlRepository = urlRepository;
        this.generatorString = generatorString;
        this.cacheService = cacheService;
    }

    /**
     * @param longUrl
     * @param customerNumber
     * @param expirationDate
     * the method add the shortURL to database. The shortURL should be first generated in CacheService
     */
    public Url create(String longUrl, int customerNumber, LocalDateTime expirationDate){
        Url url=new Url();

        if(expirationDate==null){
            url=new Url(longUrl, customerNumber, LocalDateTime.now().plusDays(3), null );
            String shortUrl=cacheService.createShortUrl( url );
            url.setShortUrl(shortUrl);// save in cache

        } else{
            url = new Url(longUrl, customerNumber, expirationDate, null);
            String shortUrl=cacheService.createShortUrl( url );
            url.setShortUrl(shortUrl);// save in cache
        }

        return urlRepository.save( url );
    }
}
