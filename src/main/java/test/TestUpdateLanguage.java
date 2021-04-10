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

import static org.testng.Assert.assertEquals;

/**
 * @author Pablo Bonilla
 * Caso de prueba "FUN_2 - 1", escenario "Verificar que la página efectivamente cambie de idioma al seleccionar uno prestablecido, y se envíe un correo informativo al usuario"
 * Caso de prueba "FUN_2 - 2", escenario "Verificar que la página no cambie de idioma al seleccionar uno prestablecido ya previamente seleccionado, y no se envíe un correo informativo al usuario"
 */

public class TestUpdateLanguage {

    public String browser;
    public String url;

    @Parameters({"Browser", "URL"})
    @BeforeTest
    public void beforeTest(String browser, String url) {
        this.browser = browser;
        this.url = url;
    }

    @Test
    public void incorrectlyChangedLanguage() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonLoginPage loginPage = new AmazonLoginPage(driver);

        loginPage.login("email.internet.test@gmail.com", "AmazonPassword1!");

        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.goToLanguageSettings();
        Thread.sleep(2000);

        AmazonLanguageSettingsPage languageSettingsPage = new AmazonLanguageSettingsPage(driver);
        languageSettingsPage.selectLanguage(LanguageEnum.ENGLISH);
        Thread.sleep(500);
        languageSettingsPage.saveLanguage();
        Thread.sleep(2000);

        homePage = new AmazonHomePage(driver);
        homePage.goToLanguageSettings();
        Thread.sleep(2000);

        languageSettingsPage = new AmazonLanguageSettingsPage(driver);
        boolean isLanguageSelected = languageSettingsPage.isLanguageSelected(LanguageEnum.ENGLISH);

        assertEquals(isLanguageSelected, true);
    }

    @Test
    public void correctlyChangedLanguage() throws InterruptedException {
        WebDriver driver = new BrowserFactory().getDriver(browser, url);
        AmazonLoginPage loginPage = new AmazonLoginPage(driver);

        loginPage.login("email.internet.test@gmail.com", "AmazonPassword1!");

        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.goToLanguageSettings();
        Thread.sleep(2000);

        AmazonLanguageSettingsPage languageSettingsPage = new AmazonLanguageSettingsPage(driver);
        languageSettingsPage.selectLanguage(LanguageEnum.SPANISH);
        Thread.sleep(500);
        languageSettingsPage.saveLanguage();
        Thread.sleep(2000);

        homePage = new AmazonHomePage(driver);
        homePage.goToLanguageSettings();
        Thread.sleep(2000);

        languageSettingsPage = new AmazonLanguageSettingsPage(driver);
        boolean isLanguageSelected = languageSettingsPage.isLanguageSelected(LanguageEnum.SPANISH);

        assertEquals(isLanguageSelected, true);
    }
}
