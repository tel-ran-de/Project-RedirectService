package de.telran.projectredirectservice.service;

import com.google.common.hash.Hashing;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class RedirectService {

    public String create(String longUrl) {
        String hash_id = Hashing.murmur3_128()
                .hashString( longUrl, StandardCharsets.UTF_8 )
                .toString();

        String shortUrl = "server/urls/" + hash_id;
        // should be added "save" method (insert in the bd, table "urls")
        return shortUrl;
    }

    public String getLongURL(String url_code) {
        String longUrl = " "; //get from bd LongUrl by url_code
        return longUrl;
    }
}
