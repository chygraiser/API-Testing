package com.sergii.tests;

import com.sergii.code.model.get.Data;
import com.sergii.code.model.get.Root;
import com.sergii.code.model.get.Support;
import com.sergii.code.model.post.RootPost;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
    public void postCreate() throws IOException {

        byte[] body = Files.readAllBytes(Path.of("/Users/Noname/IdeaProjects/API-Testing/src/test/resources/postCreateBody.json"));


        given()
                .body(body)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .log()
                .all();


    }

    @Test
    public void verifyBodyOfPostCreate() throws IOException {

        byte[] body = Files.readAllBytes(Path.of("/Users/Noname/IdeaProjects/API-Testing/src/test/resources/postCreateBody.json"));


        RootPost rootPostObject = given()
                .body(body)
                .when()
                .post("/api/users")
                .then()
                .extract()
                .as(RootPost.class);


        RootPost expectedData = RootPost.builder()
                .name("morpheus")
                .job("leader")
                .id(2)
                .createdAt("2023-12-15T19:19:54.348Z")
                .build();


        Assert.assertEquals(rootPostObject, expectedData, "Data are not equals");
    }

}
