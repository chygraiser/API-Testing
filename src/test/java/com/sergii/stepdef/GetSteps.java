package com.sergii.stepdef;

import com.sergii.code.model.get.Data;
import com.sergii.code.model.get.Root;
import com.sergii.code.model.get.Support;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class GetSteps {
    
    private Root actualResult;
    private static final ObjectMapper MAPPER = new ObjectMapper() {
        @Override
        public Object deserialize(ObjectMapperDeserializationContext objectMapperDeserializationContext) {
            return null;
        }

        @Override
        public Object serialize(ObjectMapperSerializationContext objectMapperSerializationContext) {
            return null;
        }
    };

    @When("I sent request to user API")
    public void i_sent_request_to_user_api() {

        actualResult = given()
                .spec(getRequestSpecification("https://reqres.in/"))
                .when()
                .get("/api/unknown/2")
                .then()
                .extract()
                .as(Root.class);

    }
    @Then("User get {string} user data")
    public void user_get_user_data(String file) {
       Root expectedResult = Root.builder()
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


        Assert.assertEquals(actualResult, expectedResult, "Data are not equals");
    }

    @Then("^User get (.*) user data diff files$")
    public void user_get_body_json_user_data_diff_files(String file) {
        Root expectedResult = Root.builder()
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


        Assert.assertEquals(actualResult, expectedResult, "Data are not equals");
    }


  /*  private String readFile(String file, Class<Root> rootClass) {
        return this.readFile(file,rootClass);
    }*/


    protected RequestSpecification getRequestSpecification(String host) {

        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(host)
                .build();
    }

}
