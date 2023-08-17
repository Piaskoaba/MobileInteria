import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewMessagePage extends BasePage{
    public NewMessagePage(AndroidDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//android.widget.EditText[@index='1' and @package='pl.interia.poczta_next']")
    MobileElement recipientWindow;
    @FindBy(xpath = "//android.widget.EditText[@resource-id='subject']")
    MobileElement subjectWindow;
    @FindBy(xpath = "//android.widget.Button[@index='3' and @package='pl.interia.poczta_next']")
    MobileElement sendMessageButton;
    public void fillRecipientWindow(String recipientMail){
        recipientWindow.clear();
        recipientWindow.sendKeys(recipientMail);
    }
    public void fillSubjectWindow(String subject){
        subjectWindow.clear();
        subjectWindow.sendKeys(subject);
    }
   public void clickSendMessageButton(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sendMessageButton));
        sendMessageButton.click();
   }
}
