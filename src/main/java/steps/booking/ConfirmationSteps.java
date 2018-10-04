package steps.booking;

import data.DateTime;
import data.LocationsData;
import data.ServicesData;
import net.thucydides.core.annotations.Step;
import pages.booking.Confirmation;

import java.io.IOException;

/**
 * Created by bigdrop on 10/4/2018.
 */
public class ConfirmationSteps {

    Confirmation confirmation;

    @Step
    public void checkingSuccessBooking(LocationsData locationsData, ServicesData servicesData, String therapistName, DateTime dateTime) throws IOException {
        confirmation.checkingSuccessBooking(locationsData, servicesData, therapistName, dateTime);
    }

    @Step
    public void checkingErrorBooking() {
        confirmation.checkingErrorBooking();
    }

    @Step
    public void checkingSuccessLMDBooking() {
        confirmation.checkingSuccessLMDBooking();
    }
}
