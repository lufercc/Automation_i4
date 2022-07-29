package com.automation.cucumbersteps.ui;

import com.automation.ui.driver.DriverManager;
import com.automation.ui.pages.AtlasianLoginPage;
import com.automation.ui.pages.TrelloLoginPage;
import com.automation.ui.pages.WorkSpacePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class TrelloStep {

    WebDriver driver;

    @Given("Abro trello")
    public void abroTrello() {
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://trello.com/login");
    }

    @When("pongo mi usuarion {string} y password {string}")
    public void pongoMiUsuarionYPassword(String login, String pwd) {
        TrelloLoginPage trelloLogin = new TrelloLoginPage();
        AtlasianLoginPage atlaLogin = trelloLogin.Login(login);
        atlaLogin.loginAtlasian(pwd);
    }

    @Then("Verifico que el logo de trello se muestra")
    public void verificoQueElLogoDeTrelloSeMuestra() {
        WorkSpacePage wspace = new WorkSpacePage();
        boolean itslogged = wspace.itsLoged();
        Assertions.assertTrue(itslogged, "The trello icon its not displayed, therefore the logging its not success");
    }
}



