package de.telran.projectredirectservice.service;

import de.telran.projectredirectservice.model.Url;
import de.telran.projectredirectservice.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UrlShortenerService {
    private final UrlRepository urlRepository;
    private final GeneratorShortStringImp generatorString;

    public UrlShortenerService(UrlRepository urlRepository,
                               GeneratorShortStringImp generatorString) {
        this.urlRepository = urlRepository;
        this.generatorString = generatorString;
    }

    public Url create(String longUrl, int customerNumber, String expirationDate){
        Url url;
        String shortUrl=generatorString.generateShortUrl( longUrl );

        if(expirationDate==null){
            url=new Url(longUrl, customerNumber, LocalDate
                    .parse(expirationDate)
                    .plusDays(3), shortUrl);
        } else{
            url = new Url(longUrl, customerNumber, LocalDate.parse( expirationDate ), shortUrl);
        }
        return urlRepository.save( url );
    }
}
