package com.sergii.tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


    @BeforeMethod
    protected void initTest() {

        RestAssured.baseURI = "https://reqres.in/";

    }

    protected RequestSpecification getRequestSpecification(String host) {

        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(host)
                .build();
    }

    protected RequestSpecification getRequestSpecificationWithHeaders(String host, String headerKey, String headerValue) {

        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(host)
                .build();
    }

    protected ResponseSpecification getResponseSpecification(String host) {

        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .build();
    }
}
