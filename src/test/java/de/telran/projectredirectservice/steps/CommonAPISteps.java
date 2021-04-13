package de.telran.projectredirectservice.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import static de.telran.projectredirectservice.units.ApiUrls.redirectAPIUrl;
import static de.telran.projectredirectservice.units.ApiUrls.urlShortenerAPIURL;
import static io.restassured.RestAssured.given;

public class CommonAPISteps {
    public String codeShortUrl;

    @Test
    public void successfulScenario_extractCodeShortUrlFromUrlShortenerEndpoint_thenRedirectEndpoint_test() throws JSONException {

        Map<String, String> request = new HashMap<>();
        request.put("longUrl", "https://www.google.com/search?q=ostern&rlz=1C5CHFA_enDE898DE898&source=lnms&tbm=isch&sa=X&ved=2ahUKEwin8pnEu-nvAhXXhP0HHT5tABgQ_AUoAXoECAEQBA&biw=1389&bih=697");
        request.put("customerNumber", "333");
        request.put("expirationDate", "2021-04-20T02:30:00");


        codeShortUrl=given().contentType("application/json")
                .body(request)
                .when()
                .post(urlShortenerAPIURL)
                .then()
                .assertThat()
                .statusCode( 200)
                .extract()
                .path("urlShort");

        given().redirects().follow( false ).when().get( redirectAPIUrl+codeShortUrl ).then()
                .statusCode( 302 );
    }
}
