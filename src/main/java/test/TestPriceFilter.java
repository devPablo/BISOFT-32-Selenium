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
 * Caso de prueba "REG_2 - 1", escenario "Los productos se filtran en un rango de precios tal que el precio sea mayor a X y menor a Y, donde ambos sean números reales y X < Y"
 * Caso de prueba "REG_2 - 2", escenario "Los productos se filtran en un rango de precios tal que el precio sea mayor a X y menor a Y, donde ambos sean valores sean caracteres (A-Z)"
 */

public class TestPriceFilter {

    public String browser;
    public String url;

    @Parameters({"Browser", "URL"})
    @BeforeTest
    public void beforeTest(String browser, String url) {
        this.browser = browser;
        this.url = url;
    }

    @Test
    public void filterPriceNumber() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonHomePage homePage = new AmazonHomePage(driver);

        int minPrice = 50;
        int maxPrice = 100;
        homePage.searchProductPriceFilter("nintendo", minPrice, maxPrice);
        Thread.sleep(2000);
        int productPrice = homePage.getPriceProductListed(0);
        boolean isValidPriceFilter = false;
        if (productPrice >= minPrice && productPrice <= maxPrice) {
            isValidPriceFilter = true;
        }
        assertEquals(isValidPriceFilter, true);
        driver.close();
    }

//    @Test
//    public void filterPriceString() throws InterruptedException {
//    }
}
