package ui.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.driver.Driver;

import java.time.Duration;

public class Profit implements Page {

    private static final String PASSWORD = "testpassword123";

    @FindBy(xpath = "//button[text()='access now']")
    private WebElement acessNowButton;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[@data-test-id='signup']")
    private WebElement singUpLabel;

    @FindBy(xpath = "//button[@data-test-id='email-auth-btn']")
    private WebElement signUpWithIdButton;

    @FindBy(xpath = "//input[@name='first_name']")
    private WebElement firstNameLabel;

    @FindBy(xpath = "//input[@name='last_name']")
    private WebElement lastNameLabel;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@data-test-id='email_signup_success']")
    private WebElement emailSignUpSuccessLabel;

    @FindBy(xpath = "//button[@data-test-id='user-menu-open']")
    private WebElement userMenuButton;

    public Profit() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void registerUser(String email) {
        Wait<WebDriver> wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        acessNowButton.click();
        wait.until(ExpectedConditions.visibilityOf(singUpLabel));
        singUpLabel.click();
        wait.until(ExpectedConditions.visibilityOf(signUpWithIdButton));
        signUpWithIdButton.click();

        wait.until(ExpectedConditions.visibilityOf(firstNameLabel));

        firstNameLabel.sendKeys("John");
        lastNameLabel.sendKeys("Doe");
        emailField.sendKeys(email);
        passwordField.sendKeys(PASSWORD);

        submitButton.click();

        wait.until(ExpectedConditions.visibilityOf(emailSignUpSuccessLabel));
    }

    public boolean checkUserLogIn() {
        return userMenuButton.isDisplayed();
    }
}
