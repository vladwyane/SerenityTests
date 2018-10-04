package steps;

import data.LocationsData;
import data.Users;
import net.thucydides.core.annotations.Step;
import pages.CreateAccountPage;
import popups.InfoPopup;
import popups.LocationPopup;
import static data.URL_values.*;

/**
 * Created by bigdrop on 10/1/2018.
 */
public class CreateAccountSteps {
    CreateAccountPage createAccPage;
    LocationPopup locPopup;
    InfoPopup infoPopup;

    @Step
    public void openCreateAccPage() {
        createAccPage.open();
        createAccPage.maximiseScreen();
    }

    @Step
    public void fillRegistrationForm(Users users) {
        createAccPage.typeFirstName(users.getFirstName());
        createAccPage.typeLastName(users.getLastName());
        createAccPage.typePassword(users.getNewPassword());
        createAccPage.typeConfirmPassword(users.getConfPassword());
        createAccPage.typeEmail(users.getEmail());
        createAccPage.typePhone(users.getPhone());
    }

    @Step
    public void clickCreateButt() {
        createAccPage.clickCreateAccButt();
    }

    @Step
    public void fillLocationField(LocationsData locationsData) {
        createAccPage.clickLocationField();
        locPopup.chooseLocation(locationsData.getShortLocationName().toUpperCase());
    }

    @Step
    public void openRegistrationPageFromHeader() {
        createAccPage.clickHeaderSignUpLink();
    }

    @Step
    public void checkingErrorNotesAllFieldsAreBlank() {
        createAccPage.checkingErrorNotesAllFieldsAreBlank();
    }

    @Step
    public void checkingErrorNoteNotMatchPassword() {
        createAccPage.checkingErrorNoteNotMatchPassword();
    }

    @Step
    public void checkingSuccessOfRegistration() {
        infoPopup.checkingSuccessOfRegistration();
    }

    @Step
    public void checkingErrorNoteExistEmail(Users users) {
        createAccPage.checkingErrorNoteExistEmail(users.getEmail());
    }

    @Step
    public void chooseLocation(LocationsData locationsData) {
        locPopup.chooseLocation(locationsData.getShortLocationName());
    }
}
