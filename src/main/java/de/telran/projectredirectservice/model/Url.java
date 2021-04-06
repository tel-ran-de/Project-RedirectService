package de.telran.projectredirectservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.security.Timestamp;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "urls")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "short_url")
    @Setter
    private String shortUrl;

    @Column(name = "long_url")
    @Setter
    private String longUrl;

    @Column(name = "customer_number")
    @Setter
    private int customerNumber;

    @Column(name = "expiration_date")
    @Setter
    public String expirationDate;

    public Url(String longUrl, int customerNumber, String expirationDate, String shortUrl) {
        this.longUrl = longUrl;
        this.customerNumber = customerNumber;
        this.expirationDate = expirationDate;
        this.shortUrl=shortUrl;
    }
}
