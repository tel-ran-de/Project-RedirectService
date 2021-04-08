package de.telran.project_redirect_service.service;

import de.telran.project_redirect_service.dto.LongUrlDto;
import de.telran.project_redirect_service.dto.UrlDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class CacheService {

    private Map<String, UrlDto> cashedUrl = new HashMap<>();

    public String createShortUrl(UrlDto urlDto){

        for (Map.Entry<String, UrlDto> entry : cashedUrl.entrySet()){
            if (Objects.equals(urlDto, entry.getValue())){
                return entry.getKey();
            }

        }
        return null;
    }

    public String getLongtUrl(String shortUrl){
        String longUrl = cashedUrl.get(shortUrl).getLongUrl();
        if (longUrl!=null){
            return longUrl;
        }

        return null;
    }

}
