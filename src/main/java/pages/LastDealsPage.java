package pages;

import data.Users;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

import static data.URL_values.*;

/**
 * Created by bigdrop on 10/4/2018.
 */

@DefaultUrl(LAST_DEALS_URL)
public class LastDealsPage extends BasePage {

    @FindBy(css = ".nothing-found")
    private WebElement nothingFoundSection;

    @FindBy(xpath = "(//span[contains(@class, 'ui-slider-handle')])[1]")
    private WebElement sliderRangeFirstBullet;

    @FindBy(xpath = "(//span[contains(@class, 'ui-slider-handle')])[2]")
    private WebElement sliderRangeLastBullet;

    @FindBy(xpath = "//button[contains(text(), 'submit')]")
    private WebElement submitButton;

    @FindBys( {@FindBy(xpath = "//a[contains(text(), 'PURCHASE NOW')]")} )
    private List<WebElement> purchaseButList;

    public WebElement getNothingFoundSection() {
        return nothingFoundSection;
    }

    public WebElement getSliderRangeFirstBullet() {
        return sliderRangeFirstBullet;
    }

    public WebElement getSliderRangeLastBullet() {
        return sliderRangeLastBullet;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public void moveRangeSliderFullWidth(WebDriver driver) {
        Actions move = new Actions(driver);
        Action actionFirstBull = move.dragAndDropBy(sliderRangeFirstBullet, -500, 0).build();
        actionFirstBull.perform();
        Action actionLastBull = move.dragAndDropBy(sliderRangeLastBullet, 500, 0).build();
        actionLastBull.perform();
    }

    public void moveRangeSliderNullWidth(WebDriver driver) {
        Actions move = new Actions(driver);
        Action actionFirstBull = move.dragAndDropBy(sliderRangeFirstBullet, -500, 0).build();
        actionFirstBull.perform();
        Action actionLastBull = move.dragAndDropBy(sliderRangeLastBullet, -500, 0).build();
        actionLastBull.perform();
    }

    public List<WebElement> getPurchaseButList() {
        return purchaseButList;
    }

    public void chooseFirstLMDServiceFromAvailable() throws InterruptedException {
        moveRangeSliderFullWidth(getDriver());
        waiting2seconds();
        getSubmitButton().click();
        purchaseButList.get(0).click();
    }

    public void clickSpaDealsItemFromMainNav() {
        waiting2seconds();
        clickHeaderMenuItem("Spa Deals");
    }

    public void checkingNothingFoundSection() throws InterruptedException {
        moveRangeSliderNullWidth(getDriver());
        waiting2seconds();
        getSubmitButton().click();
        softAssert.assertTrue(element(getNothingFoundSection()).isPresent(), "Section not found");
        softAssert.assertAll();
    }

    public void checkingFirstVisitPopup(String labelPopup) {
        softAssert.assertEquals(labelPopup, "If you are experiencing any issues with the website - please clear your browser cache.");
        softAssert.assertAll();
    }
}
