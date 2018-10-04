package steps;

import net.thucydides.core.annotations.Step;
import pages.LastDealsPage;

/**
 * Created by bigdrop on 10/4/2018.
 */
public class LastDealsSteps {

    LastDealsPage lastDealsPage;

    @Step
    public void checkingNothingFoundSection() throws InterruptedException {
        lastDealsPage.checkingNothingFoundSection();
    }

    @Step
    public void chooseFirstLMDServiceFromAvailable() throws InterruptedException {
        lastDealsPage.chooseFirstLMDServiceFromAvailable();
    }

    @Step
    public void clickSpaDealsItemFromMainNav() {
        lastDealsPage.clickSpaDealsItemFromMainNav();
    }
}
