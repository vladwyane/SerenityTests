package pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;


/**
 * Created by bigdrop on 10/1/2018.
 */
public class BasePage extends PageObject {

    protected SoftAssert softAssert = new SoftAssert();

    @WhenPageOpens
    public void maximiseScreen() {
        getDriver().manage().window().maximize();
    }

    @FindBy(xpath = "//a[@href='/sign-up']")
    private WebElement headerSignUpLink;

    @FindBy(xpath = "//a[@href='/account']")
    private WebElement headerSignInLink;

    @FindBys( {@FindBy(css = ".main-nav li")} )
    public List<WebElement> listMainNav;

    @FindBy(xpath = "//div[@class='your-location']//a[contains(text(), 'Change Location')]")
    private WebElement changeLocationLink;


    public void clickHeaderSignUpLink() {
        headerSignUpLink.click();
    }

    public WebElement getHeaderSignUpLink() {
        return headerSignUpLink;
    }

    public void clickHeaderSignInLink() {
        headerSignInLink.click();
    }

    public List<WebElement> getListMainNav() {
        return listMainNav;
    }

    public void clickHeaderMenuItem(String itemName) {
        List<WebElement> list = listMainNav;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getText().equals(itemName.toUpperCase())) {
                list.get(i).click();
                return;
            }
        }
        list.get(list.size() - 1).click();
    }

    public void clickChangeLocationHeaderLink() {
        changeLocationLink.click();
    }

    protected void waiting2seconds() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected boolean scrollToElement(WebElement element) throws InterruptedException {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isElementContainsAttributeValue(WebElement element, String attribute, String attributeValue) {
        if (element.getAttribute(attribute).contains(attributeValue) == true)
            return true;
        else return false;
    }

}
