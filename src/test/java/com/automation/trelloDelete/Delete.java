package com.automation.trelloDelete;

import com.automation.Autentication;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Delete {
    RequestSpecification requestSpecification;
    String id;

    public Delete(){
        requestSpecification = new Autentication().getRequestSpec();
    }

    @BeforeEach
    public void createBoard(){
        id = given().spec(requestSpecification)
                .log().all()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"name\": \"REST ASSURE _INTELLIJ\"" +
                        "}")
                .post("/1/boards")
                .then().extract().path("id");
    }


    @Test
    public void deleteBoard(){
        given().spec(requestSpecification).log().all()
                .delete("/1/boards/" + id)
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
