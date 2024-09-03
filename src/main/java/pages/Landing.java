package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landing {
    WebDriver driver;
    String title;
    public Landing(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate(){
        driver.navigate().to("https://duckduckgo.com");
    }
    public String getTitle(){
        title = driver.getTitle();
        return title;
    }
    public void isLogoDisplayed(){
        WebElement logo = driver.findElement(By.xpath("(//a/img[@alt])[1]"));
        logo.isDisplayed();
    }}
