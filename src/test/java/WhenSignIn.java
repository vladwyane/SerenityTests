import data.Users;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import steps.GoogleMailSteps;
import steps.HomeSteps;
import steps.SignInSteps;
import steps.account.DashboardSteps;
import steps.account.InformationSteps;

/**
 * Created by bigdrop on 10/3/2018.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WhenSignIn extends BaseTest {

    @Steps private SignInSteps signInSteps;
    @Steps private DashboardSteps dashboardSteps;
    @Steps private HomeSteps homeSteps;
    @Steps private InformationSteps informationSteps;
    @Steps private GoogleMailSteps googleMailSteps;

    @Test()
    @Title("Test success log in from sign in popup")
    public void test1SuccessLogInFromSignInPopup() throws InterruptedException {
        homeSteps.openHomePage();
        signInSteps.openSignInPopup();
        signInSteps.logInFromSignInPopup(Users.LEBRON);
        dashboardSteps.checkingAccountDashboard(Users.LEBRON);
    }

    @Test()
    @Title("Test success log in from sign in page")
    public void test1SuccessLogInFromSignInPage() throws InterruptedException {
        signInSteps.openSignInPage();
        signInSteps.logIn(Users.DWYANE);
        dashboardSteps.clickAccInfoLink();
        informationSteps.checkAccountContactInfo(Users.DWYANE);
    }

    @Test()
    @Title("Test success update contact info")
    public void test1SuccessUpdateContactInfo() throws InterruptedException {
        signInSteps.openSignInPage();
        signInSteps.logIn(Users.DWYANE);
        dashboardSteps.clickAccInfoLink();
        informationSteps.updateContactInfo(Users.DWYANE);
        informationSteps.checkingSuccessPopup();
    }

    @Test()
    @Title("Test success change password")
    public void test2SuccessChangePassword() throws InterruptedException {
        signInSteps.openSignInPage();
        signInSteps.logIn(Users.LEBRON);
        dashboardSteps.clickAccInfoLink();
        informationSteps.changePassword(Users.LEBRON_UPDATE);
        informationSteps.checkingSuccessPopup();
    }

    @Test()
    @Title("Test success email change password")
    public void test3SuccessEmailChangePassword() throws InterruptedException {
        googleMailSteps.signIntoGoogleMail(Users.VLADYSLAV);
        googleMailSteps.checkingEmailChangePass();
    }
}
