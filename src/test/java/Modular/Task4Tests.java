package Modular;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Landing;
import pages.Results;

import java.time.Duration;

public class Task4Tests {
    /*
    * Open Mozilla Firefox
    Navigate to [https://duckduckgo.com/]
    Search for [TestNG]
    Assert that the text of the fourth result is [TestNG Tutorial]
    Close Mozilla Firefox
    * */
    WebDriver driver;
    Landing landing;
    Results results;
    Wait<WebDriver> wait;
    @Test
    public void assertFourthResult(){
        String query = "TestNG";
        landing.search(query);
        wait.until(
                d -> {
                    var actual = results.getResultsText(4);
                    Assert.assertEquals(actual, "TestNG Tutorial");
                    return true;
                });

    }
    @BeforeTest
    public void beforeTest(){
        driver = new FirefoxDriver();
        landing = new Landing(driver);
        results = new Results(driver);
        landing.navigate("https://duckduckgo.com");

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(4))
                .pollingEvery(Duration.ofMillis(200))
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
