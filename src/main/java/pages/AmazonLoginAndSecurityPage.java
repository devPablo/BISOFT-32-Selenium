package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonLoginAndSecurityPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"auth-cnep-edit-email-button\"]")
    @CacheLookup
    WebElement editEmailButton;

    public AmazonLoginAndSecurityPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToEditEmail() {
        editEmailButton.click();
    }
}
