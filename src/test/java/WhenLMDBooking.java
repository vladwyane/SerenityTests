import data.CreditCards;
import data.LocationsData;
import data.Users;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import steps.*;
import steps.booking.ChooseServicesSteps;
import steps.booking.ConfirmationSteps;
import steps.booking.PaymentInformationSteps;
import steps.booking.PrefferedDateTimeSteps;

/**
 * Created by bigdrop on 10/4/2018.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WhenLMDBooking extends BaseTest {

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
    @Steps private LastDealsSteps lastDealsSteps;

    @Test()
    @Title("Test LMD booking nothing found")
    public void test2LMDBookingNothingFound() throws InterruptedException {
        homeSteps.openHomePage();
        locationsSteps.clickLocationItemFromMainNav();
        locationsSteps.chooseLocationFromLocationPage(LocationsData.CHERRY_HILL);
        homeSteps.openHomePage();
        lastDealsSteps.checkingNothingFoundSection();
    }

    @Test()
    @Title("Test LMD booking from home page")
    public void test1LMDBookingFromHomePage() throws InterruptedException {
        locationsSteps.openLocationPage();
        locationsSteps.chooseLocationFromLocationPage(LocationsData.CHERRY_HILL);
        homeSteps.openHomePage();
        lastDealsSteps.chooseFirstLMDServiceFromAvailable();
        paymentInformationSteps.fillPaymentInformation(Users.LEBRON, CreditCards.VISA_STRIPE, false);
        confirmationSteps.checkingSuccessLMDBooking();
    }

    @Test()
    @Title("Test LMD booking from spa deals page")
    public void test1LMDBookingFromSpaDealsPage() throws InterruptedException {
        homeSteps.openHomePage();
        lastDealsSteps.clickSpaDealsItemFromMainNav();
        createAccountSteps.chooseLocation(LocationsData.CHERRY_HILL);
        lastDealsSteps.chooseFirstLMDServiceFromAvailable();
        paymentInformationSteps.fillPaymentInformation(Users.LEBRON, CreditCards.VISA_STRIPE, false);
        confirmationSteps.checkingSuccessLMDBooking();
    }

    @Test()
    @Title("Test LMD booking from location page")
    public void test1LMDBookingFromLocationPage() throws InterruptedException {
        locationsSteps.openLocationPage();
        locationsSteps.moveToLocationDetail(LocationsData.CHERRY_HILL);
        lastDealsSteps.chooseFirstLMDServiceFromAvailable();
        paymentInformationSteps.fillPaymentInformation(Users.LEBRON, CreditCards.VISA_STRIPE, false);
        confirmationSteps.checkingSuccessLMDBooking();
    }
}
