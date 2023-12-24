package test.utils;

import org.openqa.selenium.WebElement;

public class WaitUtils {

    public static void clickUntilElementDisplayed(WebElement elementToClick, WebElement waitForElement) {
        while (!isElementDisplayed(waitForElement)) {
            elementToClick.click();
        }
    }

    private static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }
}
