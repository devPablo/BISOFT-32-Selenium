package test;

import framework.Helper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AmazonHomePage;

import static org.testng.Assert.assertEquals;

/**
 * @author Sergio Alfaro
 * Test case "UNI_2 - 2" for testing order by highest price
 */

public class TestOrderByHighest extends Helper {

    public AmazonHomePage homePage;

    @BeforeMethod
    public void initPage() {
        homePage = new AmazonHomePage(Helper.driver);
    }

    @Test
    public void orderByLowestPrice() throws InterruptedException {
        homePage.clickSearchBar();
        Thread.sleep(2000);
        homePage.typeOnSearchBar("Toy");
        Thread.sleep(2000);
        homePage.clickSearchButton();
        Thread.sleep(2000);
        homePage.orderByHighest();
        Thread.sleep(2000);
        assertEquals(homePage.isOrderByHighestPrice(), true);
    }
}
