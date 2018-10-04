package pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static data.URL_values.*;

/**
 * Created by bigdrop on 10/2/2018.
 */
@DefaultUrl(MASSAGE_SERVICE_URL)
public class MassageServicePage extends BasePage {

    @FindBy(xpath = "//a[@aria-describedby = 'class-massage']")
    private WebElement bookMassageBut;

    public void clickMassageService() {
        waiting2seconds();
        clickHeaderMenuItem("Massage");
        bookMassageBut.click();
    }
}
