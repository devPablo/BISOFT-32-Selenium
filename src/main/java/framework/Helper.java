package framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class    Helper {

    public static WebDriver driver;
    BrowserFactory browserFactory;

    public Helper() {
    }

    @BeforeSuite
    public void beforeSuite() {
    }

    @Parameters({"Browser", "URL"})
    @BeforeClass
    public void beforeClass(String browser, String url) {
        Helper.driver = browserFactory.getDriver(browser, url);
    }

//    @AfterMethod
//    public void afterMethod() {
//        driver.quit();
//    }


}
