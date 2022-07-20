package com.automation;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RestTest {

    @Test
    public void test() {

        given().log().all()
                .get("https://reqres.in/api/users/1")
                .then().log().all().statusCode(200);

    }

    @Test
    public void simpleTest() {

        given().baseUri("https://reqres.in")
                .log().all()
                .get("/api/users/1")
                .then().log().all().statusCode(200);

    }

    @Test
    public void verifyallUsers() {
        given().log().all()
                .get("https://reqres.in/api/users")
                .then().log().all().statusCode(200);
    }

    @Test
    public void createUser(String token) {
        given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"email\": \"george.bluth@reqres.in\",\n" +
                        "    \"name\": \"George\",\n" +
                        "    \"job\": \"Carpenter\"\n" +
                        "}")
                .post("https://reqres.in/api/users")
                .then().log().all().statusCode(201);
    }
}
