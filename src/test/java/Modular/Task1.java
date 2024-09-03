package Modular;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task1 {
    /*
    * Open Google Chrome
    Navigate to [https://duckduckgo.com/]
    Assert that the page title is [Google]
    Close Google Chrome
    * */
    WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.navigate().to("https://duckduckgo.com");
    }
    @AfterTest
    public void afterTest(){
     driver.quit();
    }
    @Test
    public void pageTitleAssertion(){
       var title = driver.getTitle();
        Assert.assertEquals(title, "DuckDuckGo — Privacy, simplified.");

    }
}
