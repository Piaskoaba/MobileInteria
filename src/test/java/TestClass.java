import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.tools.ant.taskdefs.Touch;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestClass {
    protected static AndroidDriver driver;
    PageService pageService;
    MainPage mainPage;
    ContactPage contactPage;

    @BeforeMethod
    public void runMessage() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emu");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability("appPackage", "pl.interia.poczta_next");
        cap.setCapability("appActivity", "pl.interia.poczta.activity.NextLauncherActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void openApp() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        PageService pageService = new PageService(driver);
        Thread.sleep(1000);
        String myLogin = pageService.getCredentialValue("login");
        String myPassword = pageService.getCredentialValue("eMailPassword");
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow(myPassword);
        loginPage.clickLoginButton();
        Thread.sleep(5000);
        pageService.swipeUp(300);
        Thread.sleep(3000);
        mainPage = loginPage.goToApp();
        mainPage.clickCloseMic();
    }
    @Test
    public void AddContactInApp() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        PageService pageService = new PageService(driver);
        Thread.sleep(1000);
        String myLogin = pageService.getCredentialValue("login");
        String myPassword = pageService.getCredentialValue("eMailPassword");
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow(myPassword);
        loginPage.clickLoginButton();
        Thread.sleep(3000);
        pageService.swipeUp(300);
        mainPage = loginPage.goToApp();
        mainPage.clickCloseMic();
        mainPage.clickOpenLeftMenu();
        Thread.sleep(2000);
        contactPage = mainPage.clickContact();
        contactPage.clickAddContact();
        String name = pageService.getRandomValue(pageService.namesList());
        String sureName = pageService.getRandomValue(pageService.sureNamesList());
        String email = pageService.createEmailAddress(name, sureName, pageService.randomNumber(), pageService.randomValueFromDomainList());
        contactPage.fillContactNameWindow(name + " " + sureName);
        contactPage.fillEmailContactNameWindow(email);
        contactPage.clickSaveButton();
    }
}