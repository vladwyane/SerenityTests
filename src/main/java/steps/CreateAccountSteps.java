package steps;

import data.Users;
import net.thucydides.core.annotations.Step;
import pages.CreateAccountPage;

/**
 * Created by bigdrop on 10/1/2018.
 */
public class CreateAccountSteps {

    CreateAccountPage page;

    @Step
    public void openCreateAccPage() {
        page.open();
        page.maximiseScreen();
    }

    @Step
    public void fillRegistrationForm(Users users) {
        page.typeFirstName(users.getFirstName());
        page.typeLastName(users.getLastName());
        page.typePassword(users.getNewPassword());
        page.typeConfirmPassword(users.getConfPassword());
        page.typeEmail(users.getEmail());
        page.typePhone(users.getPhone());
    }

    @Step
    public void clickCreateButt() {
        page.clickCreateAccButt();
    }

}
