package com.automation.post;

import com.automation.Autentication;
import com.automation.Trello;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TrelloPost {

    RequestSpecification requestSpecification;
    String id;

    public TrelloPost(){
        requestSpecification = new Autentication().getRequestSpec();
    }

    @Test
    public void postScenario(){
        id = given().spec(requestSpecification)
                .log().all()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"name\": \"REST ASSURE _INTELLIJ\"" +
                        "}")
                .post("/1/boards")
                .then().extract().path("id");
    }

    @Test void Other(){
        given().header("Accept", "Application/json")
                .get("https://api.trello.com/1/boards/{id}");
    }

    @AfterEach
    public void deletBoard(){
        given().spec(requestSpecification).log().all()
                .delete("/1/boards/" + id)
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
