package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landing {
    WebDriver driver;
    String title;
    WebElement box1;
    WebElement box2;

    By searchInput = By.name("q");
    public Landing(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate(String url){
        driver.navigate().to(url);
    }
    public String getTitle(){
        title = driver.getTitle();
        return title;
    }
    public boolean isLogoDisplayed(){
       WebElement logo = driver.findElement(By.xpath("(//a/img)[2]"));
        return logo.isDisplayed();
    }
    public void search(String query) {
        driver.findElement(searchInput).sendKeys(query, Keys.ENTER);
    }
    public boolean isBoxChecked(){
        box1 = driver.findElement(By.xpath("(//input)[1]"));
        box2 = driver.findElement(By.xpath("(//input)[2]"));
        box1.click();
        return box1.isSelected() && box2.isSelected();
    }
}
