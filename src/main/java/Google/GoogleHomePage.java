package Google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage extends BasePage {
    private WebDriver driver;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    By Input_SearchBar = By.name("q");

    By Image_Google = By.xpath("//img[@alt=\"Google\"]");

    By Button_Search = By.xpath("(//input[@name='btnK'])[2]");

    public void clickGoogle(String text) {
        sendKeys(Input_SearchBar, text);
        click(Image_Google);
        click(Button_Search);
    }
}
