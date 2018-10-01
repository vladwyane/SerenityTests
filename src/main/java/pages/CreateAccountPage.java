package pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://hs.bigdropinc.net/sign-up")
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

    public String lastNameNoteText() {
        return lastNameFieldNote.getText();
    }

    public String passwordNoteText() {
        return passwordFieldNote.getText();
    }

    public String congPasswordNoteText() {
        return confPasswordFieldNote.getText();
    }

    public String emailNoteText() {
        return emailFieldNote.getText();
    }

    public String phoneNoteText() {
        return passwordFieldNote.getText();
    }

    public CreateAccountPage clickLocationField() {
        clickOn(locationField);
        return this;
    }




}
