package Modular;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Landing;


public class Task2Test {
    WebDriver driver;
    Landing landingPage;
    @Test
    public void logoIsDisplayed(){
        landingPage = new Landing(driver);
        landingPage.isLogoDisplayed();

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
