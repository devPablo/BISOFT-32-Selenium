package test;

import framework.Helper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AmazonHomePage;

import javax.naming.NameAlreadyBoundException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author Pablo Bonilla
 * Test case "UNI_1 - 2" for testing automatic search based suggestions
 */

public class TestAutoSearchSuggestion extends Helper {

    public AmazonHomePage homePage;

    @BeforeMethod
    public void initPage() {
        homePage = new AmazonHomePage(Helper.driver);
    }

    @Test
    public void correctlyTyped() throws InterruptedException {
        homePage.clickSearchBar();
        Thread.sleep(2000);
        homePage.typeOnSearchBar("Toy");
        Thread.sleep(2000);
        assertEquals(homePage.isSearchBarAutoSuggestVisible(), true);
    }
}
