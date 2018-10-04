package steps;

import data.Users;
import net.thucydides.core.annotations.Step;
import pages.GoogleMail;

/**
 * Created by bigdrop on 10/3/2018.
 */
public class GoogleMailSteps {

    GoogleMail googleMail;

    @Step
    public String signIntoGoogleMail(Users users) throws InterruptedException {
        return googleMail.signIntoGoogleMail(users);
    }

    @Step
    public void checkingEmailRegistration() {
        googleMail.checkingEmailRegistration();
    }

    @Step
    public void checkingEmailChangePass() {
        googleMail.checkingEmailChangePass();
    }

    @Step
    public void checkingEmailBooking() {
        googleMail.checkingEmailBooking();
    }
}
