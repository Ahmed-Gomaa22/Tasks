package Modular;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Task2Test {
    WebDriver driver;
    @Test
    public void logoIsDisplayed(){
        WebElement logo = driver.findElement(By.xpath("(//a/img[@alt])[1]"));
        logo.isDisplayed();
    }
    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.navigate().to("https://duckduckgo.com");
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
