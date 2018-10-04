package popups;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import static data.URL_values.SIGN_IN_URL;

/**
 * Created by bigdrop on 10/2/2018.
 */
public class InfoPopup extends BasePage{

    @FindBy(id = "modal-header-id")
    private WebElement titleInfoPopup;

    public WebElement getTitleInfoPopup() {
        return titleInfoPopup;
    }

    public void checkingSuccessOfRegistration() {
        if(element(titleInfoPopup).isPresent()) {
            softAssert.assertEquals(titleInfoPopup.getText(), "Confirm email");
            softAssert.assertEquals(getDriver().getCurrentUrl(), SIGN_IN_URL);
        } else {
            softAssert.assertTrue(element(titleInfoPopup).isPresent(), "Success popup is not found");
            softAssert.assertEquals(getDriver().getCurrentUrl(), SIGN_IN_URL);
        }
        softAssert.assertAll();
    }

    public void checkingSuccessRessetPassword() {
        waiting2seconds();
        if(element(titleInfoPopup).isPresent()) {
            softAssert.assertEquals(titleInfoPopup.getText(), "Success!");
        } else {
            softAssert.assertTrue(element(titleInfoPopup).isPresent(), "Element is not found");
        }
        softAssert.assertAll();
    }

}
