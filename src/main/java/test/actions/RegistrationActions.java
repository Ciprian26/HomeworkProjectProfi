package test.actions;

import ui.pages.Profit;
import ui.pages.TemporaryEmail;

public class RegistrationActions {

    private final Profit profitPage = new Profit();

    private final TemporaryEmail tempEmailPage = new TemporaryEmail();

    public void registerNewUser(String email) {
        profitPage.registerUser(email);
    }

    public String activateAccount() {
        return tempEmailPage.activateAccount();
    }
}
