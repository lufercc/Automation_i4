package com.automation.ui.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrelloLoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='user']")
    private WebElement userInput;

    @FindBy(xpath = "//input[@id='login']")
    private WebElement loginButton;

    public TrelloLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void Login(String userName){
        userInput.sendKeys(userName);
        loginButton.click();
    }
}
