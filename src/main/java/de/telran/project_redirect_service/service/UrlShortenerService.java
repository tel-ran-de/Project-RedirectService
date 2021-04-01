package de.telran.project_redirect_service.service;

import de.telran.project_redirect_service.dto.UrlDto;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UrlShortenerService {

    public String generateShortUrl(UrlDto urlDto) {
        String shortUrl = "hc" + urlDto.getLongUrl().hashCode();
        urlDto.setShortUrl(shortUrl);
        return shortUrl;

    }

    public String generateShortUrl(int customerNumber, String longUrl, Date expirationDate) {
        UrlDto urlDto = new UrlDto();
        urlDto.setCustomerNumber(customerNumber);
        urlDto.setLongUrl(longUrl);
        urlDto.setExpirationDate(expirationDate);
        return generateShortUrl(urlDto);
    }
}
