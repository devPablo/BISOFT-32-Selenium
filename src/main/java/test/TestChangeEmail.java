package test;

import framework.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.*;

/**
 * @author Daniel Herrera
 * Caso de prueba "INT_2 - 1", escenario "Cambiar el correo electrónico utilizando una dirección de correo electrónico válida"
 * Caso de prueba "INT_2 - 2", escenario "Cambiar el correo electrónico utilizando una dirección de correo electrónico inválida"
 */

public class TestChangeEmail {

    public String browser;
    public String url;

    @Parameters({"Browser", "URL"})
    @BeforeTest
    public void beforeTest(String browser, String url) {
        this.browser = browser;
        this.url = url;
    }

    @Test
    public void correctlyChangeEmail() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonLoginPage loginPage = new AmazonLoginPage(driver);

        loginPage.login("email.internet.test@gmail.com", "AmazonPassword1!");

        Thread.sleep(5000);

        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.goToAccountPage();

        AmazonAccountPage accountPage = new AmazonAccountPage(driver);
        accountPage.goToLoginAndSecurity();

        AmazonLoginAndSecurityPage securityPage = new AmazonLoginAndSecurityPage(driver);
        securityPage.goToEditEmail();

        AmazonChangeEmailPage changeEmailPage = new AmazonChangeEmailPage(driver);
        changeEmailPage.changeEmail("pablobonillagarrido@gmail.com");
        boolean emailIsValid = changeEmailPage.verifyEmailAddress();

        assertTrue(emailIsValid);
        driver.close();
    }

    @Test
    public void inCorrectlyChangeEmail() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonLoginPage loginPage = new AmazonLoginPage(driver);

        loginPage.login("email.internet.test@gmail.com", "AmazonPassword1!");

        Thread.sleep(5000);

        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.goToAccountPage();

        AmazonAccountPage accountPage = new AmazonAccountPage(driver);
        accountPage.goToLoginAndSecurity();

        AmazonLoginAndSecurityPage securityPage = new AmazonLoginAndSecurityPage(driver);
        securityPage.goToEditEmail();

        AmazonChangeEmailPage changeEmailPage = new AmazonChangeEmailPage(driver);
        changeEmailPage.changeEmail("invalidEmail.com");
        boolean emailIsValid = changeEmailPage.validateEmail();

        assertFalse(emailIsValid);
        driver.close();
    }
}
