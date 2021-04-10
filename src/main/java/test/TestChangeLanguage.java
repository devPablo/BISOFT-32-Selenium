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
 * @author Daniel Herrera
 * Caso de prueba "HUM_1 - 1", escenario "Cambiar idioma de la aplicación a Portugués"
 * Caso de prueba "HUM_1 - 2", escenario "Cambiar idioma de la aplicación a Chino"
 */

public class TestChangeLanguage {

    public String browser;
    public String url;

    @Parameters({"Browser", "URL"})
    @BeforeTest
    public void beforeTest(String browser, String url) {
        this.browser = browser;
        this.url = url;
    }

    @Test
    public void changedLanguageToPortuguese() throws InterruptedException {
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
        languageSettingsPage.selectLanguage(LanguageEnum.PORTUGUESE);
        Thread.sleep(500);
        languageSettingsPage.saveLanguage();
        Thread.sleep(2000);

        homePage = new AmazonHomePage(driver);
        homePage.goToLanguageSettings();
        Thread.sleep(2000);

        languageSettingsPage = new AmazonLanguageSettingsPage(driver);
        boolean isLanguageSelected = languageSettingsPage.isLanguageSelected(LanguageEnum.PORTUGUESE);

        driver.close();
        assertEquals(isLanguageSelected, true);
    }

    @Test
    public void changedLanguageToChinese() throws InterruptedException {
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
        languageSettingsPage.selectLanguage(LanguageEnum.CHINESE);
        Thread.sleep(500);
        languageSettingsPage.saveLanguage();
        Thread.sleep(2000);

        homePage = new AmazonHomePage(driver);
        homePage.goToLanguageSettings();
        Thread.sleep(2000);

        languageSettingsPage = new AmazonLanguageSettingsPage(driver);
        boolean isLanguageSelected = languageSettingsPage.isLanguageSelected(LanguageEnum.CHINESE);

        driver.close();
        assertEquals(isLanguageSelected, true);
    }
}