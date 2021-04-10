package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonLoginPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ap_email\"]")
    @CacheLookup
    WebElement inputEmailOrPhoneNumber;

    @FindBy(how = How.XPATH, using = "//*[@id=\"continue\"]")
    @CacheLookup
    WebElement continueButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ap_password\"]")
    @CacheLookup
    WebElement inputPassword;

    @FindBy(how = How.XPATH, using = "//*[@id=\"signInSubmit\"]")
    @CacheLookup
    WebElement signinButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"auth-error-message-box\"]/div/h4")
    @CacheLookup
    WebElement errorMessageBox;

    public AmazonLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String emailOrPhoneNumber, String password) throws InterruptedException {
        inputEmailOrPhoneNumber.sendKeys(emailOrPhoneNumber);
        Thread.sleep(1000);
        continueButton.click();
        Thread.sleep(2000);
        inputPassword.sendKeys(password);
        Thread.sleep(1000);
        signinButton.click();
    }

    public void confirmPassword(String password) throws InterruptedException {
        inputPassword.sendKeys(password);
        Thread.sleep(1000);
        signinButton.click();
    }

    public boolean isPasswordCorrect() throws  InterruptedException {
        Thread.sleep(2000);
        return !errorMessageBox.getText().equalsIgnoreCase("There was a problem");
    }

}
