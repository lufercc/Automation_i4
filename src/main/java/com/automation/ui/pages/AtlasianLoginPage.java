package com.automation.ui.pages;

import com.automation.ui.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AtlasianLoginPage {
    WebDriver driver;
    WebDriverWait wait;


    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@id='login-submit']")
    private WebElement loginButton;

    public AtlasianLoginPage(){
        this.driver = DriverManager.getInstance().getDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofMillis(3000));
        PageFactory.initElements(driver, this);
        waitLoading();
    }

    private void waitLoading(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
    }

    public WorkSpacePage loginAtlasian(String pw){
        passwordInput.sendKeys(pw);
        loginButton.click();
        return new WorkSpacePage();
    }

}
