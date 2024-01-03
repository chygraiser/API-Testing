package com.sergii.stepdef;

import com.sergii.code.model.get.Root;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.testng.reporters.Files.readFile;

public class GetSteps {
    
    private Root result;
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

        result = given()
                .when()
                .get("/api/unknown/2")
                .then()
                .extract()
                .as(Root.class);

    }
    @Then("User get user data")
    public void user_get_user_data(String file) {
        Root expected = readFile(file, Root.class);
        Assert.assertEquals(result, expected, "Data are not equals");

    }
}
