package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonCardModalPage {

    WebDriver driver;

    @FindBy(how = How.NAME, using = "addCreditCardNumber")
    @CacheLookup
    List<WebElement> cardNumberInputList;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div/div/div/div/div[2]/div/div/div/div/form/div[1]/div[2]/div/div[2]/div[2]/input")
    @CacheLookup
    WebElement nameOnCardInput;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div/div/div/div/div[2]/div/div/div/div/form/div[1]/div[2]/div/div[3]/div[2]/div[1]/span[1]/span/span/span")
    @CacheLookup
    WebElement expirationDateMonthSelect;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div/div/div/div/div[2]/div/div/div/div/form/div[1]/div[2]/div/div[3]/div[2]/div[1]/span[3]/span/span/span")
    @CacheLookup
    WebElement expirationDateYearSelect;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div/div/div/div/div[2]/div/div/div/div/form/div[1]/div[2]/div/div[7]/div[2]/span/span/input")
    @CacheLookup
    WebElement addYourCardButton;


    @FindBy(how = How.XPATH, using = "//*[@id=\"pp-yil32J-16\"]")
    @CacheLookup
    WebElement fullNameInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"pp-yil32J-17\"]")
    @CacheLookup
    WebElement addressLine1Input;

    @FindBy(how = How.XPATH, using = "//*[@id=\"pp-yil32J-18\"]")
    @CacheLookup
    WebElement addressLine2Input;

    @FindBy(how = How.XPATH, using = "//*[@id=\"pp-yil32J-19\"]")
    @CacheLookup
    WebElement cityInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"pp-yil32J-20\"]")
    @CacheLookup
    WebElement stateProvinceRegionInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"pp-yil32J-21\"]")
    @CacheLookup
    WebElement zipInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"pp-yil32J-24\"]")
    @CacheLookup
    WebElement phoneNumberInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"pp-yil32J-13\"]/div/div/form/div/div/div[2]/div/span/span/input")
    @CacheLookup
    WebElement useThisAddressButton;

    public AmazonCardModalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addCardFillForm(String cardNumber, String nameOnCard, int expirationDateMonth, int expirationDateYear) {
        cardNumberInputList.get(0).sendKeys(cardNumber);
        nameOnCardInput.sendKeys(nameOnCard);

        expirationDateMonthSelect.click();
        expirationDateMonthSelect.sendKeys(String.valueOf(expirationDateMonth));

        expirationDateYearSelect.click();
        expirationDateYearSelect.sendKeys(String.valueOf(expirationDateYear));
    }

    public void addCardButton() {
        addYourCardButton.click();
    }

    public void addAddressInformation(String fullName, String addressLine1, String addressLine2, String city, String stateProvinceRegion,
                                      String ZIP, String phoneNumber) {
        fullNameInput.sendKeys(fullName);
        addressLine1Input.sendKeys(addressLine1);
        addressLine2Input.sendKeys(addressLine2);
        cityInput.sendKeys(city);
        stateProvinceRegionInput.sendKeys(stateProvinceRegion);
        zipInput.sendKeys(ZIP);
        phoneNumberInput.sendKeys(phoneNumber);
    }

    public void useThisAddressButton() {
        useThisAddressButton.click();
    }
}
