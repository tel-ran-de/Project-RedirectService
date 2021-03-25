package de.telran.projectredirectservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LongUrlDto {
    public int customerNumber;
    public String longUrl;
    public String expirationDate;
}
