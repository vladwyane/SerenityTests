import data.Users;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WhenPageOpens;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import steps.CreateAccountSteps;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by bigdrop on 10/1/2018.
 */

public class WhenCreateAccount extends BaseTest {

    @Steps
    CreateAccountSteps steps;

    @Test
    public void testRegForm() {
        steps.openCreateAccPage();
        steps.fillRegistrationForm(Users.LEBRON);
        steps.clickCreateButt();
    }
}
