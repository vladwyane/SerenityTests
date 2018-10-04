package steps;

import net.thucydides.core.annotations.Step;
import pages.HomePage;

/**
 * Created by bigdrop on 10/3/2018.
 */
public class HomeSteps {

    HomePage homePage;

    @Step
    public void openHomePage() {
        homePage.open();
        homePage.maximiseScreen();
    }

}
