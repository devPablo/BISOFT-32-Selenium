package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonAccountPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"a-page\"]/div[2]/div/div[3]/div[2]/a")
    @CacheLookup
    WebElement yourPaymentsButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"a-page\"]/div[2]/div/div[2]/div[2]/a")
    @CacheLookup
    WebElement loginAndSecurityButton;

    public AmazonAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToYourPayments() {
        yourPaymentsButton.click();
    }

    public void goToLoginAndSecurity(){
        loginAndSecurityButton.click();
    }
}
