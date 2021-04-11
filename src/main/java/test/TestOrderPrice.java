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
 * Caso de prueba "UNI_2 - 1", escenario "Los productos se ordenan de precio menor a mayor"
 * Caso de prueba "UNI_2 - 2", escenario "Los productos se ordenan de precio mayor a menor"
 */

public class TestOrderPrice extends Helper {

    public String browser;
    public String url;

    @Parameters({"Browser", "URL"})
    @BeforeTest
    public void beforeTest(String browser, String url) {
        this.browser = browser;
        this.url = url;
    }

    @Test
    public void orderByLowestPrice() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.clickSearchBar();
        Thread.sleep(2000);
        homePage.typeOnSearchBar("Toy");
        Thread.sleep(2000);
        homePage.clickSearchButton();
        Thread.sleep(2000);
        homePage.orderByLowest();
        Thread.sleep(2000);
        assertEquals(homePage.isOrderByLowestPrice(), true);
        driver.close();
    }

    @Test
    public void orderByHighestPrice() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.clickSearchBar();
        Thread.sleep(2000);
        homePage.typeOnSearchBar("Toy");
        Thread.sleep(2000);
        homePage.clickSearchButton();
        Thread.sleep(2000);
        homePage.orderByHighest();
        Thread.sleep(2000);
        assertEquals(homePage.isOrderByHighestPrice(), true);
        driver.close();
    }
}
