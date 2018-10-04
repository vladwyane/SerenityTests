package pages;

import data.LocationsData;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

import static data.URL_values.*;

/**
 * Created by bigdrop on 10/2/2018.
 */
@DefaultUrl(LOCATION_URL)
public class LocationsPage extends BasePage {

    @FindBy(xpath = "//input[@value='Find Stores']")
    private WebElement findStoreBut;

    @FindBy(id = "search-locations-address")
    private WebElement searchField;

    @FindBys( {@FindBy(css = ".ui-autocomplete li")} )
    public List<WebElement> listLocationFromAutocom;

    @FindBys( {@FindBy(xpath = "//a[contains(text(), 'More details')]")} )
    public List<WebElement> listButDetailLocation;

    @FindBys( {@FindBy(xpath = "//a[contains(text(), 'Make it my store')]")} )
    public List<WebElement> listButAvailableLocation;

    public WebElement getSearchField() {
        return searchField;
    }

    public WebElement getFindStoreBut() {
        return findStoreBut;
    }

    public void clickFindStoreBut() {
        findStoreBut.click();
    }

    public List<WebElement> getListLocationFromAutocom() {
        return listLocationFromAutocom;
    }

    public LocationsPage chooseLocationFromLocationPage(LocationsData locationsData) {
        typeInto(getSearchField(), locationsData.getShortLocationName());
        getListLocationFromAutocom().get(0).click();
        clickFindStoreBut();
        listButAvailableLocation.get(0).click();
        return this;
    }

    public LocationsPage moveToLocationDetail(LocationsData locationsData) {
        typeInto(getSearchField(), locationsData.getShortLocationName());
        getListLocationFromAutocom().get(0).click();
        clickFindStoreBut();
        listButDetailLocation.get(0).click();
        return this;
    }

    public void clickLocationItemFromMainNav() {
        waiting2seconds();
        clickHeaderMenuItem("Location");
    }

}
