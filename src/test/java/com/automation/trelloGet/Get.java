package com.automation.trelloGet;

import com.automation.Autentication;
import com.automation.RequestManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Get {
    RequestSpecification requestSpecification;
    String id;
    public Get() {
        requestSpecification = new Autentication().getRequestSpec();
    }

    @BeforeEach
    public void createBoard(){
        Response res = RequestManager.post("/1/boards", "{\"name\" : \"RequestManagerTest\"}");
        id = res.then().extract().path("id");
    }

    @Test
    public void getBoard() {
        Response res = RequestManager.get("/1/boards/" + id);
        res.then().log().all().statusCode(200);
    }

    @AfterEach
    public void deleteBoard() {
        Response res = RequestManager.delete("/1/boards/" + id);
    }
}
