package popups;

import data.Users;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

/**
 * Created by bigdrop on 10/4/2018.
 */
public class ResetPasswordPopup extends BasePage {

    @FindBy(id = "popup-new-password-password")
    private WebElement newPasswordField;

    @FindBy(id = "popup-new-password-repeat-password")
    private WebElement newPasswordRepeatField;

    @FindBy(xpath = "//input[@value='Reset Password']")
    private WebElement resetPassButton;

    public WebElement getNewPasswordField() {
        return newPasswordField;
    }

    public WebElement getNewPasswordRepeatField() {
        return newPasswordRepeatField;
    }

    public void clickResetPassBut() {
        resetPassButton.click();
    }


    public void resetNewPassword(Users users) throws InterruptedException {
        waiting2seconds();
        typeInto(getNewPasswordField(), users.getNewPassword());
        typeInto(getNewPasswordRepeatField(), users.getNewPassword());
        clickResetPassBut();
    }
}
