package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonYourPaymentsPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div[4]/div/div/div[2]/div/div/div[3]/div/div[2]/div/div[2]/div/div/span/span[1]/span/input")
    @CacheLookup
    WebElement addADebitOrCreditCardButton;

    public AmazonYourPaymentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openAddCardModal() {
        addADebitOrCreditCardButton.click();
    }
}
