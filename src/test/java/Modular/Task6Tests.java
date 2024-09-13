package Modular;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Landing;

public class Task6Tests {
    WebDriver driver;
    Landing landing;
    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        landing = new Landing(driver);

        landing.navigate("http://the-internet.herokuapp.com/checkboxes");
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void verifyThatBothBoxesAreChecked(){
        Assert.assertTrue(landing.isBoxChecked());
    }
}
