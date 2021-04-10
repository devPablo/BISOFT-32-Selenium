package pages;

import framework.Helper;
import framework.LanguageEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonLanguageSettingsPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"customer-preferences\"]/div/div/form/div[1]/div[1]/div[1]/div")
    @CacheLookup
    WebElement englishLanguageButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"customer-preferences\"]/div/div/form/div[1]/div[1]/div[2]/div")
    @CacheLookup
    WebElement spanishLanguageButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"customer-preferences\"]/div/div/form/div[1]/div[1]/div[5]/div")
    @CacheLookup
    WebElement portugueseLanguageButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"customer-preferences\"]/div/div/form/div[1]/div[1]/div[3]/div")
    @CacheLookup
    WebElement chineseLanguageButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"customer-preferences\"]/div/div/form/div[1]/div[1]/div[1]/div/label/input")
    @CacheLookup
    WebElement englishLanguageRadio;

    @FindBy(how = How.XPATH, using = "//*[@id=\"customer-preferences\"]/div/div/form/div[1]/div[1]/div[2]/div/label/input")
    @CacheLookup
    WebElement spanishLanguageRadio;

    @FindBy(how = How.XPATH, using = "//*[@id=\"customer-preferences\"]/div/div/form/div[1]/div[1]/div[5]/div/label/input")
    @CacheLookup
    WebElement portugueseLanguageRadio;

    @FindBy(how = How.XPATH, using = "//*[@id=\"customer-preferences\"]/div/div/form/div[1]/div[1]/div[3]/div/label/input")
    @CacheLookup
    WebElement chineseLanguageRadio;


    @FindBy(how = How.XPATH, using = "//*[@id=\"icp-btn-save\"]/span/input")
    @CacheLookup
    WebElement saveChangesButton;

    public AmazonLanguageSettingsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void selectLanguage(LanguageEnum languageEnum) {
        switch (languageEnum) {
            case ENGLISH:
                englishLanguageButton.click();
                break;
            case SPANISH:
                spanishLanguageButton.click();
                break;
            case PORTUGUESE:
                portugueseLanguageButton.click();
                break;
            case CHINESE:
                chineseLanguageButton.click();
                break;
            default:
                throw new IllegalArgumentException("Incorrect value: " + languageEnum);
        }
    }

    public void saveLanguage() {
        saveChangesButton.click();
    }

    public boolean isLanguageSelected(LanguageEnum languageEnum) {
        WebElement languageRadio;
        switch (languageEnum) {
            case ENGLISH:
                languageRadio = englishLanguageRadio;
                break;
            case SPANISH:
                languageRadio = spanishLanguageRadio;
                break;
            case PORTUGUESE:
                languageRadio = portugueseLanguageRadio;
                break;
            case CHINESE:
                languageRadio = chineseLanguageRadio;
                break;
            default:
                throw new IllegalArgumentException("Incorrect value: " + languageEnum);
        }

        return Helper.elementHasAttribute(languageRadio, "checked");
    }
}
