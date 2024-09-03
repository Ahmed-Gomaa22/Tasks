package Modular;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Landing;

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

    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        home = new Landing(driver);
        home.navigate();
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void assertLinkOfTheFirstResult(){
        String searchQuery = "Selenium WebDriver";
        home.search(searchQuery);
    }
}
