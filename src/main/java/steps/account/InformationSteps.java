package steps.account;

import data.Users;
import net.thucydides.core.annotations.Step;
import pages.account.InformationPage;

/**
 * Created by bigdrop on 10/3/2018.
 */
public class InformationSteps {

    InformationPage informationPage;

    @Step
    public void checkAccountContactInfo(Users users) {
        informationPage.checkAccountContactInfo(users);
    }

    @Step
    public void updateContactInfo(Users users) {
        informationPage.updateContactInfo(users);
    }

    @Step
    public void checkingSuccessPopup() {
        informationPage.checkingSuccessPopup();
    }

    public void changePassword(Users users) {
        informationPage.changePassword(users);
    }
}
