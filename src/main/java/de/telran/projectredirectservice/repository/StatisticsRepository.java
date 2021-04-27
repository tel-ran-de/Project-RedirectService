package de.telran.projectredirectservice.repository;

import de.telran.projectredirectservice.model.RedirectStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StatisticsRepository extends JpaRepository<RedirectStatistics, Long> {

    @Transactional
    @Modifying
    @Query("update RedirectStatistics r set r.counter=:counter where r.shortUrl=:shourtUrl and r.longUrl=:longUrl")
    void updateCounterForRedirectStatistics(@Param("short_url") String shortUrl,
                                            @Param("long_url") String longUrl,
                                            @Param("counter") Long counter);

    List<RedirectStatistics>findTop3ByOrderByCounterDesc();


}
