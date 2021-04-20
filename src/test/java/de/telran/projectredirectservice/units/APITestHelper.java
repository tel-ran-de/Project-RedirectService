package de.telran.projectredirectservice.units;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;



public class APITestHelper {
    public String shortUrlFromFirstResponse;
    public String shortUrlFromSecondResponse;

    protected Response response;
    protected Response response1;
    Faker faker = new Faker();

    protected String createLongUrlWithExpDate() throws JSONException {
        LocalDateTime now=LocalDateTime.now();
        return new JSONObject().
                put( "longUrl", "https://www.google.com/search?q=ostern&rlz=1C5CHFA_enDE898DE898&source=lnms&tbm=isch&sa=X&ved=2ahUKEwin8pnEu-nvAhXXhP0HHT5tABgQ_AUoAXoECAEQBA&biw=1389&bih=697" )
                .put( "customerNumber", "45" )
                .put( "expirationDate", "2021-10-20T02:30:00").toString();

    }

    protected String createLongUrlWithExpDateInPast() throws JSONException {
        return new JSONObject().
                put( "longUrl", "https://www.google.com/search?q=ostern&rlz=1C5CHFA_enDE898DE898&source=lnms&tbm=isch&sa=X&ved=2ahUKEwin8pnEu-nvAhXXhP0HHT5tABgQ_AUoAXoECAEQBA&biw=1389&bih=697" )
                .put( "customerNumber", "333" )
                .put( "expirationDate", "2000-04-20T02:30:00").toString();

    }

    protected String createLongUrlWithWrongUrl() throws JSONException {
        return new JSONObject().
                put( "longUrl", "://www.google.com/search?q=ostern&rlz=1C5CHFA_enDE898DE898&source=lnms&tbm=isch&sa=X&ved=2ahUKEwin8pnEu-nvAhXXhP0HHT5tABgQ_AUoAXoECAEQBA&biw=1389&bih=697" )
                .put( "customerNumber", "333" )
                .put( "expirationDate", "2021-10-20T02:30:00").toString();
    }
}
