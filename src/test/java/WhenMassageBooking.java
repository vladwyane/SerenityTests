import data.*;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import steps.*;
import steps.account.DashboardSteps;
import steps.booking.ChooseServicesSteps;
import steps.booking.ConfirmationSteps;
import steps.booking.PaymentInformationSteps;
import steps.booking.PrefferedDateTimeSteps;

import java.io.IOException;

/**
 * Created by bigdrop on 10/4/2018.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WhenMassageBooking extends BaseTest {

    @Steps private HomeSteps homeSteps;
    @Steps private CreateAccountSteps createAccountSteps;
    @Steps private GoogleMailSteps googleMailSteps;
    @Steps private FacialServiceSteps facialServiceSteps;
    @Steps private MassageServiceSteps massageServiceSteps;
    @Steps private ChooseServicesSteps chooseServicesSteps;
    @Steps private PrefferedDateTimeSteps prefferedDateTimeSteps;
    @Steps private PaymentInformationSteps paymentInformationSteps;
    @Steps private ConfirmationSteps confirmationSteps;
    @Steps private LocationsSteps locationsSteps;
    @Steps private SignInSteps signInSteps;
    @Steps private DashboardSteps dashboardSteps;


    @Test()
    @Title("Test booking with registration")
    public void test3BookingWithRegistration() throws InterruptedException {
        homeSteps.openHomePage();
        locationsSteps.clickLocationItemFromMainNav();
        locationsSteps.chooseLocationFromLocationPage(LocationsData.DE_BEAR);
        locationsSteps.changeLocation(LocationsData.CHERRY_HILL);
        facialServiceSteps.clickFacialService();
        chooseServicesSteps.chooseServiceAsGuest(ServicesData.NMTFC, false);
        String therapistName = prefferedDateTimeSteps.chooseTherapistAndDateTime(Therapist.ANY_EMPLOYEE, DateTime.OCTOBER04_3PM);
        paymentInformationSteps.fillPaymentInformation(Users.ALLEN, CreditCards.VISA_STRIPE, true);
        signInSteps.openSignInPage();
        signInSteps.logIn(Users.ALLEN);
        dashboardSteps.checkingAppointments(DateTime.OCTOBER04_3PM, therapistName, ServicesData.NMTFC, LocationsData.CHERRY_HILL);
    }

    @Test()
    @Title("Test booking ss guest")
    public void test1BookingAsGuest() throws InterruptedException, IOException {
        homeSteps.openHomePage();
        massageServiceSteps.clickMassageService();
        createAccountSteps.chooseLocation(LocationsData.CHERRY_HILL);
        chooseServicesSteps.chooseServiceAsGuest(ServicesData.NM80, true);
        String therapistName = prefferedDateTimeSteps.chooseTherapistAndDateTime(Therapist.ANY_EMPLOYEE, DateTime.OCTOBER04_3PM);
        paymentInformationSteps.fillPaymentInformation(Users.LEBRON, CreditCards.VISA_STRIPE, false);
        confirmationSteps.checkingSuccessBooking(LocationsData.CHERRY_HILL, ServicesData.NM80, therapistName, DateTime.OCTOBER04_3PM);
    }

    @Test()
    @Title("Test booking as member")
    public void test1BookingAsMember() throws InterruptedException, IOException {
        homeSteps.openHomePage();
        locationsSteps.clickLocationItemFromMainNav();
        locationsSteps.chooseLocationFromLocationPage(LocationsData.CHERRY_HILL);
        massageServiceSteps.clickMassageService();
        chooseServicesSteps.chooseServiceAsMember(ServicesData.NM50, Users.MEMBER, false);
        String therapistName = prefferedDateTimeSteps.chooseTherapistAndDateTime(Therapist.ANY_EMPLOYEE, DateTime.OCTOBER04_3PM);
        paymentInformationSteps.fillPaymentInformationForMember();
        confirmationSteps.checkingSuccessBooking(LocationsData.CHERRY_HILL, ServicesData.NM50, therapistName, DateTime.OCTOBER04_3PM);
    }

    @Test()
    @Title("Test booking as guest with invalid card")
    public void test4BookingAsGuestWithInvalidCard() throws InterruptedException {
        homeSteps.openHomePage();
        facialServiceSteps.clickFacialService();
        createAccountSteps.chooseLocation(LocationsData.CHERRY_HILL);
        chooseServicesSteps.chooseServiceAsGuest(ServicesData.NMTFC, true);
        prefferedDateTimeSteps.chooseTherapistAndDateTime(Therapist.ANY_EMPLOYEE, DateTime.OCTOBER04_3PM);
        paymentInformationSteps.fillPaymentInformation(Users.DWYANE, CreditCards.TEST_CARD, false);
        confirmationSteps.checkingErrorBooking();
    }

    @Test()
    @Title("Test success email booking")
    public void test2SuccessEmailBooking() throws InterruptedException {
        googleMailSteps.signIntoGoogleMail(Users.VLADYSLAV);
        googleMailSteps.checkingEmailBooking();
    }
}
