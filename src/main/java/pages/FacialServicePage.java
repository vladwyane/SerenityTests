package pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static data.URL_values.*;

/**
 * Created by bigdrop on 10/4/2018.
 */

@DefaultUrl(FACIAL_SERVICE_URL)
public class FacialServicePage extends BasePage {

    @FindBy(xpath = "//a[@aria-describedby = 'class-facial']")
    private WebElement bookFacialBut;

    public void clickFacialService() {
        waiting2seconds();
        clickHeaderMenuItem("Facials");
        bookFacialBut.click();
    }
}
