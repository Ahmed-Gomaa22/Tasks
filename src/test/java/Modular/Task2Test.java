package Modular;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Landing;


public class Task2Test {
    WebDriver driver;
    Landing landingPage;
    Wait<WebDriver> wait;
    @Test
    public void logoIsDisplayed(){
        Assert.assertTrue(landingPage.isLogoDisplayed());

    }
    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        landingPage = new Landing(driver);
        landingPage.navigate();


    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
