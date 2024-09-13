package Modular;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Landing;


public class Task2Test {
    WebDriver driver;
    Landing landingPage;
    @Test
    public void logoIsDisplayed(){
        Assert.assertTrue(landingPage.isLogoDisplayed());

    }
    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        landingPage = new Landing(driver);
        landingPage.navigate("https://duckduckgo.com");


    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
