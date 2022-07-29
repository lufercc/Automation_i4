package com.automation.ui.pages;

import com.automation.ui.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkSpacePage {
    WebDriver driver;

    @FindBy(xpath = "//nav[@id ='header']//a[@aria-label = 'Back to home']")
    WebElement trelloIcon;

    public WorkSpacePage(){
        driver = DriverManager.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    public boolean itsLoged(){
        return trelloIcon.isDisplayed();
    }
}
