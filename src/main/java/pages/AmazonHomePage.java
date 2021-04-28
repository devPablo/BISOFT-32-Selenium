package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

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

    @FindBy(how = How.XPATH, using = "//*[@id=\"pageContent\"]")
    @CacheLookup
    WebElement principalDiv;

    @FindBy(how = How.XPATH, using = "//*[@id=\"issDiv0\"]")
    @CacheLookup
    WebElement firstSearchBarAutoSuggestOption;

    @FindBy(how = How.XPATH, using = "//*[@id=\"icp-nav-flyout\"]")
    @CacheLookup
    WebElement chooseLanguageButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"nav-item-signout\"]")
    @CacheLookup
    WebElement accountMenuSignOutButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"nav-search-dropdown-card\"]")
    @CacheLookup
    WebElement dropdownSearchBar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"searchDropdownBox\"]/option[10]")
    @CacheLookup
    WebElement kindleStoreOption;

    @FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[1]/div/span/div/div/div[2]/h2/a")
    @CacheLookup
    WebElement book;

    @FindBy(how = How.XPATH, using = "//*[@id=\"a-autoid-0\"]/span")
    @CacheLookup
    WebElement selectKindleVersion;

    @FindBy(how = How.XPATH, using = "//*[@id=\"one-click-button\"]")
    @CacheLookup
    WebElement buyOneClickOption;

    @FindBy(how = How.XPATH, using = "//*[@id=\"place-order-button\"]")
    @CacheLookup
    WebElement placeYourOrder;

    @FindBy(how = How.XPATH, using = "//*[@id=\"a-autoid-2\"]/span")
    @CacheLookup
    WebElement selectPhysicalVersion;

    @FindBy(how = How.XPATH, using = "//*[@id=\"submit.buy-now\"]/span")
    @CacheLookup
    WebElement buyNowOption;

    @FindBy(how = How.XPATH, using = "/html/body/div[5]/div[2]/div[1]/h1")
    @CacheLookup
    WebElement shippingText;

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

    public void clickSearchButton() {
        searchButton.click();
    }

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

    public void hoverAccountMenu() {
        Actions hover = new Actions(this.driver);
        hover.moveToElement(accountMenu).build().perform();
    }

    public boolean isSearchBarAutoSuggestVisible() {
        return !searchBarAutoSuggest.getCssValue("display").equalsIgnoreCase("none");
    }

    public boolean isOrderByLowestPrice() {
        return orderByLowestText.getText().equals("Price: Low to High");
    }

    public boolean isOrderByHighestPrice() {
        return orderByHighestText.getText().equals("Price: High to Low");
    }

    public boolean isSignOnButtonAccountMenu() {
        return accountMenuSignInButton != null;
    }

    public boolean isHomePageLoaded() {
        return principalDiv != null;
    }

    public boolean isFirstSuggestionIdentical(String expected) {
        return firstSearchBarAutoSuggestOption.getText().equalsIgnoreCase(expected);
    }

    public void goToLanguageSettings() {
        chooseLanguageButton.click();
    }

    public boolean isSignOutButtonOnAccountMenu() {
        return accountMenuSignOutButton != null;
    }

    public void goToAccountPage() {
        accountMenu.click();
    }

    public boolean isLogedIn() {
        return driver.getTitle().equalsIgnoreCase("Your Amazon.com");
    }

    public void searchEbook(String bookName) throws InterruptedException {
        Thread.sleep(2000);
        dropdownSearchBar.click();
        Thread.sleep(2000);
        kindleStoreOption.click();
        typeOnSearchBar(bookName);
        Thread.sleep(2000);
        clickSearchButton();
        Thread.sleep(2000);
        book.click();
    }

    public String getPlaceYourOrderText() {
        return placeYourOrder.getText();
    }

    public void buyEbook() throws InterruptedException {
        selectKindleVersion.click();
        Thread.sleep(2000);
        buyOneClickOption.click();
        Thread.sleep(2000);
    }

    public void buyBook() throws InterruptedException {
        selectPhysicalVersion.click();
        Thread.sleep(2000);
        buyNowOption.click();
        Thread.sleep(2000);
    }

    public String getShippingText(){
        return shippingText.getText();
    }
}
