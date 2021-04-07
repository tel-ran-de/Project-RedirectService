package de.telran.project_redirect_service.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UrlDto {

    @Id
    private int id;
    private String longUrl;
    private String shortUrl;
    private int customerNumber;
    private Date expirationDate;
}
