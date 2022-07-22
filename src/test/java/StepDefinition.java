import com.automation.RequestManager;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class StepDefinition {
    String endpoint;
    int statuscode;
    String body;
    String id;

    @After("@createBoard")
    public void deleteBoard() {
        RequestManager.delete("/1/boards/" + id);
    }

    @Given("Como usuario quiero usar este endpoint {string}")
    public void sendARequestTo(String endpoint) {
        this.endpoint = endpoint;
    }

    @And("I have the body {string}")
    public void iHaveTheBody(String body) {
        this.body = body;
    }

    @When("I send a {string} the request")
    public void iSendATheRequest(String method) {
        if (method.equalsIgnoreCase("GET")) {
            Response res = RequestManager.get(this.endpoint);
            this.statuscode = res.statusCode();
        }
        if (method.equalsIgnoreCase("POST")) {
            Response response = RequestManager.post(this.endpoint, body);
            this.statuscode = response.statusCode();
            this.id = response.then().extract().path("id");
        }
    }


    @Then("I expect the status code is {int}")
    public void iExpect(int statuscode) {
        Assertions.assertEquals(statuscode, this.statuscode, " the status code is nto equals");
    }


}
