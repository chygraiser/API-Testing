package com.sergii.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTests extends BaseTest {

    @Test
    public void getSingleResource() {

        given()
                /*.spec(getRequestSpecification("https://reqres.in/"))*/
                .when()
                .get("/api/unknown/2")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void verifyBodyOfGetSingleResource() {

        given()
                /*.spec(getRequestSpecification("https://reqres.in/"))*/
                .when()
                .get("/api/unknown/2")
                .then()
                .extract()
                .body()
                .jsonPath().get();

    }

}
