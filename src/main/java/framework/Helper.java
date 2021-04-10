package framework;

import org.openqa.selenium.WebElement;

public class Helper {

    public static boolean elementHasClass(WebElement element, String className) {
        String classes = element.getAttribute("class");
        for (String c : classes.split(" ")) {
            if (c.equalsIgnoreCase(className)) {
                return true;
            }
        }
        return false;
    }

    public static boolean elementHasAttribute(WebElement element, String attribute) {
        boolean result = false;
        String value = element.getAttribute(attribute);
        if (value != null) {
            result = true;
        }
        return result;
    }
}
