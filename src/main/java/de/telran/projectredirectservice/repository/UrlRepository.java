package de.telran.projectredirectservice.repository;

import de.telran.projectredirectservice.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    @Query("select s from Url s where s.shortUrl = :shortUrlCode and s.expirationDate >=:currentDay")
    Optional<Url>getByShortUrlAndExpirationDate(@Param("shortUrlCode") String shortUrlCode,
                                                @Param("currentDay") LocalDateTime date);
    @Transactional
    @Modifying
    List<Url> deleteUrlByExpirationDateBefore(LocalDateTime date);

}
