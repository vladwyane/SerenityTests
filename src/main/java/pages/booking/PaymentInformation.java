package pages.booking;

import data.CreditCards;
import data.Users;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.BasePage;

import java.util.List;

/**
 * Created by bigdrop on 10/4/2018.
 */
public class PaymentInformation extends BasePage {

    @FindBy(id = "form-create-account-password")
    private WebElement passwordField;

    @FindBy(id = "form-create-account-password-again")
    private WebElement confirmPassField;

    @FindBy(id = "form-payment-card-name")
    private WebElement cardNameField;

    @FindBy(id = "form-payment-card-number")
    private WebElement cardNumberField;

    @FindBy(id = "form-payment-cvv")
    private WebElement cardCVVField;

    @FindBy(id = "form-payment-zip")
    private WebElement zipCodeField;

    @FindBy(xpath = "//select[@data-stripe='exp_month']//following-sibling::span")
    private WebElement monthSelect;

    @FindBy(xpath = "//select[@data-stripe='exp_year']//following-sibling::span")
    private WebElement yearsSelect;

    @FindBys( {@FindBy(xpath = "//div[contains(@class, 'jcf-select-month')]//li")} )
    public List<WebElement> listMonths;

    @FindBys( {@FindBy(xpath = "//div[contains(@class, 'jcf-select-drop')]//li")} )
    public List<WebElement> listYears;

    @FindBy(id = "contact-information-fist-name")
    private WebElement userFirstName;

    @FindBy(id = "contact-information-last-name")
    private WebElement userLastName;

    @FindBy(id = "contact-information-email")
    private WebElement userEmail;

    @FindBy(id = "contact-information-phone")
    private WebElement userPhone;

    @FindBy(xpath = "//label[contains(text(), 'I agree to the')]")
    private WebElement privatePolicyCheckBox;

    @FindBy(xpath = "//label[@for='form-create-account-cancellation-policy']")
    private WebElement cancellationPolicyCheckBox;

    @FindBy(css= ".confirm-booking")
    private WebElement confirmBockingBut;

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getConfirmPassField() {
        return confirmPassField;
    }

    public WebElement getCardNameField() {
        return cardNameField;
    }

    public WebElement getCardNumberField() {
        return cardNumberField;
    }

    public WebElement getCardCVVField() {
        return cardCVVField;
    }

    public WebElement getZipCodeField() {
        return zipCodeField;
    }

    public void chooseMonth(String monthName) throws StaleElementReferenceException {
        monthSelect.click();
        try {
            for(WebElement element : listMonths) {
                if(element.getText().equals(monthName) || element.getText().equals(listMonths.get(listMonths.size() - 1).getText())) {
                    element.click();
                    return;
                }
            }
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){}
    }

    public void chooseYear(String yearName) throws StaleElementReferenceException {
        yearsSelect.click();
        try {
            for(WebElement element : listYears) {
                if(element.getText().equals(yearName) || element.getText().equals(listYears.get(listYears.size() - 1).getText())) {
                    element.click();
                    return;
                }
            }
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){}
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

    public WebElement getPrivatePolicyCheckBox() {
        return privatePolicyCheckBox;
    }

    public void fillPaymentInformation(Users users, CreditCards creditCards, boolean createAccount) {
        fillContactInformation(users);
        fillCreditCardInfo(users, creditCards);
        if(createAccount == true)
            fillPasswordField(users);
        cancellationPolicyCheckBox.click();
        confirmBockingBut.click();
    }

    public void fillPaymentInformationForMember() throws InterruptedException {
        scrollToElement(cancellationPolicyCheckBox);
        getPrivatePolicyCheckBox().click();
        cancellationPolicyCheckBox.click();
        confirmBockingBut.click();
    }

    public PaymentInformation fillContactInformation(Users users) {
        typeInto(getUserFirstName(), users.getFirstName());
        typeInto(getUserLastName(), users.getLastName());
        typeInto(getUserEmail(), users.getEmail());
        typeInto(getUserPhone(), users.getPhone());
        getPrivatePolicyCheckBox().click();
        return this;
    }

    public PaymentInformation fillCreditCardInfo(Users users, CreditCards creditCards) {
        typeInto(getCardNameField(), creditCards.getCardName());
        typeInto(getCardNumberField(), creditCards.getCardNumber());
        typeInto(getCardCVVField(), creditCards.getCardCVV());
        typeInto(getZipCodeField(), users.getZipCode());
        chooseMonth(creditCards.getCardMonth());
        chooseYear(creditCards.getCardYear());
        return this;
    }

    public PaymentInformation fillPasswordField(Users users) {
        typeInto(getPasswordField(), users.getNewPassword());
        typeInto(getConfirmPassField(), users.getConfPassword());
        return this;
    }
}
