package test;

import framework.BrowserFactory;
import framework.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AmazonHomePage;

import static org.testng.Assert.assertEquals;

/**
 * @author Sergio Alfaro
 * Caso de prueba "HUM_2 - 1", escenario "El landing page carga correctamente"
 * Caso de prueba "HUM_2 - 2", escenario "El landing page carga pero no muestra contenido multimedia"
 */

public class TestHomePageLoaded extends Helper {

    public String browser;
    public String url;

    @Parameters({"Browser", "URL"})
    @BeforeTest
    public void beforeTest(String browser, String url) {
        this.browser = browser;
        this.url = url;
    }

    @Test
    public void homePageLoaded() {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonHomePage homePage = new AmazonHomePage(driver);
        assertEquals(driver.getCurrentUrl().equals("https://www.amazon.com/") && homePage != null && homePage.isHomePageLoaded(), true);
    }

    @Test
    public void homePageNotLoaded() {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonHomePage homePage = new AmazonHomePage(driver);
        assertEquals(homePage.isHomePageLoaded(), false);
    }
}
