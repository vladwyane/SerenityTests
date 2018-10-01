package popups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;
import pages.CreateAccountPage;

import java.util.List;

/**
 * Created by bigdrop on 10/1/2018.
 */
public class LocationPopup extends BasePage{

    @FindBy(xpath = "//div[@aria-label='Locations']//a[contains(text(), 'Find locations')]")
    private WebElement findLocationLink;

    @FindBy(css = ".location-popup-loader .icon-arrow_right")
    protected WebElement rightArrowOfCarousel;

    @FindBys( {@FindBy(css = ".location-popup-loader li h6")} )
    private List<WebElement> titlesLocationList;

    @FindBys( {@FindBy(xpath = "//div[contains (@class, 'location-popup-loader')]//li//a[contains (@class, 'btn')]")} )
    private List<WebElement> selectButLocationList;

    @FindBy(id = "location-popup-address")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='search-location']//input[@value='Find Stores']")
    private WebElement findStoreBut;

    public void clickFindLocationLink() {
        clickOn(findLocationLink);
    }

    public void clickRightArrowOfCarousel() {
        clickOn(rightArrowOfCarousel);
    }

    public String getTitleOfLocation(int index) {
        return titlesLocationList.get(index).getText();
    }

    public LocationPopup clickSelectButOfLocation(int index) {
        clickOn(selectButLocationList.get(index));
        return this;
    }

    public LocationPopup typeEmail(String search) {
        typeInto(searchField, search);
        return this;
    }

    public LocationPopup clickFindStoreBut() {
        clickOn(findStoreBut);
        return this;
    }
}
