package de.telran.projectredirectservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LongUrlDto {
    public int customerNumber;
    public String longUrl;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    public LocalDateTime expirationDate;
}
