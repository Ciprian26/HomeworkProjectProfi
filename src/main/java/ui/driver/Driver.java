package ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver driver;

    private Driver() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/ui/driver/chromedriver.exe");

        driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            new Driver();
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}
