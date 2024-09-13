package Modular;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Landing;

public class Task1 {
    /*
    * Open Google Chrome
    Navigate to [https://duckduckgo.com/]
    Assert that the page title is [Google]
    Close Google Chrome
    * */
    WebDriver driver;
    Landing landing;
    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        landing = new Landing(driver);
        landing.navigate("https://duckduckgo.com");
    }
    @AfterTest
    public void afterTest(){
     driver.quit();
    }
    @Test
    public void pageTitleAssertion(){
        var expectedTitle = landing.getTitle();
        Assert.assertEquals(expectedTitle, "DuckDuckGo — Privacy, simplified.");

    }
}
