import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPage extends BasePage {
    public ContactPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[4]/android.view.View[2]/android.widget.Button")
    MobileElement addContactButton;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='name']")
    MobileElement contactNameWindow;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='email']")
    MobileElement emailWindow;
    @FindBy(xpath = "//android.widget.Button[contains(@text,'Zapisz')]")
    MobileElement saveButton;
    @FindBy(xpath = "//android.view.View[@resource-id='remindMeLater']")
    MobileElement remindMeLaterButton;

    public void clickAddContact() {
        webDriverWait.until(ExpectedConditions.visibilityOf(addContactButton));
        addContactButton.click();
    }

    public void fillContactNameWindow(String name) {
        webDriverWait.until(ExpectedConditions.visibilityOf(contactNameWindow));
        contactNameWindow.sendKeys(name);
    }

    public void fillEmailContactNameWindow(String email) {
        webDriverWait.until(ExpectedConditions.visibilityOf(emailWindow));
        emailWindow.sendKeys(email);
    }

    public void clickSaveButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
    }
}
