package com.automation.cucumbersteps;

import com.automation.api.Helper;
import com.automation.api.RequestManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    Helper helper;

    public Hook(Helper helper) {
        this.helper = helper;
    }

    @After("@deleteB or @deleteA")
    public void deleteBoard() {
        RequestManager.delete("/1/boards/" + this.helper.res.then().extract().path("id"));
    }

    @Before("@newBoard")
    public void CreateNewBoard() {
        this.helper.res = RequestManager.post("/1/boards/", "{\"name\" : \"CREATEDFROMHOOK\"}");
    }
}
