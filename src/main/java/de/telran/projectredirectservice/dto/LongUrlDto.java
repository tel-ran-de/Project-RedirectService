package de.telran.projectredirectservice.dto;

import de.telran.projectredirectservice.validator.ValidatorExpirationDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@ValidatorExpirationDate
public class LongUrlDto {
    public int customerNumber;

    @URL(message = "Insert the valid url")
    public String longUrl;

    public LocalDateTime expirationDate;
}
