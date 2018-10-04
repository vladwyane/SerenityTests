package steps.account;

import data.DateTime;
import data.LocationsData;
import data.ServicesData;
import data.Users;
import net.thucydides.core.annotations.Step;
import pages.account.DashboardPage;

/**
 * Created by bigdrop on 10/3/2018.
 */
public class DashboardSteps {

    DashboardPage dashboardPage;

    @Step
    public void logOut() {
        dashboardPage.logOut();
    }

    @Step
    public void checkingAccountDashboard(Users users) {
        dashboardPage.checkingAccountDashboard(users);
    }

    @Step
    public void clickAccInfoLink() {
        dashboardPage.clickAccInfoLink();
    }

    @Step
    public void checkingAppointments(DateTime dateTime, String therapistName, ServicesData servicesData, LocationsData locationsData) {
        dashboardPage.checkingAppointments(dateTime, therapistName, servicesData, locationsData);
    }
}
