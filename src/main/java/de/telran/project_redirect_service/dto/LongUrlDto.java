package de.telran.project_redirect_service.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class LongUrlDto {

    @Id
    private long id;
    private String longUrl;
    private int customerNumber;
    private LocalDateTime expirationDate;

}
