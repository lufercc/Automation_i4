package com.automation.ui.pages;

import com.automation.ui.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='user']")
    private WebElement userInput;

    @FindBy(xpath = "//input[@id='login']")
    private WebElement loginButton;

    public TrelloLoginPage(){
        this.driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    public AtlasianLoginPage Login(String userName){
        userInput.sendKeys(userName);
        loginButton.click();
        return new AtlasianLoginPage();
    }
}
