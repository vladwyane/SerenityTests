package pages;

import data.Users;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static data.URL_values.*;

/**
 * Created by bigdrop on 10/2/2018.
 */
@DefaultUrl(SIGN_IN_URL)
public class SignInPage extends BasePage {

    @FindBy(id = "login-authorization-email")
    private WebElement emailField;

    @FindBy(id = "login-authorization-password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains (text(), 'Create an Account')]")
    private WebElement createAccountButton;

    @FindBy(xpath = "//a[contains (text(), 'Forgot your Password')]")
    private WebElement forgotPasswordLink;

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }

    public void logIn(Users users) {
        typeInto(getEmailField(), users.getEmail());
        typeInto(getPasswordField(), users.getNewPassword());
        clickLoginButton();
    }
}
