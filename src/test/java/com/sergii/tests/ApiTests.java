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
               .data(Data.builder().build())
               .support(Support.builder().build())
               .build();

       Assert.assertEquals(rootObject, expectedData, "Data are not equals");
    }

}
