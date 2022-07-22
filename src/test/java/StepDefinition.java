import com.automation.RequestManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class StepDefinition {
    String endpoint;
    int statuscode;


    @Given("Send a request to {string}")
    public void sendARequestTo(String endpoint) {
        this.endpoint = endpoint;
    }

    @When("I send a {string} the request")
    public void iSendATheRequest(String method) {
        Response res = RequestManager.get(this.endpoint);
        this.statuscode = res.statusCode();
    }


    @Then("I expect {int}")
    public void iExpect(int statuscode) {
        Assertions.assertEquals(statuscode, this.statuscode, " the status code is nto equals");
    }
}
