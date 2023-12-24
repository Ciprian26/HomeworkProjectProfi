package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.utils.WaitUtils;
import ui.driver.Driver;

import java.time.Duration;

public class TemporaryEmail implements Page {

    @FindBy(xpath = "//div[@class='flex h-full w-full cursor-pointer flex-row items-center justify-between rounded-xl bg-gray-1 shadow-sm  px-4 py-3']//p")
    private WebElement temporaryEmailLabel;

    @FindBy(xpath = "//p[@title='noreply@profit.com']")
    private WebElement inboxRecievedEmail;

    @FindBy(xpath = "//a[@class='link active-link-green link-confirmation font-20 bold-500']")
    private WebElement activateAccountButton;

    @FindBy(xpath = "(//div[@class='flex w-full flex-row justify-between rounded-tl-xl border-b border-gray-10 bg-gray-5 px-4 py-5']//*[name()='svg'])[2]")
    private WebElement refreshButton;

    public TemporaryEmail() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getRandomEmail() {
        return temporaryEmailLabel.getText();
    }

    public String activateAccount() {
        Wait<WebDriver> wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        WaitUtils.clickUntilElementDisplayed(refreshButton, inboxRecievedEmail);

        wait.until(ExpectedConditions.visibilityOf(inboxRecievedEmail));
        inboxRecievedEmail.click();

        wait.until(ExpectedConditions.visibilityOf(activateAccountButton));
        return activateAccountButton.getText();

    }
}
