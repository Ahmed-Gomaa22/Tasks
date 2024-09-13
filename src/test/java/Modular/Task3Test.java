package Modular;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Landing;
import pages.Results;

import java.time.Duration;

public class Task3Test {
    /*
    * Open Google Chrome
    Navigate to [https://duckduckgo.com/]
    Search for [Selenium WebDriver]
    Assert that the link of the first result is [https://www.selenium.dev/documentation/webdriver/]
    Close Google Chrome

    * */
    WebDriver driver;
    Landing home;
    Results results;
    Wait<WebDriver> wait;
    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        home = new Landing(driver);
        home.navigate();
        results = new Results(driver);
        wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(3))
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

    @Test
    public void assertLinkOfTheFirstResult(){
        String searchQuery = "Selenium WebDriver";
        home.search(searchQuery);
        wait.until(
                d -> {
                    var firstLink = results.getAnyResultLink(1);
                    Assert.assertEquals(firstLink, "https://www.selenium.dev/documentation/webdriver/");
                    return true;
                });


    }
}
