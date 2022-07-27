package com.automation.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrelloTest {
    WebDriver driver;


    @BeforeEach
    public void startChrome(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
    }

    @AfterEach
    public void teardown(){
//        driver.quit();
    }

    @Test
    public void loginTrello() throws InterruptedException {
        driver.get("https://trello.com/login");
        String userLoc = "//input[@id='user']";
        String pwLoc = "//input[@id='password']";
        String loginButtonLoc = "//input[@id=\"login\"]";////input[@id="login"]
        String atlacionLoginButton = "//button[@id='login-submit']";

        driver.findElement(By.xpath(userLoc)).sendKeys("autotester248@gmail.com");
        driver.findElement(By.xpath(loginButtonLoc)).click();
        Thread.sleep(1500);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(By.xpath(pwLoc)).sendKeys("password");
        driver.findElement(By.xpath(atlacionLoginButton)).click();
    }
}
