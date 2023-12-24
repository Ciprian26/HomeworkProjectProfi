package test.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import test.context.ScenarioContext;
import test.context.ScenarioKeys;
import ui.driver.Driver;
import ui.pages.PageURLEnum;

import static org.hamcrest.Matchers.is;
import static test.utils.AssertUtils.assertThat;

public class CommonActions {

    private final static Logger LOGGER = LogManager.getLogger(CommonActions.class);

    private final ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public void navigateToPage(PageURLEnum pageName) {
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();
        String pageUrl = pageName.getUrl();
        driver.navigate().to(pageUrl);
        LOGGER.info("Driver navigated to: " + pageUrl);
    }

    public void navigateToPageByURL(String pageUrl) {
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.navigate().to(pageUrl);
        LOGGER.info("Driver navigated to: " + pageUrl);
    }

    public void checkUserIsOnPage(PageURLEnum pageName) {
        WebDriver driver = Driver.getDriver();
        String pageUrl = pageName.getUrl();

        assertThat("User is on expected page", driver.getCurrentUrl(), is(pageUrl));
        scenarioContext.saveData(ScenarioKeys.CURRENT_PAGE, pageUrl);
    }
}
