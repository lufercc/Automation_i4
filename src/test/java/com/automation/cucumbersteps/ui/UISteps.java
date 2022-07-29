package com.automation.cucumbersteps.ui;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UISteps {
    WebDriver driver;

//    @After
//    public void closeDriver(){
//        driver.quit();
//    }

    @When("I go to {string}")
    public void iGoTo(String pageUrl) {
        driver.get(pageUrl);
    }

    @Given("I Open The Browser")
    public void iOpenTheBrowser() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
    }

    @Then("Verifico que la URL sea {string}")
    public void verificoQueLaURLSea(String expecURL) {
        String actualURL = driver.getCurrentUrl();
        Assertions.assertEquals(expecURL, actualURL, "The URL no match");
    }
}
