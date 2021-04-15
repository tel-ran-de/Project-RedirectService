package de.telran.project_redirect_service.service;

import de.telran.project_redirect_service.entity.Url;

import java.time.LocalDateTime;
import java.util.List;


public interface UrlShortnerService {

     List<Url> getAllUrls();

     Url createUrl(String longUrl,Long customerNumber, LocalDateTime expirationDate);

     Url getUrl(Long id);

     void deleteUrl(Long id);

}
