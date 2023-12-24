package test.steps;

import io.cucumber.java.en.And;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import test.actions.CommonActions;
import test.actions.RegistrationActions;
import test.context.ScenarioContext;

import static test.context.ScenarioKeys.CURRENT_EMAIL;
import static ui.pages.PageURLEnum.TEMPORARY_EMAIL_PAGE;

public class RegistrationSteps {

    private final static Logger LOGGER = LogManager.getLogger(CommonActions.class);
    private final ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private final CommonActions commonActions = new CommonActions();
    private final RegistrationActions registrationActions = new RegistrationActions();

    @And("new user is registered with random email")
    public void registerNewUser() {
        String email = scenarioContext.getData(CURRENT_EMAIL);
        registrationActions.registerNewUser(email);
        LOGGER.info("Registered user with email: " + email);
    }

    @And("user activates new account")
    public void userActivatesAccount() {
        commonActions.navigateToPage(TEMPORARY_EMAIL_PAGE);
        commonActions.checkUserIsOnPage(TEMPORARY_EMAIL_PAGE);

        String activationLink = registrationActions.activateAccount();
        LOGGER.info("Activation link for new account: " + activationLink);

        commonActions.navigateToPageByURL(activationLink);
        LOGGER.info("Account activated for user with email: " + scenarioContext.getData(CURRENT_EMAIL));
    }
}
