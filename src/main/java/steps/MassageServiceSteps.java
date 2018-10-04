package steps;

import net.thucydides.core.annotations.Step;
import pages.MassageServicePage;

/**
 * Created by bigdrop on 10/4/2018.
 */
public class MassageServiceSteps {

    MassageServicePage massageServicePage;

    @Step
    public void clickMassageService() {
        massageServicePage.clickMassageService();
    }
}
