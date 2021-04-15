package de.telran.project_redirect_service.service;

import de.telran.project_redirect_service.dto.LongUrlDto;
import de.telran.project_redirect_service.dto.UrlDto;
import de.telran.project_redirect_service.entity.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static de.telran.project_redirect_service.service.ShortUrlGeneratorService.generateShortUrlString;

@Service
public class CacheService {

    private Map<String, Url> cashedUrl = new HashMap<>();

    public String createShortUrl(Url url) {
        String shortUrl = null;
        for (Map.Entry<String, Url> entry : cashedUrl.entrySet()) {
            if (Objects.equals(url, entry.getValue())) {
                shortUrl = entry.getKey();
            }
        }
        if (shortUrl == null) {
            shortUrl = generateShortUrlString(url.getLongUrl());
            url.setShortUrl(shortUrl);
            cashedUrl.put(shortUrl, url);
        }

        return shortUrl;
    }

    public String getLongtUrl(String shortUrl) {
        String longUrl = cashedUrl.get(shortUrl).getLongUrl();
        if (longUrl != null) {
            return longUrl;
        }

        return null;
    }

}
