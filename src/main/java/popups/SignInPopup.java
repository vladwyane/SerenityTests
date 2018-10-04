package popups;

import data.Users;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

/**
 * Created by bigdrop on 10/2/2018.
 */
public class SignInPopup extends BasePage {

    @FindBy(id = "sign-in-popup-email")
    private WebElement emailField;

    @FindBy(id = "sign-in-popup-password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[contains (text(), 'Forgot your Password')]")
    private WebElement forgotPasswordLink;

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public WebElement getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public void logInFromSignInPopup(Users users) {
        typeInto(getEmailField(), users.getEmail());
        typeInto(getPasswordField(), users.getNewPassword());
        clickSignInButton();
    }

}
