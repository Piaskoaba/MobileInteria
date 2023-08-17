import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.*;

public class PageService {

    AndroidDriver driver;
    //TouchAction touchAction = new TouchAction(driver);
    private static final int TIMEOUT = 10;
    protected WebDriverWait webDriverWait;

    public PageService(AndroidDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, TIMEOUT);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    Random random = new Random();

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

//    public void scrollDown(int startX, int startY, int endY) {
//        TouchAction touchAction = new TouchAction(driver);
//        Dimension size = driver.manage().window().getSize();
//        int screenHeight = driver.manage().window().getSize().getHeight();
//        int screenWidth = driver.manage().window().getSize().getWidth();
//
//         startX = size.width / 2;
//         startY = (int) (size.height * 0.8); // Start slightly above the bottom
//
//        int endX = startX;
//         endY = (int) (size.height * 0.2); // End slightly above the top
//
//        touchAction.press(PointOption.point(startX, startY))
//                .moveTo(PointOption.point(endX, endY))
//                .release()
//                .perform();
//    }
//    public void swipeVertical(double startPercentage, double anchorPercentage, double finalPercentage, int swipeDuration) {
//        TouchAction touchAction = new TouchAction(driver);
//        Dimension size = driver.manage().window().getSize();
//        int anchor = (int) (size.width * anchorPercentage);
//        int startPoint = (int) (size.height * startPercentage);
//        int endPoint = (int) (size.height * finalPercentage);
//        touchAction.press(PointOption.point(anchor, startPoint))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(swipeDuration)))
//                .moveTo(PointOption.point(anchor, endPoint))
//                .release()
//                .perform();
//    }

    public void swipeVertical(double startpercentage, double finalpercentage, double anchorPercentage) {
        swipeVertical(100, 300, 500);
    }

    public ArrayList<String> namesList() {
        ArrayList<String> nameList = new ArrayList<String>();
        nameList.add("Anna");
        nameList.add("Bogumiła");
        nameList.add("Maria");
        nameList.add("Bożena");
        nameList.add("Wiesława");
        nameList.add("Katarzyna");
        nameList.add("Bronisława");
        nameList.add("Eugenia");
        nameList.add("Aleksandra");
        nameList.add("Ramon");
        nameList.add("Weronika");
        nameList.add("Aleksa");
        nameList.add("Jessica");
        nameList.add("Sylwia");
        nameList.add("Beata");
        nameList.add("Agnieszka");
        nameList.add("Marcelina");
        nameList.add("Jadwinga");
        nameList.add("Grażyna");
        nameList.add("Halina");
        return nameList;
    }

    public ArrayList<String> sureNamesList() {
        ArrayList<String> sureNameList = new ArrayList<>();
        sureNameList.add("Antoniak");
        sureNameList.add("Bogucka");
        sureNameList.add("Kazimierczak");
        sureNameList.add("Kowalska");
        sureNameList.add("Andrzejewicz");
        sureNameList.add("Kulesza");
        sureNameList.add("Glapa");
        sureNameList.add("Woźniak");
        sureNameList.add("Balcerzak");
        sureNameList.add("Wierzbińska");
        sureNameList.add("Kulesza");
        sureNameList.add("Konopacka");
        sureNameList.add("Gralewska");
        sureNameList.add("Andrzejak");
        sureNameList.add("Gala");
        sureNameList.add("Bryl");
        sureNameList.add("Radecka");
        sureNameList.add("Krawiec");
        sureNameList.add("Matuszak");
        sureNameList.add("Złotnik");
        return sureNameList;
    }

    public String getRandomValue(ArrayList<String> list) {
        int randomIndex = random.nextInt(list.size());
        String randomValue = list.get(randomIndex);
        return randomValue;
    }

    public String replacePolishLetters(String nonPolishLetters) {
        return nonPolishLetters.replace
                        ("Ą", "A")
                .replace("ą", "a")
                .replace("Ć", "C")
                .replace("Ę", "E")
                .replace("ę", "e")
                .replace("Ł", "L")
                .replace("ł", "l")
                .replace("Ń", "N")
                .replace("ń", "n")
                .replace("Ś", "s")
                .replace("ś", "s")
                .replace("Ó", "O")
                .replace("ó", "o")
                .replace("Ż", "Z")
                .replace("ż", "z")
                .replace("Ź", "z")
                .replace("ź", "z");
    }

    public String createEmailAddress(String name, String sureName, int number, String mailDomen) {
        String email = name + sureName + number + mailDomen;
        return replacePolishLetters(email).toLowerCase();
    }

    public int randomNumber() {
        return random.nextInt(9999 - 1000 + 1) + 1000;
    }

    public String randomValueFromDomainList() {
        String randomLine = getRandomLineFromFile("domainList.txt");
        return randomLine;
    }

    private static String getRandomLineFromFile(String path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        Random random = new Random();
        return lines.get(random.nextInt(lines.size()));
    }

    public void returnButton() {
        WebElement preferenceOption = driver.findElementByAccessibilityId("Preference");
        preferenceOption.click();
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void scroll(String visibleText) {
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().description(\""
                        + visibleText + "\").instance(0))");
    }

    protected void swipeByPercentage(double startXpercentage, double startYpercentage, double endXpercentage, double endYpercentage) {
        Dimension size = driver.manage().window().getSize();
        int startPointX = (int) ((double) size.width * startXpercentage);
        int endPointX = (int) ((double) size.width * endXpercentage);
        int startPointY = (int) ((double) size.height * startYpercentage);
        int endPointY = (int) ((double) size.height * endYpercentage);
        (new TouchAction(driver).press(PointOption.point(startPointX, startPointY)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000L)))
                .moveTo(PointOption.point(endPointX, endPointY))
                .release()
                .perform();
    }

    protected void swipeHorizontal(double startXpercentage, double endXpercentage) {
        this.swipeByPercentage(startXpercentage, 0.5, endXpercentage, 0.5);
    }

    protected void swipeVertical(double startYpercentage, double endYpercentage) {
        this.swipeByPercentage(0.5, startYpercentage, 0.5, endYpercentage);
    }

    protected void swipeRight(double endXpercentage) {
        this.swipeByPercentage(0.2, 0.5, 0.2 + 0.8 * endXpercentage, 0.5);
    }

    protected void swipeLeft(double endXpercentage) {
        this.swipeByPercentage(0.8, 0.5, 0.8 - 0.8 * endXpercentage, 0.5);
    }

    protected void swipeDown(double endYpercentage) {
        this.swipeByPercentage(0.5, 0.2, 0.5, 0.2 + 0.8 * endYpercentage);
    }

    protected void swipeUp(double endYpercentage) {
        this.swipeByPercentage(0.5, 0.8, 0.5, 0.8 - 0.8 * endYpercentage);
    }

    public void screenShoot() throws IOException {
        File file = driver.getScreenshotAs(OutputType.FILE);
        String uuid = UUID.randomUUID().toString();
        FileUtils.copyFile(file, new File("src/test/resources/" + uuid + "screenshoot.png"));
        System.out.println("====>WYKONAŁEM ZRZUT EKRANU<=======");
        System.out.println("Plik zapisany pod nazwą: " + uuid + "screenshoot.png");
    }
}


