package de.telran.projectredirectservice.service;

import de.telran.projectredirectservice.model.Url;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheService {

    private final GeneratorShortStringImp generatorShortStringImp;
    private Map<String, Url> cacheMap = new HashMap<>();

    public CacheService(GeneratorShortStringImp generatorShortStringImp) {
        this.generatorShortStringImp = generatorShortStringImp;
    }

    /**
     * @param url
     * this method generate shortUrl and put data into cache
     * @return String shortUrl
     */
    public String createShortUrl(Url url) {
        String shortUrl = generatorShortStringImp.generateShortUrl( url.getLongUrl() );
        url.setShortUrl( shortUrl );
        cacheMap.put( shortUrl, url );

        return shortUrl;
    }

    /**
     * @param shortURl
     * this method return the long URL from the cacheMap
     * @return String Long URL or null
     */

    public String getLongUrl(String shortURl) {
        return cacheMap.get( shortURl ).getLongUrl();
    }
}
