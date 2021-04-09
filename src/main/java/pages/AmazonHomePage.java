package pages;

import framework.Helper;
import framework.LanguageEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"twotabsearchtextbox\"]")
    @CacheLookup
    WebElement searchBar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"nav-flyout-searchAjax\"]")
    @CacheLookup
    WebElement searchBarAutoSuggest;

    @FindBy(how = How.XPATH, using = "//*[@id=\"issDiv0\"]")
    @CacheLookup
    WebElement firstSearchBarAutoSuggestOption;

    @FindBy(how = How.XPATH, using = "//*[@id=\"icp-nav-flyout\"]")
    @CacheLookup
    WebElement chooseLanguageButton;
//
//    @FindBy(how = How.CSS, using = "\"a[href*='switch-lang=en_US']\"")
//    @CacheLookup
//    WebElement englishLanguageButton;
//
//    @FindBy(how = How.XPATH, using = "//*[@id=\"nav-flyout-icp\"]/div[2]/a[1]")
//    @CacheLookup
//    WebElement spanishLanguageButton;
//
//    @FindBy(how = How.XPATH, using = "//*[@id=\"nav-flyout-icp\"]/div[2]/span[2]/span/i")
//    @CacheLookup
//    WebElement englishLanguageRadio;
//
//    @FindBy(how = How.XPATH, using = "//*[@id=\"nav-flyout-icp\"]/div[2]/a[1]/span/i")
//    @CacheLookup
//    WebElement spanishLanguageRadio;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSearchBar() {
        searchBar.click();
    }

    public void typeOnSearchBar(String text) {
        searchBar.sendKeys(text);
    }

    public boolean isSearchBarAutoSuggestVisible() {
        return !searchBarAutoSuggest.getCssValue("display").equalsIgnoreCase("none");
    }

    public boolean isFirstSuggestionIdentical(String expected) {
        return firstSearchBarAutoSuggestOption.getText().equalsIgnoreCase(expected);
    }

    public void goToLanguageSettings() {
        chooseLanguageButton.click();
    }

//    public void hoverLanguageSelection() {
//        Actions actions = new Actions(this.driver);
//        actions.moveToElement(chooseLanguageDropdown).build().perform();
//    }
//
//    public void setLanguage(LanguageEnum language) {
//        switch (language) {
//            case ENGLISH:
//                englishLanguageButton.click();
//                break;
//            case SPANISH:
//                spanishLanguageButton.click();
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + language);
//        }
//    }
//
//    public boolean isLanguageSelected(LanguageEnum language) {
//        WebElement languageElementRadio;
//
//        switch (language) {
//            case ENGLISH:
//                languageElementRadio = englishLanguageRadio;
//                break;
//            case SPANISH:
//                languageElementRadio = spanishLanguageRadio;
//                break;
//            default:
//                throw new IllegalStateException("Unexpected value: " + language);
//        }
//
//        return Helper.elementHasClass(languageElementRadio, "icp-radio-active");
//    }
}
