import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileReader;
import java.util.Properties;

public class PageService {

    AndroidDriver driver;
    private static final int TIMEOUT = 10;
    protected WebDriverWait webDriverWait;

    public PageService(AndroidDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, TIMEOUT);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getCredentialValue(String credentialName) {
        String credentialValue = null;
        try (FileReader reader = new FileReader("credentials")) {
            Properties properties = new Properties();
            properties.load(reader);
            credentialValue = properties.getProperty(credentialName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return credentialValue;
    }
}
