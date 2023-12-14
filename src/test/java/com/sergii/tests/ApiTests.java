package com.sergii.tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTests {

    @Test
    public void getSingleResource() {

        given()
                .baseUri("https://reqres.in/")
                .contentType(ContentType.JSON)
                .when()
                .get("/api/unknown/2")
                .then()
                .statusCode(200)
                .log()
                .all();


    }

}
