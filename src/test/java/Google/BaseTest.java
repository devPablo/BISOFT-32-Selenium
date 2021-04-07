package Google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;

    public GoogleHomePage GHP;

    @Parameters({"Browser", "URL"})
    @BeforeClass
    public void TestSetUp(String browser, String url) {
        if ("Chrome".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
    }

    @BeforeMethod
    public void methodLevelSetUp() {
        GHP = new GoogleHomePage(driver);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
