package pages;

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

    @FindBy(how = How.XPATH, using = "//*[@id=\"nav-search-submit-button\"]")
    @CacheLookup
    WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"a-autoid-0\"]/span")
    @CacheLookup
    WebElement orderByButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"s-result-sort-select_1\"]")
    @CacheLookup
    WebElement orderByLowestButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"a-autoid-1-announce\"]/span[2]")
    @CacheLookup
    WebElement orderByLowestText;

    @FindBy(how = How.XPATH, using = "//*[@id=\"s-result-sort-select_2\"]")
    @CacheLookup
    WebElement orderByHighestButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"a-autoid-1-announce\"]/span[2]")
    @CacheLookup
    WebElement orderByHighestText;

    @FindBy(how = How.XPATH, using = "//*[@id=\"nav-link-accountList\"]")
    @CacheLookup
    WebElement accountMenu;

    @FindBy(how = How.XPATH, using = "//*[@id=\"nav-flyout-ya-signin\"]/a/span")
    @CacheLookup
    WebElement accountMenuSignInButton;

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

    public void clickSearchButton() { searchButton.click();}

    public void orderByLowest() throws InterruptedException {
        orderByButton.click();
        Thread.sleep(2000);
        orderByLowestButton.click();
    }
    public void orderByHighest() throws InterruptedException {
        orderByButton.click();
        Thread.sleep(2000);
        orderByHighestButton.click();
    }

    public void hoverAccountMenu(){
        Actions hover = new Actions(this.driver);
        hover.moveToElement(accountMenu).build().perform();
    }

    public boolean isSearchBarAutoSuggestVisible() {
        return !searchBarAutoSuggest.getCssValue("display").equalsIgnoreCase("none");
    }

    public boolean isOrderByLowestPrice() {
        return orderByLowestText.getText().equals("Precio: de más bajo a más alto");
    }

    public boolean isOrderByHighestPrice() {
        return orderByHighestText.getText().equals("Precio: de más alto a más bajo");
    }

    public boolean isSignButtonOnAccountMenu(){
        return accountMenuSignInButton != null ? true : false;
    }

}
