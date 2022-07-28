package com.automation.ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager {
    private static DriverManager instance = null;
    private WebDriver driver = null;

    private DriverManager(){}

    public static DriverManager getInstance(){
        if(instance == null){
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver(){
        if (driver == null){
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(15));
        }
        return driver;
    }

}
