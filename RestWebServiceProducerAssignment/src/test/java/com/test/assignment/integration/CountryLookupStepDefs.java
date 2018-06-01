package com.test.assignment.integration;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CountryLookupStepDefs {

    @LocalServerPort
    private int port;

    private Response countryNameResponse;

    private Response countryCodeResponse;

    @When("^The user gives the following \"([^\"]*)\"$")
    public void the_user_gives_the_following(String ipAddress) {

        RestAssured.baseURI = "http://localhost:" + port;
        countryNameResponse =
                when().
                    get("/countryName/{ipAddress}", ipAddress).
                then().
                    assertThat().
                    statusCode(200).extract().response();

        countryCodeResponse =
                when().
                    get("/countryCode/{ipAddress}", ipAddress).
                then().
                    assertThat().
                    statusCode(200).extract().response();

    }

    @Then("^The user should get the country name as \"([^\"]*)\"$")
    public void the_user_should_get_the_country_name_as(String countryName) {
        assertThat(countryNameResponse.getBody().asString()).isEqualTo(countryName);
    }

    @Then("^The user should get the country code as \"([^\"]*)\"$")
    public void the_user_should_get_the_country_code_as(String countryCode) {
        assertThat(countryCodeResponse.getBody().asString()).isEqualTo(countryCode);
    }
}
