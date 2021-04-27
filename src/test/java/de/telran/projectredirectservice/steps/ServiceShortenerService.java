package de.telran.projectredirectservice.steps;

import de.telran.projectredirectservice.units.APITestHelper;
import io.cucumber.java8.En;

import static de.telran.projectredirectservice.units.ApiUrls.urlShortenerAPIURL;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceShortenerService extends APITestHelper implements En {
    public ServiceShortenerService() {
        When( "I make POST request for the endpoint 'urls' with date in the past", () -> {
            response = given().contentType( "application/json" )
                    .body( createLongUrlWithExpDateInPast() )
                    .when()
                    .post( urlShortenerAPIURL );
        } );

        Then( "I see http status code {}", (Integer code) -> {
            Integer statusCode = response.getStatusCode();
            assertEquals( code, statusCode );
        } );

        When( "I make POST request for the endpoint 'urls' with url without pattern http or https", () -> {
            response = given().contentType( "application/json" )
                    .body( createLongUrlWithExpDateInPast() )
                    .when()
                    .post( urlShortenerAPIURL );
        } );

        Then( "I see http Bad Request  status code {}", (Integer code) -> {
            Integer statusCode = response.getStatusCode();
            assertEquals( code, statusCode );
        } );


    }

}
