package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Results {
    WebDriver driver;
    By anyResultLink;
    By anyResultText;
    By secondPage;

    public Results(WebDriver driver) {
        this.driver = driver;
    }
    public String getAnyResultLink(int i){
        anyResultLink = By.xpath("(//article)["+i+"]//a[@data-testid= 'result-extras-url-link']");
        return driver.findElement(anyResultLink).getAttribute("href");
    }
    public String getResultsText(int i){
        anyResultText = By.xpath("(//article)["+i+"]//h2");
        return driver.findElement(anyResultText).getText();
    }
    public void navigateToSecondPage(){
        secondPage = By.id("more-results");
        driver.findElement(secondPage).click();
    }
}

