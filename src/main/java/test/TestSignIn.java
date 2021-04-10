package test;

import framework.BrowserFactory;
import framework.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import pages.AmazonSigninPage;

import static org.testng.Assert.assertEquals;

/**
 * @author Daniel Herrera
 * Caso de prueba "REG_3 - 1", escenario "Verificar que un usuario puede registrarse en la página de Amazon exitosamente"
 * Caso de prueba "REG_3 - 2", escenario "Verificar que un usuario no puede registrarse en la página de Amazon si ingresa ambas contraseñas diferentes"
 */

public class TestSignIn extends Helper {

    public String browser;
    public String url;

    @Parameters({"Browser", "URL"})
    @BeforeTest
    public void beforeTest(String browser, String url) {
        this.browser = browser;
        this.url = url;
    }

    @Test
    public void signInDifferentPassword() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonSigninPage signInPage = new AmazonSigninPage(driver);
        signInPage.signIn("TestName", "testEmail@gmail.com", "correctpassword", "incorrectpassword");
        Thread.sleep(2000);

        boolean isPasswordMismatch = signInPage.isPasswordMismatch();

        assertEquals(isPasswordMismatch, true);
    }
}
