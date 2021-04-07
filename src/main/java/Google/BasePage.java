package Google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void click(By element)
    {
        driver.findElement(element).click();
    }

    public void sendKeys(By element, String text)
    {
        driver.findElement(element).sendKeys(text);
    }
}
