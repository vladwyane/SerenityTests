package steps;


import data.LocationsData;
import net.thucydides.core.annotations.Step;
import pages.LastDealsPage;
import pages.LocationsPage;
import popups.LocationPopup;

/**
 * Created by bigdrop on 10/4/2018.
 */
public class LocationsSteps {

    LocationsPage locationsPage;
    LocationPopup locationPopup;

    @Step
    public void clickLocationItemFromMainNav() {
        locationsPage.clickLocationItemFromMainNav();
    }

    @Step
    public void chooseLocationFromLocationPage(LocationsData locationsData) {
        locationsPage.chooseLocationFromLocationPage(locationsData);
    }

    @Step
    public void changeLocation(LocationsData locationsData) {
        locationPopup.clickChangeLocationHeaderLink();
        locationPopup.chooseLocation(locationsData.getShortLocationName());
    }

    @Step
    public void openLocationPage() {
        locationsPage.open();
        locationsPage.maximiseScreen();
    }

    @Step
    public void moveToLocationDetail(LocationsData locationsData) {
        locationsPage.moveToLocationDetail(locationsData);
    }
}
