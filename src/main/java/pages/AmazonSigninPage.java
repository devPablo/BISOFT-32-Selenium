package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonSigninPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ap_customer_name\"]")
    @CacheLookup
    WebElement nameInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ap_email\"]")
    @CacheLookup
    WebElement emailInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ap_password\"]")
    @CacheLookup
    WebElement passwordInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ap_password_check\"]")
    @CacheLookup
    WebElement checkPasswordInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"continue\"]")
    @CacheLookup
    WebElement createAccountButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"auth-password-mismatch-alert\"]")
    @CacheLookup
    WebElement passwordMismatchAlert;

    public AmazonSigninPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void signIn(String name, String email, String password, String checkPassword) throws InterruptedException {
        nameInput.sendKeys(name);
        Thread.sleep(1000);
        emailInput.sendKeys(email);
        Thread.sleep(1000);
        passwordInput.sendKeys(password);
        Thread.sleep(1000);
        checkPasswordInput.sendKeys(checkPassword);
        Thread.sleep(1000);
        createAccountButton.click();
    }

    public boolean isPasswordMismatch() throws InterruptedException {
        return passwordMismatchAlert.getCssValue("display").equalsIgnoreCase("block");
    }
}
