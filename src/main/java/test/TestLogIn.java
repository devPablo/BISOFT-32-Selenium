package test;

import framework.BrowserFactory;
import framework.LanguageEnum;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import pages.AmazonLanguageSettingsPage;
import pages.AmazonLoginPage;

import static org.testng.Assert.*;

/**
 * @author Daniel Herrera
 * Caso de prueba "FUN_1 - 1", escenario "Verificar que el usuario puede iniciar sesión exitosamente a partir del correo electrónico y la contraseña"
 * Caso de prueba "FUN_1 - 2", escenario "Verificar que el usuario no puede iniciar sesión exitosamente a partir del correo electrónico y una contraseña incorrecta"
 */

public class TestLogIn {

    public String browser;
    public String url;

    @Parameters({"Browser", "URL"})
    @BeforeTest
    public void beforeTest(String browser, String url) {
        this.browser = browser;
        this.url = url;
    }

    @Test
    public void successfulLogIn() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonLoginPage loginPage = new AmazonLoginPage(driver);

        loginPage.login("email.internet.test@gmail.com", "AmazonPassword1!");

        AmazonHomePage homePage = new AmazonHomePage(driver);
        boolean successfulLogIn = homePage.isLogedIn();

        assertTrue(successfulLogIn);
        driver.close();
    }

    @Test
    public void unsuccessfulLogIn() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonLoginPage loginPage = new AmazonLoginPage(driver);

        loginPage.login("email.internet.test@gmail.com", "wrongpassword");
        Thread.sleep(2000);
        boolean isPasswordCorrect = loginPage.isPasswordCorrect();

        assertFalse(isPasswordCorrect);
        driver.close();
    }
}
