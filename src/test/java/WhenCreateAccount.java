import data.LocationsData;
import data.Users;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import steps.CreateAccountSteps;
import steps.GoogleMailSteps;
import steps.HomeSteps;
import steps.SignInSteps;

/**
 * Created by bigdrop on 10/1/2018.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WhenCreateAccount extends BaseTest {

    @Steps private CreateAccountSteps createAccountSteps;
    @Steps private HomeSteps homeSteps;
    @Steps private SignInSteps signInSteps;
    @Steps private GoogleMailSteps googleMailSteps;

    @Test
    @Title("Test success registration from sign up page")
    public void test1SuccessRegistrationFromSignUpPage() {
        homeSteps.openHomePage();
        createAccountSteps.openRegistrationPageFromHeader();
        createAccountSteps.fillRegistrationForm(Users.LEBRON);
        createAccountSteps.clickCreateButt();
        createAccountSteps.checkingSuccessOfRegistration();
    }

    @Test
    @Title("Test success registration from sign in page")
    public void test1SuccessRegistrationFromSignInPage() {
        createAccountSteps.openCreateAccPage();
        createAccountSteps.fillRegistrationForm(Users.DWYANE);
        createAccountSteps.fillLocationField(LocationsData.CHERRY_HILL);
        createAccountSteps.clickCreateButt();
        createAccountSteps.checkingSuccessOfRegistration();
    }

    @Test
    @Title("Test error registration all fields blank")
    public void test3ErrorRegistrationAllFieldsBlank() {
        createAccountSteps.openCreateAccPage();
        createAccountSteps.clickCreateButt();
        createAccountSteps.checkingErrorNotesAllFieldsAreBlank();
    }

    @Test
    @Title("Test error registration not match password")
    public void test3ErrorRegistrationNotMatchPassword() {
        createAccountSteps.openCreateAccPage();
        createAccountSteps.fillRegistrationForm(Users.INVALID);
        createAccountSteps.clickCreateButt();
        createAccountSteps.checkingErrorNoteNotMatchPassword();
    }

    @Test()
    @Title("Test error registration exist email")
    public void test3ErrorRegistrationExistEmail() {
        signInSteps.openCreateAccPageFromSignIn();
        createAccountSteps.fillRegistrationForm(Users.LEBRON);
        createAccountSteps.clickCreateButt();
        createAccountSteps.checkingErrorNoteExistEmail(Users.LEBRON);
    }

    @Test()
    @Title("Test success email registration")
    public void test2SuccessEmailRegistration() throws InterruptedException {
        googleMailSteps.signIntoGoogleMail(Users.VLADYSLAV);
        googleMailSteps.checkingEmailRegistration();
    }

}
