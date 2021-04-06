package de.telran.project_redirect_service.repository;

import de.telran.project_redirect_service.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    Url findByShortUrl(String shortUrl);

    Optional<Url> findByShortUrlAndExpirationDateAfter(String shortUrl, LocalDateTime localDateTime);

    Optional<Url> deleteByExpirationDateBefore(LocalDateTime localDateTime);

//    @Query("select * from url ")
//    Url findByShortUrlWithExpirationDate(
//            String shortUrl,
//            @Param("expirationDate") String expirationDate);
}
