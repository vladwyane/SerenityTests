package steps.booking;

import data.DateTime;
import data.Therapist;
import net.thucydides.core.annotations.Step;
import pages.booking.PrefferedDateTime;

/**
 * Created by bigdrop on 10/4/2018.
 */
public class PrefferedDateTimeSteps {

    PrefferedDateTime prefferedDateTime;

    @Step
    public String chooseTherapistAndDateTime(Therapist therapist, DateTime dateTime) {
        return prefferedDateTime.chooseTherapistAndDateTime(therapist, dateTime);
    }
}
