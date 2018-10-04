package pages;

import data.Users;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static data.URL_values.*;

@DefaultUrl(SIGN_UP_URL)
public class CreateAccountPage extends BasePage {

    @FindBy(id = "registration-block-first-name")
    private WebElement firstNameField;

    @FindBy(id = "registration-block-last-name")
    private WebElement lastNameField;

    @FindBy(id = "registration-block-password")
    private WebElement passwordField;

    @FindBy(id = "registration-block-password-confirmation")
    private WebElement confPasswordField;

    @FindBy(id = "registration-block-email")
    private WebElement emailField;

    @FindBy(id = "registration-block-phone")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@value='Create an Account']")
    private WebElement createAccBut;

    @FindBy(xpath = "//input[@id='registration-block-first-name']/following-sibling::div[@class='note']")
    private WebElement firstNameFieldNote;

    @FindBy(xpath = "//input[@id='registration-block-last-name']/following-sibling::div[@class='note']")
    private WebElement lastNameFieldNote;

    @FindBy(xpath = "//input[@id='registration-block-password']/following-sibling::div[@class='note']")
    private WebElement passwordFieldNote;

    @FindBy(xpath = "//input[@id='registration-block-password-confirmation']/following-sibling::div[@class='note']")
    private WebElement confPasswordFieldNote;

    @FindBy(xpath = "//input[@id='registration-block-phone']/following-sibling::div[@class='note']")
    private WebElement phoneFieldNote;

    @FindBy(xpath = "//input[@id='registration-block-email']/following-sibling::div[@class='note']")
    private WebElement emailFieldNote;

    @FindBy(xpath = "//input[@id='registration-block-location']//ancestor::div[1]")
    private WebElement locationField;

    public CreateAccountPage typeFirstName (String firstName) {
        typeInto(firstNameField, firstName);
        return this;
    }

    public CreateAccountPage typeLastName (String lastName) {
        typeInto(lastNameField, lastName);
        return this;
    }

    public CreateAccountPage typePassword(String password) {
        typeInto(passwordField, password);
        return this;
    }

    public CreateAccountPage typeConfirmPassword(String confPassword) {
        typeInto(confPasswordField, confPassword);
        return this;
    }

    public CreateAccountPage typeEmail(String email) {
        typeInto(emailField, email);
        return this;
    }

    public CreateAccountPage typePhone(String phone) {
        typeInto(phoneField, phone);
        return this;
    }

    public CreateAccountPage clickCreateAccButt() {
        clickOn(createAccBut);
        return this;
    }

    public String firstNameNoteText() {
        return firstNameFieldNote.getText();
    }

    public WebElement getFirstNameFieldNote() {
        return firstNameFieldNote;
    }

    public WebElement getLastNameFieldNote() {
        return lastNameFieldNote;
    }

    public WebElement getPasswordFieldNote() {
        return passwordFieldNote;
    }

    public WebElement getConfPasswordFieldNote() {
        return confPasswordFieldNote;
    }

    public WebElement getPhoneFieldNote() {
        return phoneFieldNote;
    }

    public WebElement getEmailFieldNote() {
        return emailFieldNote;
    }

    public CreateAccountPage clickLocationField() {
        clickOn(locationField);
        return this;
    }

    public CreateAccountPage checkingErrorNotesAllFieldsAreBlank() {
        String errorNoteFieldsBlank = "This field can't be blank";
        String errorColor = "rgba(235, 0, 0, 1)";

        softAssert.assertEquals(getFirstNameFieldNote().getText(), errorNoteFieldsBlank);
        softAssert.assertEquals(getFirstNameFieldNote().getCssValue("color"), errorColor);

        softAssert.assertEquals(getLastNameFieldNote().getText(), errorNoteFieldsBlank);
        softAssert.assertEquals(getLastNameFieldNote().getCssValue("color"), errorColor);

        softAssert.assertEquals(getPasswordFieldNote().getText(), errorNoteFieldsBlank);
        softAssert.assertEquals(getPasswordFieldNote().getCssValue("color"), errorColor);

        softAssert.assertEquals(getEmailFieldNote().getText(), errorNoteFieldsBlank);
        softAssert.assertEquals(getEmailFieldNote().getCssValue("color"), errorColor);

        softAssert.assertEquals(getPasswordFieldNote().getText(), errorNoteFieldsBlank);
        softAssert.assertEquals(getPasswordFieldNote().getCssValue("color"), errorColor);

        softAssert.assertAll();
        return new CreateAccountPage();
    }

    public CreateAccountPage checkingErrorNoteNotMatchPassword() {
        String errorNoteNotMatchPassword = "This field doesn't match password";
        String errorColor = "rgba(235, 0, 0, 1)";
        softAssert.assertEquals(getConfPasswordFieldNote().getText(), errorNoteNotMatchPassword);
        softAssert.assertEquals(getConfPasswordFieldNote().getCssValue("color"), errorColor);
        softAssert.assertAll();
        return new CreateAccountPage();
    }

    public CreateAccountPage checkingErrorNoteExistEmail(String userEmail) {
        String errorNotExistEmail = "Email \"" + userEmail + "\" has already been taken.";
        String errorColor = "rgba(235, 0, 0, 1)";
        softAssert.assertEquals(getEmailFieldNote().getText(), errorNotExistEmail);
        softAssert.assertEquals(getEmailFieldNote().getCssValue("color"), errorColor);
        softAssert.assertAll();
        return new CreateAccountPage();
    }
}
