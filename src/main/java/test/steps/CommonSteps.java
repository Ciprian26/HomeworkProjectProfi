package test.steps;

import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import test.actions.CommonActions;
import test.context.ScenarioContext;
import ui.pages.PageURLEnum;
import ui.pages.TemporaryEmail;

import static test.context.ScenarioKeys.CURRENT_EMAIL;
import static ui.pages.PageURLEnum.TEMPORARY_EMAIL_PAGE;

public class CommonSteps {

    private final static Logger LOGGER = LogManager.getLogger(CommonActions.class);
    private final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private final CommonActions commonActions = new CommonActions();
    private final TemporaryEmail tempEmailPage = new TemporaryEmail();

    @And("^user navigates to (.*)$")
    public void userNavigatesToPage(PageURLEnum pageName) {
        commonActions.navigateToPage(pageName);
    }

    @And("^user is on (.*)$")
    @And("^user is redirected to (.*)$")
    public void userIsOnPage(PageURLEnum pageName) {
        commonActions.checkUserIsOnPage(pageName);
    }

    @And("random email is generated and saved")
    public void randomEmailIsGenerated() {
        commonActions.navigateToPage(TEMPORARY_EMAIL_PAGE);
        commonActions.checkUserIsOnPage(TEMPORARY_EMAIL_PAGE);

        String email = tempEmailPage.getRandomEmail();
        scenarioContext.saveData(CURRENT_EMAIL, email);

        LOGGER.info("Generated and saved email: " + email);
    }
}
