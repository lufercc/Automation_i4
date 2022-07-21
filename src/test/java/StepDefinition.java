import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {


    @Given("Send a request to {string}")
    public void sendARequestTo(String arg0) {
        System.out.println("111111");
    }

    @When("I send a {string} the request")
    public void iSendATheRequest(String arg0) {
        System.out.println("22222222");

    }


    @Then("I expect {string}")
    public void iExpect(String arg0) {
        System.out.println("33333");
    }
}
