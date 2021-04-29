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
 * Caso de prueba "REG_2 - 1", escenario "Verificar que el usuario puede añadir un producto al carrito de compras, y posteriormente eliminarlo exitosamente"
 * Caso de prueba "REG_2 - 2", escenario "Verificar que el usuario puede añadir más de un producto al carrito de compras, y posteriormente eliminar solo uno no deseado del mismo tipo."
 */

public class TestDeleteFromCart {

    public String browser;
    public String url;

    @Parameters({"Browser", "URL"})
    @BeforeTest
    public void beforeTest(String browser, String url) {
        this.browser = browser;
        this.url = url;
    }

    @Test
    public void deleteOneItemFromCart() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonHomePage homePage = new AmazonHomePage(driver);

        homePage.searchToy("ilife tech modeling clay");
        boolean isCartEmpty = homePage.getEmptyCardText().toLowerCase().contains("Your Amazon Cart is empty".toLowerCase());
        assertEquals(isCartEmpty, true);
        driver.close();
    }

    @Test
    public void deleteOneOfMultipleOfSameItemFromCart() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonHomePage homePage = new AmazonHomePage(driver);

        homePage.searchToyWithQuantity("ilife tech modeling clay", 5);
        boolean isCartEmpty = homePage.getEmptyCardText().toLowerCase().contains("Your Amazon Cart is empty".toLowerCase());
        assertEquals(isCartEmpty, true);
        driver.close();
    }
}
