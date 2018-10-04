package pages.account;

import data.Users;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;

import java.util.List;

import static data.URL_values.*;

/**
 * Created by bigdrop on 10/3/2018.
 */
@DefaultUrl(ACCOUNT_INFO_URL)
public class InformationPage extends BasePage {

    @FindBy(id = "password-form-password")
    private WebElement currentPassField;

    @FindBy(id = "password-form-new-password")
    private WebElement newPassField;

    @FindBy(id = "password-form-confirm-password")
    private WebElement confirmPassField;

    @FindBy(xpath = "//input[@value='Change Password']")
    private WebElement changePassBut;

    @FindBy(id = "contact-information-first-name")
    private WebElement userFirstName;

    @FindBy(id = "contact-information-last-name")
    private WebElement userLastName;

    @FindBy(id = "contact-information-email")
    private WebElement userEmail;

    @FindBy(id = "contact-information-phone")
    private WebElement userPhone;

    @FindBy(id = "contact-information-address")
    private WebElement userAddress;

    @FindBy(id = "contact-information-city")
    private WebElement userCity;

    @FindBy(id = "contact-information-zip")
    private WebElement userZipCode;

    @FindBy(xpath = "//select[@id='contact-information-state']//following-sibling::span")
    private WebElement stateSelect;

    @FindBys( {@FindBy(css = ".jcf-select-drop li")} )
    public List<WebElement> listState;

    @FindBy(xpath = "//input[@value='Save Changes']")
    private WebElement saveChangesBut;

    @FindBy(id = "modal-header-id")
    private WebElement titleInfoPopup;

    public WebElement getCurrentPassField() {
        return currentPassField;
    }

    public WebElement getNewPassField() {
        return newPassField;
    }

    public WebElement getConfirmPassField() {
        return confirmPassField;
    }

    public WebElement getChangePassBut() {
        return changePassBut;
    }

    public WebElement getUserFirstName() {
        return userFirstName;
    }

    public WebElement getUserLastName() {
        return userLastName;
    }

    public WebElement getUserEmail() {
        return userEmail;
    }

    public WebElement getUserPhone() {
        return userPhone;
    }

    public WebElement getUserAddress() {
        return userAddress;
    }

    public WebElement getUserCity() {
        return userCity;
    }

    public WebElement getUserZipCode() {
        return userZipCode;
    }

    public WebElement getStateSelect() {
        return stateSelect;
    }

    public List<WebElement> getListState() {
        return listState;
    }

    public WebElement getSaveChangesBut() {
        return saveChangesBut;
    }

    public void checkAccountContactInfo(Users users) {
        element(getUserFirstName()).waitUntilVisible();
        softAssert.assertEquals(getUserFirstName().getAttribute("value"), (users.getFirstName()));
        softAssert.assertEquals(getUserLastName().getAttribute("value"), (users.getLastName()));
        softAssert.assertEquals(getUserEmail().getAttribute("value"), (users.getEmail()));
        softAssert.assertEquals(getUserPhone().getAttribute("value"), splitPhoneNumToNewFormat(users));
        softAssert.assertAll();
    }

    public String splitPhoneNumToNewFormat(Users users) {
        String phoneNum = users.getPhone();
        char[] strToArray = phoneNum.toCharArray();
        String newPhoneNum = "";
        for (int i = 0; i < strToArray.length; i++) {
            if (i == 2)
                newPhoneNum += Character.toString(strToArray[i]) + "-";
            else if(i == 5)
                newPhoneNum += Character.toString(strToArray[i]) + "-";
            else newPhoneNum += Character.toString(strToArray[i]);
        }
        return newPhoneNum;
    }

    public InformationPage updateContactInfo(Users users) {
        typeInto(getUserFirstName(), users.getFirstName());
        typeInto(getUserLastName(), users.getLastName());
        typeInto(getUserAddress(), users.getAddress());
        typeInto(getUserCity(), users.getCity());
        typeInto(getUserZipCode(), users.getZipCode());
        chooseState(users.getState());
        getSaveChangesBut().click();
        return this;
    }

    public void chooseState(String stateName) throws StaleElementReferenceException {
        getStateSelect().click();
        try {
            for(WebElement element : listState) {
                if(element.getText().equals(stateName) || element.getText().equals(listState.get(listState.size() - 1).getText())) {
                    element.click();
                    return;
                }
            }
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){}
    }

    public void checkingSuccessPopup() {
        element(titleInfoPopup).waitUntilVisible();
        softAssert.assertEquals(titleInfoPopup.getText(), "Success!");
        softAssert.assertAll();
    }

    public InformationPage changePassword(Users users) {
        typeInto(getCurrentPassField(), users.getPassword());
        typeInto(getNewPassField(), users.getNewPassword());
        typeInto(getConfirmPassField(), users.getConfPassword());
        getChangePassBut().click();
        return this;
    }
}
