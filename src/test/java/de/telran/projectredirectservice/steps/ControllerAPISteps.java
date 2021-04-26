package de.telran.projectredirectservice.steps;

import de.telran.projectredirectservice.units.APITestHelper;
import io.cucumber.java8.En;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static de.telran.projectredirectservice.units.ApiUrls.urlShortenerAPIURL;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ControllerAPISteps extends APITestHelper implements En {

    public ControllerAPISteps() {
        When( "I make POST request for the endpoint 'urls'", () -> {
            response = given().contentType( "application/json" )
                    .body( createLongUrlWithExpDate() )
                    .when()
                    .post( urlShortenerAPIURL );
            shortUrlFromFirstResponse = response.getBody().jsonPath().getString( "urlShort" );
        } );

        Then( "I see status code {}", (Integer code) -> {
            Integer statusCode = response.getStatusCode();
            assertEquals( code, statusCode );
        } );

        And( "I see unique short url", () -> {
            response1 = given().contentType( "application/json" )
                    .body( createLongUrlWithWrongUrl() )
                    .when()
                    .post( urlShortenerAPIURL );
            shortUrlFromSecondResponse = response1.getBody().jsonPath().getString( "urlShort" );
            assertNotEquals( shortUrlFromFirstResponse, shortUrlFromSecondResponse );
        } );
    }
}
