package de.telran.project_redirect_service.service;

import java.util.Optional;

public interface RedirectService {

    Optional<String> getRedirectUrl(String shortUrl);
}
