package steps.booking;

import data.ServicesData;
import data.Users;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import pages.booking.ChooseServices;

/**
 * Created by bigdrop on 10/4/2018.
 */
public class ChooseServicesSteps {

    ChooseServices chooseServices;

    @Step
    public void chooseServiceAsGuest(ServicesData servicesData, boolean addAromaService) throws InterruptedException {
        chooseServices.chooseServiceAsGuest(servicesData, addAromaService);
    }

    @Step
    public void chooseServiceAsMember(ServicesData servicesData, Users users, boolean addAromaService) throws InterruptedException {
        chooseServices.chooseServiceAsMember(servicesData, users, addAromaService);
    }

    @Step
    public void chooseServiceAsFirstVisitor(ServicesData servicesData) throws InterruptedException {
        chooseServices.chooseServiceAsFirstVisitor(servicesData);
    }
}
