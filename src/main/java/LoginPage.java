import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.tools.ant.Main;
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
    @FindBy(xpath ="//*[contains(@text,'Hasło')]")
    MobileElement passwordWindow;
    @FindBy(id="pl.interia.poczta_next:id/logIn")
    MobileElement loginButton;
    public void fillLoginWindow(String login){
    wait.until(ExpectedConditions.visibilityOf(loginWindow));
    loginWindow.clear();
    loginWindow.sendKeys(login);
    }
    public void fillPasswordWindow(String login){
        wait.until(ExpectedConditions.visibilityOf(passwordWindow));
        passwordWindow.clear();
        passwordWindow.sendKeys(login);
    }
    public void clickLoginButton(){
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();

    }
    @FindBy(id="pl.interia.poczta_next:id/acceptButton")
    MobileElement cookieButton;
    public MainPage goToApp() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
        cookieButton.click();
        return new MainPage(driver);
    }

}
