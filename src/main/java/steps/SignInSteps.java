package steps;

import data.Users;
import net.thucydides.core.annotations.Step;
import pages.CreateAccountPage;
import pages.SignInPage;
import popups.SignInPopup;

/**
 * Created by bigdrop on 10/2/2018.
 */
public class SignInSteps {

    SignInPage signInPage;
    SignInPopup signInPopup;

    @Step
    public void openSignInPage() {
        signInPage.open();
        signInPage.maximiseScreen();
    }

    @Step
    public CreateAccountPage openCreateAccPageFromSignIn() {
        signInPage.open();
        signInPage.clickCreateAccountButton();
        return new CreateAccountPage();
    }

    @Step
    public void logIn(Users users) {
        signInPage.logIn(users);
    }

    @Step
    public void logInFromSignInPopup(Users users) {
        signInPopup.logInFromSignInPopup(users);
    }

    @Step
    public void openSignInPopup() {
        signInPage.clickHeaderSignInLink();
    }
}
