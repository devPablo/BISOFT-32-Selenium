package test;

import framework.BrowserFactory;
import framework.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import pages.AmazonLoginPage;

import static org.testng.Assert.assertEquals;

/**
 * @author Sergio Alfaro
 * Caso de prueba "REG_1 - 1", escenario "Comprar un libro en formato Kindle"
 * Caso de prueba "REG_1 - 2", escenario "Comprar un libro en formato fisico"
 */

public class TestEbooks extends Helper {

    public String browser;
    public String url;

    @Parameters({"Browser", "URL"})
    @BeforeTest
    public void beforeTest(String browser, String url) {
        this.browser = browser;
        this.url = url;
    }

    @Test
    public void EbookBuy() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonLoginPage loginPage = new AmazonLoginPage(driver);
        loginPage.login("email.internet.test@gmail.com", "AmazonPassword1!");
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.searchEbook("Brandon Sanderson");
        Thread.sleep(2000);
        homePage.buyEbook();
        assertEquals(homePage.getPlaceYourOrderText(), "Place your order");
    }

    @Test
    public void buyPhysicalBook() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonLoginPage loginPage = new AmazonLoginPage(driver);
        loginPage.login("email.internet.test@gmail.com", "AmazonPassword1!");
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.searchEbook("Brandon Sanderson");
        homePage.buyBook();
        assertEquals(homePage.getShippingText(), "Select a shipping address");
    }
}
