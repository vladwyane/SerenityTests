import data.*;
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

import java.io.IOException;

/**
 * Created by bigdrop on 10/4/2018.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WhenIntroBooking extends BaseTest {

    @Steps private HomeSteps homeSteps;
    @Steps private CreateAccountSteps createAccountSteps;
    @Steps private GoogleMailSteps googleMailSteps;
    @Steps private FacialServiceSteps facialServiceSteps;
    @Steps private MassageServiceSteps massageServiceSteps;
    @Steps private ChooseServicesSteps chooseServicesSteps;
    @Steps private PrefferedDateTimeSteps prefferedDateTimeSteps;
    @Steps private PaymentInformationSteps paymentInformationSteps;
    @Steps private ConfirmationSteps confirmationSteps;

    @Test()
    @Title("Test booking as fist time visitor")
    public void test1BookingAsFistTimeVisitor() throws InterruptedException, IOException {
        homeSteps.openHomePage();
        massageServiceSteps.clickMassageService();
        createAccountSteps.chooseLocation(LocationsData.CHERRY_HILL);
        chooseServicesSteps.chooseServiceAsFirstVisitor(ServicesData.INTROHS50);
        String therapistName = prefferedDateTimeSteps.chooseTherapistAndDateTime(Therapist.ANY_EMPLOYEE, DateTime.OCTOBER04_3PM);
        paymentInformationSteps.fillPaymentInformation(Users.ALLEN, CreditCards.VISA_STRIPE, false);
        confirmationSteps.checkingSuccessBooking(LocationsData.CHERRY_HILL, ServicesData.INTROHS50, therapistName, DateTime.OCTOBER04_3PM);
    }

    @Test()
    @Title("Test booking as fist time visitor with exist email")
    public void test2BookingAsFistTimeVisitorWithExistEmail() throws InterruptedException {
        homeSteps.openHomePage();
        massageServiceSteps.clickMassageService();
        createAccountSteps.chooseLocation(LocationsData.CHERRY_HILL);
        chooseServicesSteps.chooseServiceAsFirstVisitor(ServicesData.INTROHS50);
        prefferedDateTimeSteps.chooseTherapistAndDateTime(Therapist.ANY_EMPLOYEE, DateTime.OCTOBER04_3PM);
        paymentInformationSteps.fillPaymentInformation(Users.ALLEN, CreditCards.VISA_STRIPE, false);
        confirmationSteps.checkingErrorBooking();
    }
}
