package Modular;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Landing;


public class Task2Test {
    WebDriver driver;
    Landing landing;
    @Test
    public void logoIsDisplayed(){
        landing = new Landing(driver);
        landing.isLogoDisplayed();

    }
    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        landing = new Landing(driver);
        landing.navigate();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
