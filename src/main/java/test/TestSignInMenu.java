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
 * Caso de prueba "HUM_3 - 1", escenario "Desplegar correctamente cuando no existe un usuario logueado"
 * Caso de prueba "HUM_3 - 2", escenario "Desplegar correctamente cuando existe un usuario logueado"
 */

public class TestSignInMenu extends Helper {

    public String browser;
    public String url;

    @Parameters({"Browser", "URL"})
    @BeforeTest
    public void beforeTest(String browser, String url) {
        this.browser = browser;
        this.url = url;
    }

    @Test
    public void signInOption() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.hoverAccountMenu();
        Thread.sleep(2000);
        assertEquals(homePage.isSignButtonOnAccountMenu(), true);
    }
}
