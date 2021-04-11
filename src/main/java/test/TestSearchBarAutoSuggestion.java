package test;

import framework.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AmazonHomePage;

import static org.testng.Assert.assertEquals;

/**
 * @author Pablo Bonilla
 * Caso de prueba "UNI_1 - 1", escenario "El texto contiene caracteres alfa-numéricos y excluye signos de puntuación"
 * Caso de prueba "UNI_1 - 2", escenario "El texto contiene caracteres alfa-numéricos y signos de puntuación"
 */

public class TestSearchBarAutoSuggestion {

    public String browser;
    public String url;

    @Parameters({"Browser", "URL"})
    @BeforeTest
    public void beforeTest(String browser, String url) {
        this.browser = browser;
        this.url = url;
    }

    @Test
    public void correctlyTyped() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonHomePage homePage = new AmazonHomePage(driver);

        String searchText = "toys";
        homePage.clickSearchBar();
        Thread.sleep(3000);
        homePage.typeOnSearchBar(searchText);
        Thread.sleep(3000);
        assertEquals(homePage.isSearchBarAutoSuggestVisible(), true);
        driver.close();
    }

    @Test
    public void incorrectlyTypedAlphanumeric() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonHomePage homePage = new AmazonHomePage(driver);

        String searchText = "toys ?[;";
        homePage.clickSearchBar();
        Thread.sleep(3000);
        homePage.typeOnSearchBar(searchText);
        Thread.sleep(3000);
        boolean isSearchIdentical = homePage.isFirstSuggestionIdentical(searchText);
        assertEquals(isSearchIdentical, false);
        driver.close();
    }
}
