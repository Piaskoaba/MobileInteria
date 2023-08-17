import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {


    public MainPage(AndroidDriver driver) {
        super(driver);
    }

    Wait wait = new WebDriverWait(driver, 10);

    @FindBy(xpath = "//android.widget.Button[@index='1' and @package='pl.interia.poczta_next']")
    MobileElement closeMicWindow;
    @FindBy(xpath ="//android.widget.Button[@index='0' and @package='pl.interia.poczta_next']" )
    MobileElement openLeftMenuButton;
    @FindBy(xpath = "//*[contains(@text,'Kontakty')]")
    MobileElement contacts;


    public void clickCloseMic() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.visibilityOf(closeMicWindow));
        closeMicWindow.click();
        Thread.sleep(2000);
    }

    public void clickOpenLeftMenu() {
        webDriverWait.until(ExpectedConditions.visibilityOf(openLeftMenuButton));
        openLeftMenuButton.click();
    }

    public ContactPage clickContact() {
        webDriverWait.until(ExpectedConditions.visibilityOf(contacts));
        contacts.click();
        return new ContactPage(driver);
    }


}
