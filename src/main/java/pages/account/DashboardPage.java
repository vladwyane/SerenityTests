package pages.account;

import data.DateTime;
import data.LocationsData;
import data.ServicesData;
import data.Users;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;

import java.util.List;

import static data.URL_values.*;

/**
 * Created by bigdrop on 10/3/2018.
 */
@DefaultUrl(ACCOUNT_DASHBOARD_URL)
public class DashboardPage extends BasePage{

    @FindBys( {@FindBy(css = "table th")} )
    private List<WebElement> listHeadingOfAppTable;

    @FindBys( {@FindBy(css = "table td")} )
    private List<WebElement> listCellOfAppTable;

    @FindBy(xpath = "//div[@class='info']//a[contains(@href, 'mailto')]")
    private WebElement userEmail;

    @FindBy(xpath = "//div[@class='info']//a[contains(text(), 'Change Password')]")
    private WebElement changePassLink;

    @FindBy(xpath = "//div[@class='info']//a[contains(@href, 'tel')]")
    private WebElement phoneUser;

    @FindBy(xpath = "//a[contains(text(), 'Edit')]")
    private WebElement editButt;

    @FindBy(xpath = "//h2[contains(text(), 'Membership Status')]/following-sibling::div//p")
    private WebElement userStatus;

    @FindBy(css = ".name-id span")
    private WebElement userName;

    @FindBy(xpath = "//a[contains(@class, 'btn-')]")
    private WebElement BookingBut;

    @FindBy(css = ".points strong")
    private WebElement accountPoints;

    @FindBy(xpath = "//div[@class='dashboard-menu']//a[@href='/account']")
    private WebElement dashboardLink;

    @FindBy(xpath = "//div[@class='dashboard-menu']//a[@href='/account/information']")
    private WebElement accInformationLink;

    @FindBy(xpath = "//div[@class='dashboard-menu']//a[@href='/account/appointments']")
    private WebElement myAppointmentsLink;

    @FindBy(className = "logout")
    private WebElement logoutLink;

    public boolean getCellFromAppTable(String headingColumn, String sentence, int wordNumber) {
        int indexColumn = 0;
        for (int i = 0; i < listHeadingOfAppTable.size(); i++) {
            if(listHeadingOfAppTable.get(i).getText().equals(headingColumn)){
                indexColumn = i;
                break;
            }
        }
        for (int i = indexColumn; i < listCellOfAppTable.size(); i += listHeadingOfAppTable.size()) {
            if(listCellOfAppTable.get(i).getText().contains(returnWordInSentence(sentence, wordNumber)))
                return true;
        }
        return false;
    }

    public String returnWordInSentence(String sentence, int wordNumber) {
        if(wordNumber == 0)
            return sentence;
        String arr[] = sentence.split(" ", 10);
        String Word = arr[wordNumber - 1];
        return Word;
    }

    public WebElement getUserEmail() {
        return userEmail;
    }

    public WebElement getChangePassLink() {
        return changePassLink;
    }

    public WebElement getPhoneUser() {
        return phoneUser;
    }

    public WebElement getEditButt() {
        return editButt;
    }

    public WebElement getUserStatus() {
        return userStatus;
    }

    public WebElement getUserName() {
        return userName;
    }

    public WebElement getBookingBut() {
        return BookingBut;
    }

    public WebElement getAccountPoints() {
        return accountPoints;
    }

    public void clickAccInfoLink() {
        accInformationLink.click();
    }

    public void clickLogoutLink() {
        logoutLink.click();
    }

    public void checkingAccountDashboard(Users users) {
        softAssert.assertEquals(getPhoneUser().getText(), splitPhoneNumToNewFormat(users));
        softAssert.assertEquals(getUserEmail().getText(), users.getEmail());
        softAssert.assertEquals(getChangePassLink().getAttribute("href"), ACCOUNT_INFO_URL);
        softAssert.assertEquals(getUserStatus().getText(), "Non-member");
        softAssert.assertEquals(getUserName().getText(), users.getFirstName().toUpperCase());
        softAssert.assertEquals(getAccountPoints().getText(), "0");
        softAssert.assertEquals(dashboardLink.getAttribute("href"), ACCOUNT_DASHBOARD_URL);
        softAssert.assertEquals(accInformationLink.getAttribute("href"), ACCOUNT_INFO_URL);
        softAssert.assertEquals(myAppointmentsLink.getAttribute("href"), ACCOUNT_APPOINTMENTS_URL);
        softAssert.assertEquals(logoutLink.getText(), "Logout");
        softAssert.assertAll();
    }

    public String splitPhoneNumToNewFormat(Users users) {
        String phoneNum = users.getPhone();
        char[] strToArray = phoneNum.toCharArray();
        String newPhoneNum = "";
        for (int i = 0; i < strToArray.length; i++) {
            if(i == 0)
                newPhoneNum += "(" + Character.toString(strToArray[i]);
            else if (i == 2)
                newPhoneNum += Character.toString(strToArray[i]) + ") ";
            else if(i == 5)
                newPhoneNum += Character.toString(strToArray[i]) + "-";
            else newPhoneNum += Character.toString(strToArray[i]);
        }
        return newPhoneNum;
    }

    public void logOut() {
        open();
        if (element(getUserStatus()).isPresent()) {
            clickLogoutLink();
        }
    }

    public void checkingAppointments(DateTime dateTime, String therapist, ServicesData servicesData, LocationsData locationsData) {
        softAssert.assertTrue(getCellFromAppTable("Date", dateTime.getDate(), 2), "Date not found");
        softAssert.assertTrue(getCellFromAppTable("Therapist", therapist,1), "Therapist not found");
        softAssert.assertTrue(getCellFromAppTable("Procedure", servicesData.getServiceName(),0), "Procedure not found");
        softAssert.assertTrue(getCellFromAppTable("Location", locationsData.getShortLocationName(), 0), "Location not found");
        softAssert.assertAll();
    }
}
