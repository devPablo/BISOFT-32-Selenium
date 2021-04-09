package test;

import framework.Helper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AmazonHomePage;

import static org.testng.Assert.assertEquals;

/**
 * @author Sergio Alfaro
 * Test case "HUM_2 - 1" for testing order by lowest price
 */

public class TestHomePageNotLoaded extends Helper {

    public AmazonHomePage homePage;

    @BeforeMethod
    public void initPage() {
        homePage = new AmazonHomePage(Helper.driver);
    }

    @Test
    public void homePageNotLoaded() {
        assertEquals(homePage.isHomePageLoaded(), false);
    }
}
