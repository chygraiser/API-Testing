package com.sergii.tests;

import com.sergii.code.model.put.ResponsePut;
import com.sergii.code.model.get.Data;
import com.sergii.code.model.get.Root;
import com.sergii.code.model.get.Support;
import com.sergii.code.model.post.RootPost;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.restassured.RestAssured.given;
import static java.nio.file.Files.readAllBytes;

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

        byte[] body = readAllBytes(Path.of("/Users/Noname/IdeaProjects/API-Testing/src/test/resources/postCreateBody.json"));


        given()
                .body(body)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .log()
                .all();


    }

    @Step("API Testing")
    @Description("Smoke Test")
    @Epic("API Epic")
    @Story("POST Create Request Verification")
    @Feature("User register flow")
    @Severity(BLOCKER)
    @Issue("DEFECT-42345")
    @TmsLinks(value = {@TmsLink("TC-432"), @TmsLink("TC-434")})
    @Link(name = "JIRA", url = "https://www.atlassian.com/software/jira")
    @Owner(value = "Sergii Test")
    @Test
    public void verifyBodyOfPostCreate() throws IOException {

        byte[] body = readAllBytes(Path.of("/Users/Noname/IdeaProjects/API-Testing/src/test/resources/postCreateBody.json"));


        RootPost rootPostObject = given()
                .body(body)
                .when()
                .post("/api/users")
                .then()
                .extract()
                .as(RootPost.class);


        RootPost expectedData = RootPost.builder()
                .name("Test")
                .job("AQA")
                .id("2")
                .createdAt("2023-12-17T10:37:05.070Z")
                .build();

        addAttachment("Image20231215195005.jpg");


        Assert.assertEquals(rootPostObject, expectedData, "Data are not equals");

    }

    @Test
    public void putUpdate() throws IOException {

        byte[] body = readAllBytes(Path.of("/Users/Noname/IdeaProjects/API-Testing/src/test/resources/postCreateBody.json"));


        given()
                .body(body)
                .when()
                .put("/api/users/2")
                .then()
                .statusCode(200)
                .log()
                .all();

    }

    @Test
    public void verifyBodyOfPutUpdate() {

        ResponsePut rootObject = given()
                .when()
                .put("/api/users/2")
                .then()
                .extract()
                .as(ResponsePut.class);


        ResponsePut expectedData = ResponsePut.builder()
                .name("Test")
                .job("AQA")
                .updatedAt("2023-12-17T12:14:01.616Z")
                .build();


        Assert.assertEquals(rootObject, expectedData, "Data are not equals");
    }

    @Test
    public void deleteMethodCheck() throws IOException {


        given()
                .when()
                .delete("/api/users/2")
                .then()
                .statusCode(204)
                .log()
                .all();

    }

    @Test
    public void patchMethodCheck() throws IOException {

        byte[] body = readAllBytes(Path.of("/Users/Noname/IdeaProjects/API-Testing/src/test/resources/patchBody.json"));


        given()
                .when()
                .patch("/api/users/2")
                .then()
                .statusCode(200)
                .log()
                .all();

    }

    @Attachment
    public byte[] addAttachment(String fileName) throws IOException {
        return Files.readAllBytes(Path.of("/Users/Noname/IdeaProjects/API-Testing/src/test/resources/", fileName));
    }




}
