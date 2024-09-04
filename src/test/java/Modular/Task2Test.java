package Modular;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Landing;

import java.time.Duration;


public class Task2Test {
    WebDriver driver;
    Landing landingPage;
    Wait<WebDriver> wait;
    @Test
    public void logoIsDisplayed(){
        wait.until(d -> {
            Assert.assertTrue(landingPage.isLogoDisplayed());
            return true;
        });



    }
    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        landingPage = new Landing(driver);
        landingPage.navigate();


        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(AssertionError.class);

    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
