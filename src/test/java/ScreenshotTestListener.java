import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ScreenshotTestListener implements ITestListener {

    public void onTestFailure(ITestResult result) {
        File file = TestClass.driver.getScreenshotAs(OutputType.FILE);
        String uuid = UUID.randomUUID().toString();
        try {
            FileUtils.copyFile(file, new File("src/test/resources/" + uuid + "screenshoot.png"));
        } catch (IOException e) {
            System.out.println("Screenshoot nie został zapisany");
        }
        System.out.println("====>WYKONAŁEM ZRZUT EKRANU<=======");
        System.out.println("Plik zapisany pod nazwą: " + uuid + "screenshoot.png");
    }
}
