package steps;

import net.thucydides.core.annotations.Step;
import pages.FacialServicePage;

/**
 * Created by bigdrop on 10/4/2018.
 */
public class FacialServiceSteps {

    FacialServicePage facialServicePage;

    @Step
    public void clickFacialService() {
        facialServicePage.clickFacialService();
    }
}
