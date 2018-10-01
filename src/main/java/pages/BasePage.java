package pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.WhenPageOpens;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * Created by bigdrop on 10/1/2018.
 */
public class BasePage extends PageObject {

    @WhenPageOpens
    public void maximiseScreen() {
        getDriver().manage().window().maximize();
    }

}
