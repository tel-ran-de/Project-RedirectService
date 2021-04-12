package de.telran.projectredirectservice.service;

import com.google.common.hash.Hashing;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Component
public class GeneratorShortStringImp implements GeneratorShortString{
    @Override
    public String generateShortUrl(String longUrl) {
//        return Hashing.murmur3_32()
//                .hashString( longUrl, StandardCharsets.UTF_8 )
//                .toString();
        return UUID.randomUUID().toString();
    }
}
