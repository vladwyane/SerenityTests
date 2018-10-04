package pages.booking;

import data.DateTime;
import data.Therapist;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;

import java.util.List;

/**
 * Created by bigdrop on 10/4/2018.
 */
public class PrefferedDateTime extends BasePage {

    @FindBys( {@FindBy(xpath = "//div[@class='time-slider']//li//button")} )
    public List<WebElement> listTimeTherapist;

    @FindBy(xpath = "//div[@class='time-slider']//button[@aria-pressed='true']//ancestor::div[@class='time-slider']/h3")
    private WebElement therapistNameActive;

    @FindBys( {@FindBy(css = ".date-list li button")} )
    public List<WebElement> listAppointmentDate;

    @FindBy(css = "button.next")
    protected WebElement nextArrowOfCarousel;

    @FindBy(css = "button.prev")
    protected WebElement prevArrowOfCarousel;

    @FindBys( {@FindBy(css = ".preferences-list li")} )
    public List<WebElement> listTherapistPreferences;

    @FindBy(css= "a.continue")
    private WebElement continueBut;

    public List<WebElement> getListTimeTherapist() {
        return listTimeTherapist;
    }

    public WebElement getTherapistNameActive() {
        return therapistNameActive;
    }

    public List<WebElement> getListAppointmentDate() {
        return listAppointmentDate;
    }

    public WebElement getNextArrowOfCarousel() {
        return nextArrowOfCarousel;
    }

    public void clickNextArrow() {
        nextArrowOfCarousel.click();
    }

    public WebElement getPrevArrowOfCarousel() {
        return prevArrowOfCarousel;
    }

    public void clickPrevArrow() {
        prevArrowOfCarousel.click();
    }

    public List<WebElement> getListTherapistPreferences() {
        return listTherapistPreferences;
    }

    public void chooseTherapistPreferences(String therapistSpecific) {
        for (int i = 0; i < listTherapistPreferences.size(); i++) {
            if (therapistSpecific.equals(listTherapistPreferences.get(i).getText())) {
                listTherapistPreferences.get(i).click();
                return;
            }
        }
        listTherapistPreferences.get(0).click();
    }

    public String chooseTherapistAndDateTime(Therapist therapist, DateTime dateTime) {
        //waiting for prod
        waiting2seconds();
        element(getListTherapistPreferences().get(0)).waitUntilClickable();
        chooseTherapistPreferences(therapist.getTherapistSpecific());
        chooseAppointmentDate(dateTime);
        String therapistName = chooseAppointmentTime(dateTime);
        waiting2seconds();
        continueBut.click();
        return therapistName;
    }

    public void chooseAppointmentDate(DateTime dateTime) {
        List<WebElement> listDate = getListAppointmentDate();
        for (int i = 0; i < listDate.size() - 30; i++) {
            if(!element(listDate.get(i)).isVisible()) {
                clickNextArrow();
                //waiting for prod
                waiting2seconds();
            }
            if(listDate.get(i).getText().contains(dateTime.getDate()) && !isElementContainsAttributeValue(listDate.get(i), "class", "disabled")) {
                listDate.get(i).click();
                return;
            }
        }
        for (int i = listDate.size() - 30; i > 0; i--) {
            if(element(listDate.get(i)).isVisible())
                clickPrevArrow();
            if(!isElementContainsAttributeValue(listDate.get(i), "class", "disabled")) {
                listDate.get(i).click();
                return;
            }
        }
        listDate.get(1).click();
    }

    public String chooseAppointmentTime(DateTime dateTime) {
        List<WebElement> listTime = getListTimeTherapist();
        for (int i = 0; i < listTime.size(); i++) {
            if(listTime.get(i).getText().contains(dateTime.getTime()) && !isElementContainsAttributeValue(listTime.get(i), "class", "disabled")) {
                listTime.get(i).click();
                return getTherapistNameActive().getText();
            }
        }
        for (int i = 0; i < listTime.size(); i++) {
            if(!isElementContainsAttributeValue(listTime.get(i), "class", "disabled") && element(listTime.get(i)).isVisible()) {
                listTime.get(i).click();
                return getTherapistNameActive().getText();
            }
        }
        return null;
    }
}
