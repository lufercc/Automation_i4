package com.automation.ui;

import com.automation.ui.driver.DriverManager;
import com.automation.ui.pages.AtlasianLoginPage;
import com.automation.ui.pages.TrelloLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrelloTest {
    WebDriver driver;


    @BeforeEach
    public void startChrome(){
        this.driver = DriverManager.getInstance().getDriver();
    }

    @AfterEach
    public void teardown(){
        this.driver.quit();
    }

    @Test
    public void loginTrello() throws InterruptedException {
        driver.get("https://trello.com/login");
        String userLoc = "//input[@id='user']";
        String pwLoc = "//input[@id='password']";
        String loginButtonLoc = "//input[@id=\"login\"]";////input[@id="login"]
        String atlacionLoginButton = "//button[@id='login-submit']";

        //
//        String trelloLabel = "//div[text()= 'Trello']";

        driver.findElement(By.xpath(userLoc)).sendKeys("autotester248@gmail.com");
        driver.findElement(By.xpath(loginButtonLoc)).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(atlacionLoginButton)));
        driver.findElement(By.xpath(pwLoc)).sendKeys("password");
        driver.findElement(By.xpath(atlacionLoginButton)).click();
    }

    @Test
    public void loginTrello2() throws InterruptedException {
        driver.get("https://trello.com/login");
        TrelloLoginPage trelloLogin = new TrelloLoginPage();
        AtlasianLoginPage atlaLogin = trelloLogin.Login("autotester248@gmail.com");
        atlaLogin.loginAtlasian("password");
    }
}
