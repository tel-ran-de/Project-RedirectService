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
import java.util.Optional;

import static de.telran.project_redirect_service.service.ShortUrlGeneratorService.generateShortUrlString;

@Service
public class UrlShortenerServiceImpl implements UrlShortnerService{

    private UrlValidator validator = new UrlValidator(new String[]{"http", "https"});

    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private CacheService cacheService;

    @Autowired
    private ShortUrlGeneratorService shortUrlGeneratorService;

    @Override
    public List<Url> getAllUrls() {
        return urlRepository.findAll();
    }

    @Override
    public Url createUrl(String longUrl,Long customerNumber, LocalDateTime expirationDate) {

        Url url = new Url(shortUrlGeneratorService.generateShortUrlString(longUrl),
                longUrl, 0, shortUrlGeneratorService.createUrlExpirationDate(expirationDate));
        return urlRepository.save(url);

    }

    @Override
    public Url getUrl(Long id) {
        Url url;
        Optional<Url> optionalUrl = urlRepository.findById(id);
        if (optionalUrl.isPresent()) {
            url = optionalUrl.get();
        } else {
            throw new RuntimeException("Url not found.");
        }
        return url;
    }

    @Override
    public void deleteUrl(Long id) {
        urlRepository.deleteById(id);
    }
}
