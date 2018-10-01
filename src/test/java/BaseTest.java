import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by bigdrop on 10/1/2018.
 */
@RunWith(SerenityRunner.class)
public class BaseTest {

    @Managed(driver = "chrome")
    WebDriver driver;
}
