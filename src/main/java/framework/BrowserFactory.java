package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {
    public WebDriver driver;

    public BrowserFactory() {
    }

    public WebDriver getDriver(String browser, String url) {
        switch (browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                this.driver = new ChromeDriver(options);
                this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                this.driver.get(url);
                break;
        }
        
        return this.driver;
    }
}
