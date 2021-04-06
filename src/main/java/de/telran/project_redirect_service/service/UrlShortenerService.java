package de.telran.project_redirect_service.service;

import de.telran.project_redirect_service.dto.UrlDto;
import de.telran.project_redirect_service.entity.Url;
import de.telran.project_redirect_service.repository.UrlRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static de.telran.project_redirect_service.service.ShortUrlGeneratorService.generateShortUrlString;

@Service
public class UrlShortenerService {

   private UrlValidator validator = new UrlValidator(new String[]{"http", "https"});

    @Autowired
    private UrlRepository urlRepository;

    public List<Url> getAllUrls() {
        return urlRepository.findAll();
    }

    public Url saveUrl(String url) {
        Url theUrl = new Url(generateShortUrlString(url), url, 0, createUrlExpirationDate());
        return urlRepository.save(theUrl);
    }

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



    private String createUrlExpirationDate() {
        LocalDateTime date = LocalDateTime.now().plusDays(3);
        System.out.println(LocalDateTime.now());
        return date.toString();
    }
}
