package test.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ui.driver.Driver;

public class UIHooks {

    @Before(value = "@UI")
    public void setUp() {
        Driver.getDriver();
    }

    @After(value = "@UI")
    public void endTests() {
        Driver.quitDriver();
    }
}
