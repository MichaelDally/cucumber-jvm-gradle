package restassuredexample.cucumber;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import com.jayway.restassured.response.ValidatableResponse;
import org.junit.Test;
import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class InternationalSpaceStationCurrentLocationDefinition {

    public InternationalSpaceStationCurrentLocationDefinition() {
        RestAssured.baseURI = InternationalSpaceStationCurrentLocationConfiguration.OPEN_NOTIFY_API_URI;
    }

    public void requestInternationalSpaceStationCurrentLocation() {
        Response response;
        response = given().
                contentType("application/json").
                when().
                get("/iss-now/").
                then().
                statusCode(200).extract().response();
    }

    public void validateInternationalSpaceStationCurrentLocationContents() {
        Response response =
                given().
                        contentType("application/json").
                        when().
                        get("/iss-now/").
                        then().
                        body(containsString("iss_position")).
                        body(containsString("message")).
                        body(containsString("timestamp")).
                        body(("message"), equalTo("success")).
                        extract().response();
    }

    public void validateInternationalSpaceStationResponseTime(Long responseTime) {
        Response response =
                given().
                        contentType("application/json").
                        when().
                        get("/iss-now/").
                        then().
                        body(containsString("iss_position")).
                        body(containsString("message")).
                        body(containsString("timestamp")).
                        body(("message"), equalTo("success")).
                        and().time(lessThan(responseTime)).
                        extract().response();
        given().contentType("application/json").
                when().
                get("/iss-now/").asString();

    }
}
