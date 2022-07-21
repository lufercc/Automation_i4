package com.automation.trelloGet;

import com.automation.Autentication;
import com.automation.RequestManager;
import com.automation.trelloObjects.Board;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Get {
    RequestSpecification requestSpecification;
    Board board1;

    public Get() {
        requestSpecification = new Autentication().getRequestSpec();
    }

    @BeforeEach
    public void createBoard(){
        Response res = RequestManager.post("/1/boards", "{\"name\" : \"RequestManagerTest\"}");
        res.then().log().all();
        board1 = res.as(Board.class);
    }

    @Test
    public void getBoard() {
        Response res = RequestManager.get("/1/boards/" + board1.getId());
        res.then().log().all().statusCode(200);
        Board board2 = res.as(Board.class);
        Assertions.assertEquals("RequestManagerTest", board2.getName());
        Assertions.assertFalse(!board2.isClosed(), "The board its closed");
    }

    @AfterEach
    public void deleteBoard() {
        Response res = RequestManager.delete("/1/boards/" + board1.getId());
    }
}
