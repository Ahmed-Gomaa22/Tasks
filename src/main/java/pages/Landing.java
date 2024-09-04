package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landing {
    WebDriver driver;
    String title;
    By searchInput = By.name("q");
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
    public boolean isLogoDisplayed(){

        return driver.findElement(By.xpath("(//a/img[@alt])[1]")).isDisplayed();
    }
    public void search(String query) {
        driver.findElement(searchInput).sendKeys(query, Keys.ENTER);
    }
}
