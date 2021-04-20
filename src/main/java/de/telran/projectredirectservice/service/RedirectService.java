package de.telran.projectredirectservice.service;

import de.telran.projectredirectservice.model.Url;
import de.telran.projectredirectservice.repository.UrlRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RedirectService {
    private final UrlRepository urlRepository;
    private final CacheService cacheService;
    static Logger logger = LogManager.getLogger(WorkSchedule.class);

    public RedirectService(UrlRepository urlRepository, CacheService cacheService) {
        this.urlRepository = urlRepository;
        this.cacheService = cacheService;
    }

    /**
     * @param shortUrlCode
     * the method return first of all the Long URL from cache, if cache return null  - read in database;
     * @return longUrl
     */
    public Optional<String> getRedirectUrl(String shortUrlCode) {

        Optional<String> longUrl = Optional.ofNullable( cacheService.getLongUrl( shortUrlCode ) );

        if (longUrl.isPresent()){
            longUrl=Optional.of(cacheService.getLongUrl( shortUrlCode ));
            logger.info( "Long url was read from cache: "+longUrl );
        } else{
            LocalDateTime currentDay = LocalDateTime.now();
            longUrl =urlRepository.getByShortUrlAndExpirationDate( shortUrlCode, currentDay).map(Url::getLongUrl);
        }
        return longUrl;
    }
}
