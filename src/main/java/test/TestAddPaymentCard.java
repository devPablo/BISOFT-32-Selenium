package test;

import framework.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

/**
 * @author Pablo Bonilla
 * Caso de prueba "FUN_3 - 1", escenario "Verificar que el usuario pueda añadir su tarjeta de crédito o débito exitosamente a Amazon para realizar pagos"
 * Caso de prueba "FUN_3 - 2", escenario "Verificar que el usuario no pueda añadir su tarjeta de crédito o débito a Amazon"
 */

public class TestAddPaymentCard {

    public String browser;
    public String url;

    @Parameters({"Browser", "URL"})
    @BeforeTest
    public void beforeTest(String browser, String url) {
        this.browser = browser;
        this.url = url;
    }

    @Test
    public void correctlyAddCreditOrDebitCard() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonLoginPage loginPage = new AmazonLoginPage(driver);

        loginPage.login("email.internet.test@gmail.com", "AmazonPassword1!");

        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.goToAccountPage();

        AmazonAccountPage accountPage = new AmazonAccountPage(driver);
        accountPage.goToYourPayments();

        AmazonYourPaymentsPage yourPaymentsPage = new AmazonYourPaymentsPage(driver);
        Thread.sleep(1000);
        yourPaymentsPage.openAddCardModal();
        Thread.sleep(3000);

        /* Amazon blocks direct interaction by injecting an inaccessible HTML document (payment security method)

        AmazonCardModalPage cardModalPage = new AmazonCardModalPage(driver);
        cardModalPage.addCardFillForm("4000 0600 0000 0006", "Test Account", 03, 2030);
        cardModalPage.addCardButton();

        Thread.sleep(1000);
        cardModalPage.addAddressInformation("Test Account", "Address Line 1", "Address Line 2",
                "City", "StateProvinceRegion", "zip", "(555) 555-1234");
        cardModalPage.useThisAddressButton();

        loginPage = new AmazonLoginPage(driver);
        loginPage.confirmPassword("AmazonPassword1!");
        */

    }

    @Test
    public void incorrectlyAddCreditOrDebitCard() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonLoginPage loginPage = new AmazonLoginPage(driver);

        loginPage.login("email.internet.test@gmail.com", "AmazonPassword1!");

        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.goToAccountPage();

        AmazonAccountPage accountPage = new AmazonAccountPage(driver);
        accountPage.goToYourPayments();

        AmazonYourPaymentsPage yourPaymentsPage = new AmazonYourPaymentsPage(driver);
        Thread.sleep(1000);
        yourPaymentsPage.openAddCardModal();
        Thread.sleep(3000);

        /* Amazon blocks direct interaction by injecting an inaccessible HTML document (payment security method)

        AmazonCardModalPage cardModalPage = new AmazonCardModalPage(driver);
        cardModalPage.addCardFillForm("4000 0600 0000 0006", "Test Account", 03, 2030);
        cardModalPage.addCardButton();

        Thread.sleep(1000);
        cardModalPage.addAddressInformation("Test Account", "Address Line 1", "Address Line 2",
                "City", "StateProvinceRegion", "zip", "(555) 555-1234");
        cardModalPage.useThisAddressButton();

        loginPage = new AmazonLoginPage(driver);
        loginPage.confirmPassword("AmazonPassword1!");
        */

    }
}
