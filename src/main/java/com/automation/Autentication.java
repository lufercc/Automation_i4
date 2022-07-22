package com.automation;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Autentication {
    RequestSpecification requestSpecification;
    private static final String key = "0bfc5b1373158a43175bdc1b315fd3e4";
    private static final String token = "c38ec3003ecfe94785f3151072cffc66cb0b6f95045ac349d0cb8ba1440a7cc1";

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

    private RequestSpecification buildSpecWithToken(){
        String token = RequestManager.post("token", "{user:test, pw: test}").then().extract().path("token");
        return requestSpecification = new RequestSpecBuilder().setBaseUri("https://api.trello.com")
                .addHeader("Content-Type","application/json")
                .addHeader("Authorixation", token)
                .addQueryParam("key", key )
                .addQueryParam("token", token)
                .build();
    }

}
