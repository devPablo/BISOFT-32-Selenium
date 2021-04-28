package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonChangeEmailPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"cvf-page-content\"]/div/div/div/form/div[1]/div/div[2]/div/input")
    @CacheLookup
    WebElement newEmailInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"a-autoid-0\"]/span/input")
    @CacheLookup
    WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"cvf-page-content\"]/div/div/div/form/div[2]/div")
    @CacheLookup
    WebElement invalidEmailAlert;

    @FindBy(how = How.XPATH, using = "//*[@id=\"cvf-page-content\"]/div/div/form/div[1]/div[1]/h1")
    @CacheLookup
    WebElement verifyEmailLabel;

    public AmazonChangeEmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void changeEmail(String newEmail) throws InterruptedException {
        newEmailInput.sendKeys(newEmail);
        Thread.sleep(1000);

        submitButton.click();
    }

    public boolean validateEmail() throws InterruptedException {
        Thread.sleep(2000);
        return !invalidEmailAlert.getText().equalsIgnoreCase("The email address you've entered is not valid. Please enter a valid email address.");
    }

    public boolean verifyEmailAddress() throws InterruptedException {
        Thread.sleep(2000);
        return verifyEmailLabel.getText().equalsIgnoreCase("Verify email address");
    }
}
