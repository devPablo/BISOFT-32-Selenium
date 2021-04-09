package test;

import framework.Helper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AmazonHomePage;

import static org.testng.Assert.assertEquals;

/**
 * @author Sergio Alfaro
 * Test case "HUM_3 - 1" for testing order by lowest price
 */

public class TestSignInMenu extends Helper {

    public AmazonHomePage homePage;

    @BeforeMethod
    public void initPage() {
        homePage = new AmazonHomePage(Helper.driver);
    }

    @Test
    public void signInOption() throws InterruptedException {
        homePage.hoverAccountMenu();
        Thread.sleep(2000);
        assertEquals(homePage.isSignButtonOnAccountMenu(), true);
    }
}
