package steps.booking;

import data.CreditCards;
import data.Users;
import net.thucydides.core.annotations.Step;
import pages.booking.PaymentInformation;

/**
 * Created by bigdrop on 10/4/2018.
 */
public class PaymentInformationSteps {

    PaymentInformation paymentInformation;

    @Step
    public void fillPaymentInformation(Users users, CreditCards creditCards, boolean createAccount) {
        paymentInformation.fillPaymentInformation(users, creditCards, createAccount);
    }

    @Step
    public void fillPaymentInformationForMember() throws InterruptedException {
        paymentInformation.fillPaymentInformationForMember();
    }
}
