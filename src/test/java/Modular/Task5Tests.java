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


public class Task5Tests {
    /*
    * ________________ Moderate* ________________
    Open Google Chrome
    Navigate to [https://duckduckgo.com/]
    Search for [Cucumber IO]
    Navigate to the second results page
    Assert that the link of the second result contains [https://www.linkedin.com]
    Close Google Chrome
*/
    WebDriver driver;
    Landing landing;
    Results results;
    Wait<WebDriver> wait;
    @Test
    public void verifySecondResultOfSecondPageContainsLinkedin(){
        String query = "Cucumber IO";
        landing.search(query);
        results.navigateToSecondPage();
        wait.until(
                d -> {
                    var actualLink = results.getAnyResultLink(11);
                    Assert.assertTrue(actualLink.contains("https://www.linkedin.com"));
                    return true;
                }
        );
    }

    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        landing = new Landing(driver);
        results = new Results(driver);
        landing.navigate("https://duckduckgo.com");
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(4))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(AssertionError.class);
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
