package de.telran.projectredirectservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "urls")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "short_url")
    @Setter
    private String shortUrl;

    @Lob
    @Column(name = "long_url", length =5000 )
    @Setter
    private String longUrl;

    @Column(name = "customer_number")
    @Setter
    private int customerNumber;

    @Column(name = "expiration_date", columnDefinition = "DATE")
    @Setter
    public LocalDateTime expirationDate;

    public Url(String longUrl, int customerNumber, LocalDateTime expirationDate, String shortUrl) {
        this.longUrl = longUrl;
        this.customerNumber = customerNumber;
        this.expirationDate = expirationDate;
        this.shortUrl=shortUrl;
    }
}
