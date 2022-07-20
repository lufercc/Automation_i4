package com.automation;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Autentication {
    RequestSpecification requestSpecification;
    private static final String key = "a5c14264c267638eef4d4bc13e666b81";
    private static final String token = "165d955e1978e5d33f6d7333d71f2d38219f7795c8146a1056439233ed856c63";

    public Autentication(){
        requestSpecification = new RequestSpecBuilder().setBaseUri("https://api.trello.com")
                .addHeader("Content-Type","application/json")
                .addQueryParam("key", key )
                .addQueryParam("token", token)
                .build();
    }

    public RequestSpecification getRequestSpec(){
        return requestSpecification;
    }

}
