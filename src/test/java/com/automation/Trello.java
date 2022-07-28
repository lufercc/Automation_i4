package com.automation;

import com.automation.api.core.Autentication;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Trello {

    RequestSpecification requestSpecification;

    Trello(){
        requestSpecification = new Autentication().getRequestSpec();
    }
    @Test
    public void getAllBoard(){
        given().spec(requestSpecification).log().all()
                .get("/1/members/me/boards")
                .then().log().all();
    }

    @Test
    public void CrateBoard(){
        given().spec(requestSpecification)
                .log().all()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"name\": \"Created from IntelliJ\"" +
                        "}")
                .post("/1/boards")
                .then().log().all().statusCode(200);
    }


}
