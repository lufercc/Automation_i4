package com.automation.cucumbersteps;

import com.automation.api.Helper;
import com.automation.api.RequestManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class StepDefinition {
    Helper helper;

    public StepDefinition(Helper helper){
        this.helper = helper;
    }


    @Given("Como usuario quiero usar este endpoint {string}")
    public void sendARequestTo(String endpointParam) {
        if (endpointParam.contains("[[")){
            this.helper.endpoint = endpointParam.replace("[[id]]",
                    this.helper.res.then().extract().path("id"));
        } else {
            this.helper.endpoint = endpointParam;
        }
    }

    @And("I have the body {string}")
    public void iHaveTheBody(String body) {
        this.helper.body = body;
    }

    @When("I send a {string} the request")
    public void iSendATheRequest(String method) {
        if (method.equalsIgnoreCase("GET")) {
            Response res = RequestManager.get(this.helper.endpoint);
            this.helper.res = res;
        }
        if (method.equalsIgnoreCase("POST")) {
            Response response = RequestManager.post(this.helper.endpoint, helper.body);
            this.helper.res = response;
        }
        if (method.equalsIgnoreCase("DELETE")){
            Response response = RequestManager.delete(this.helper.endpoint);
            this.helper.res = response;
        }
    }

    @Then("I expect the status code is {int}")
    public void iExpect(int statuscode) {
        Assertions.assertEquals(statuscode, this.helper.res.statusCode(), " the status code is nto equals");
    }


    @And("I expect the name is {string}")
    public void iExpectTheNameIs(String nameParam) {
        Assertions.assertEquals(nameParam, this.helper.res.then().extract().path("name"));
    }
}
