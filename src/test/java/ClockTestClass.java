import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ClockTestClass {

    protected static AndroidDriver driver;
    PageService pageService;

    @BeforeMethod
    public void runClock() throws MalformedURLException {
        File app = new File("src/test/resources/apps/ApiDemos.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emu");
//        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
//        cap.setCapability("appPackage", "com.google.android.deskclock");
//        cap.setCapability("appActivity", "com.android.deskclock.worldclock.GoogleCitySelectionActivity - Cities");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void setHourByDragAndDrop() {
        ClockPage clockPage = new ClockPage(driver);
        clockPage.openClock();
        clockPage.setMinutesOnClockFace(10,1);
        clockPage.pickMinIndicator();
        clockPage.setMinutesOnClockFace(15,30);
        PageService pageService = new PageService(driver);
        pageService.returnButton();



    }

}

