package com.sergii.tests;

import com.sergii.code.model.Data;
import com.sergii.code.model.Root;
import com.sergii.code.model.Support;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
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

       Root rootObject = given()
                .when()
                .get("/api/unknown/2")
                .then()
                .extract()
                .as(Root.class);


       Root expectedData = Root.builder()
               .data(Data.builder()
                       .id(2).name("fuchsia rose")
                       .year(2001)
                       .color("#C74375")
                       .pantone_value("17-2031")
                       .build())
               .support(Support.builder()
                       .url("https://reqres.in/#support-heading")
                       .text("To keep ReqRes free, contributions towards server costs are appreciated!")
                       .build())
               .build();


       Assert.assertEquals(rootObject, expectedData, "Data are not equals");
    }


    @Test
    public void postCreate() {

        given()
                .body()
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .log()
                .all();


    }

}
