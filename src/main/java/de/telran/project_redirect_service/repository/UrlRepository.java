package de.telran.project_redirect_service.repository;

import de.telran.project_redirect_service.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    Url findByShortUrl(String shortUrl);

    @Transactional
    Integer deleteUrlByExpirationDateBefore(LocalDateTime currentDate);

    Optional<Url> findByShortUrlAndExpirationDateAfter(String shortUrl, LocalDateTime localDateTime);

    Optional<Url> deleteByExpirationDateBefore(LocalDateTime localDateTime);

}
