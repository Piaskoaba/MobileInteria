import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    public LoginPage(AndroidDriver driver){
        super(driver);
    }
    Wait wait = new WebDriverWait(driver,10);


    @FindBy (id = "pl.interia.poczta_next:id/input")
    MobileElement loginWindow;

    public void fillLoginWindow(String login){
    wait.until(ExpectedConditions.visibilityOf(loginWindow));
    loginWindow.clear();
    loginWindow.sendKeys(login);
    }

}
