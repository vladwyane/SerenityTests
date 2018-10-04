package pages;

import data.Users;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import static data.URL_values.*;

import java.util.List;

/**
 * Created by bigdrop on 10/3/2018.
 */
@DefaultUrl(GOOGLE_MAIL_URL)
public class GoogleMail extends BasePage {

    @FindBy(name = "identifier")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(id = "identifierNext")
    private WebElement nextIndButton;

    @FindBy(id = "passwordNext")
    private WebElement nextPassButton;

    @FindBy(xpath = "//a[contains(@href, 'reset-password')]")
    private WebElement resetPasswordLink;

    @FindBys( {@FindBy(css = ".bog")} )
    public List<WebElement> listTitleLetters;

    @FindBy(xpath = "//a[contains(@aria-label, 'Google Account')]")
    private WebElement accountAva;

    @FindBy(xpath = "//a[contains(text(), 'Sign out')]")
    private WebElement signOutBut;

    public String signIntoGoogleMail(Users users) throws InterruptedException {
        open();
        element(nextIndButton).waitUntilVisible();
        typeInto(loginField, users.getEmail());
        nextIndButton.click();
        element(nextPassButton).waitUntilVisible();
        typeInto(passwordField, users.getNewPassword());
        nextPassButton.click();
        Thread.sleep(5000);
        String titleLetter = listTitleLetters.get(0).getText();
        return titleLetter;
    }

    public String returnResetPassLink() {
        listTitleLetters.get(0).click();
        waiting2seconds();
        return resetPasswordLink.getAttribute("href");
    }

    public void checkingEmailChangePass() {
        softAssert.assertEquals(listTitleLetters.get(0).getText(), "Change Password");
        softAssert.assertAll();
    }

    public void checkingEmailRegistration() {
        softAssert.assertEquals(listTitleLetters.get(0).getText(), "Hand&Stone");
        softAssert.assertAll();
    }

    public void checkingEmailBooking() {
        softAssert.assertEquals(listTitleLetters.get(0).getText(), "Hand&Stone Booking");
        softAssert.assertAll();
    }

    public void checkingEmailBookingWithRegistration() {
        softAssert.assertEquals(listTitleLetters.get(0).getText(), "Hand&Stone");
        softAssert.assertEquals(listTitleLetters.get(2).getText(), "Hand&Stone Booking");
        softAssert.assertAll();
    }

    public void checkingEmailResetPassword() {
        softAssert.assertEquals(listTitleLetters.get(0).getText(), "Password reset for Hand&Stone");
        softAssert.assertAll();
    }

    public void accountLogout() {
        if (element(accountAva).isPresent()) {
            accountAva.click();
            element(signOutBut).waitUntilClickable();
            signOutBut.click();
        }
    }
}
