package de.telran.projectredirectservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Statistics")
public class RedirectStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "short_url")
    private String shortUrl;

    @Lob
    @Column(name = "long_url", length =5000 )
    private String longUrl;

    @Column(name="counter")
    private Long counter;

    public RedirectStatistics(@NonNull String shortUrl, @NonNull String longUrl, Long counter) {
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
        this.counter = counter;
    }
}
