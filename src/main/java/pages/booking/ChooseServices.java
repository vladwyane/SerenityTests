package pages.booking;

import data.ServicesData;
import data.Users;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;

import java.util.List;

/**
 * Created by bigdrop on 10/4/2018.
 */
public class ChooseServices extends BasePage {

    @FindBys( {@FindBy(xpath = "//span[(@class='duration')]//following-sibling::h4")} )
    public List<WebElement> listIntroTitles;

    @FindBys( {@FindBy(xpath = "//a[contains(text(), 'select')]")} )
    public List<WebElement> listIntroServiceBut;

    @FindBys({@FindBy(css = ".add-services-list li")})
    public List<WebElement> listAddServices;

    @FindBys({@FindBy(css = ".duration-list .time")})
    public List<WebElement> listTimeDuration;

    @FindBy(xpath = "//a[contains(text(), 'first time')]")
    private WebElement firstVisitorBut;

    @FindBy(xpath = "//a[contains(text(), 'Continue as Guest')]")
    private WebElement continueAsGuestBut;

    @FindBy(id = "authorization-email")
    private WebElement emailField;

    @FindBy(id = "authorization-password")
    private WebElement passwordField;

    @FindBy(xpath = "//a[contains(text(), 'Forgot your Password?')]")
    private WebElement forgorPassLink;

    @FindBy(xpath = "//input[@value='login']")
    private WebElement loginBut;

    @FindBys({@FindBy(css = ".service-content li h4")})
    public List<WebElement> listTitleServ;

    @FindBys({@FindBy(xpath = "//div[contains(@class, 'service-content')]//a[contains(@class, 'btn-')]")})
    public List<WebElement> listButBookNow;

    @FindBy(css = "a.continue")
    private WebElement continueBut;

    public List<WebElement> getListAddServices() {
        return listAddServices;
    }

    public List<WebElement> getListIntroTitles() {
        return listIntroTitles;
    }

    public List<WebElement> getListIntroServiceBut() {
        return listIntroServiceBut;
    }

    public void chooseAddAromaService() {
        listAddServices.get(0).click();
    }

    public List<WebElement> getListTimeDuration() {
        return listTimeDuration;
    }

    public void chooseTimeDuration(String time) {
        for (int i = 0; i < listTimeDuration.size(); i++) {
            if (time.equals(listTimeDuration.get(i).getText())) {
                listTimeDuration.get(i).click();
                return;
            }
        }
        listTimeDuration.get(listTimeDuration.size() - 1).click();
    }

    public WebElement getFirstVisitorBut() {
        return firstVisitorBut;
    }

    public WebElement getContinueAsGuestBut() {
        return continueAsGuestBut;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getForgorPassLink() {
        return forgorPassLink;
    }

    public WebElement getLoginBut() {
        return loginBut;
    }

    public void chooseService(String serviceName) {
        element(listTitleServ.get(0)).waitUntilVisible();
        for (int i = 0; i < listTitleServ.size(); i++) {
            if (serviceName.equals(listTitleServ.get(i).getText())) {
                listButBookNow.get(i).click();
                return;
            }
        }
        listButBookNow.get(listButBookNow.size() - 1).click();
    }

    public void chooseServiceAsGuest(ServicesData servicesData, boolean addAromaService) throws InterruptedException {
        getContinueAsGuestBut().click();
        chooseService(servicesData.getServiceName());
        scrollToElement(getListTimeDuration().get(0));
        chooseTimeDuration(servicesData.getDuration());
        scrollToElement(getListAddServices().get(0));
        if (addAromaService == true)
            chooseAddAromaService();
        continueBut.click();
    }

    public void chooseServiceAsMember(ServicesData servicesData, Users users, boolean addAromaService) throws InterruptedException {
        typeInto(getEmailField(), users.getEmail());
        typeInto(getPasswordField(), users.getNewPassword());
        getLoginBut().click();
        chooseService(servicesData.getServiceName());
        scrollToElement(getListTimeDuration().get(0));
        chooseTimeDuration(servicesData.getDuration());
        scrollToElement(getListAddServices().get(0));
        if (addAromaService == true)
            chooseAddAromaService();
        continueBut.click();
    }

    public void chooseServiceAsFirstVisitor(ServicesData servicesData) throws InterruptedException {
        getFirstVisitorBut().click();
        for (int i = 0; i < getListIntroTitles().size(); i++) {
            if (getListIntroTitles().get(i).getText().contains(servicesData.getServiceName().toUpperCase())) {
                getListIntroServiceBut().get(i).click();
                return;
            }
        }
        getListIntroServiceBut().get(0).click();
    }
}
