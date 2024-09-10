package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Results {
    WebDriver driver;
    By firstLink = By.xpath("//article[@id = 'r1-0']//a[@data-testid= 'result-extras-url-link']");

    public Results(WebDriver driver) {
        this.driver = driver;
    }
    public String getFirstResultLink(){
        return driver.findElement(firstLink).getAttribute("href");
    }
}

