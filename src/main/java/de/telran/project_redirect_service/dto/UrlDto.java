package de.telran.project_redirect_service.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
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
    private Long id;
    private String longUrl;
    private String shortUrl;
    private int customerNumber;
    private LocalDateTime expirationDate;
}
