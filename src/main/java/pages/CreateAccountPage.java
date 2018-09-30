package pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://hs.bigdropinc.net/sign-up")
public class CreateAccountPage extends PageObject {

    @FindBy(id = "registration-block-first-name")
    private WebElement firstNameField;

    public void ddd() {

    }
}
