package test.steps;

import io.cucumber.java.en.And;
import test.actions.CommonActions;
import ui.pages.Profit;

import static org.hamcrest.Matchers.is;
import static test.utils.AssertUtils.assertThat;
import static ui.pages.PageURLEnum.PROFIT_PAGE;

public class LogInSteps {

    private final CommonActions commonActions = new CommonActions();
    private final Profit profitPage = new Profit();

    @And("user is logged-in")
    public void userIsLoggedIn() {
        commonActions.checkUserIsOnPage(PROFIT_PAGE);
        assertThat("User is logged in", profitPage.checkUserLogIn(), is(true));
    }
}
