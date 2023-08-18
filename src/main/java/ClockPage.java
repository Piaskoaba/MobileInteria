import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ClockPage extends BasePage {
    public ClockPage(AndroidDriver driver) {
        super(driver);
    }

    TouchAction touchAction = new TouchAction(driver);

    @FindBy(xpath = "//android.widget.TextView[@content-desc='Views']")
    WebElement viewsOption;
    @FindBy(xpath = "//android.widget.TextView[@content-desc='Date Widgets']")
    WebElement dateWidgetsOption;
    @FindBy(xpath = "//android.widget.TextView[@content-desc='2. Inline']")
    WebElement inlineOption;
    @FindBy(id = "android:id/minutes")
    WebElement pickMinOnClock;
    @FindBy(xpath = "//*[content-desc=)")
    WebElement indicator;

    public void clickViewsOption() {
        webDriverWait.until(ExpectedConditions.visibilityOf(viewsOption));
        viewsOption.click();
    }

    public void clickDateWidgetOption() {
        webDriverWait.until(ExpectedConditions.visibilityOf(dateWidgetsOption));
        dateWidgetsOption.click();
    }

    public void clickInlineOption() {
        webDriverWait.until(ExpectedConditions.visibilityOf(inlineOption));
        inlineOption.click();
    }

    public void openClock() {
        clickViewsOption();
        clickDateWidgetOption();
        clickInlineOption();
    }

    public void pickMinIndicator() {
        pickMinOnClock.click();
    }

//    public void setHourWithDrag() {
//        WebElement startPoint = driver.findElementByXPath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"15\"]");
//        WebElement finishPoint = driver.findElementByXPath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"30\"]");
//
//        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(startPoint)).withDuration(Duration.ofSeconds(3)))
//                .moveTo(PointOption.point(finishPoint.getLocation().x + finishPoint.getSize().width / 2, finishPoint.getLocation().y + finishPoint.getSize().height / 2))
//                .release()
//                .perform();
//    }

    public void setMinutesOnClockFace(int beginPoint, int targetPoint) {
        WebElement startPoint = driver.findElementByXPath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=" + "'" + beginPoint + "']");
        WebElement finishPoint = driver.findElementByXPath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=" + "'" + targetPoint + "']");
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(startPoint)).withDuration(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(finishPoint.getLocation().x + finishPoint.getSize().width / 2, finishPoint.getLocation().y + finishPoint.getSize().height / 2))
                .release()
                .perform();
    }
}

