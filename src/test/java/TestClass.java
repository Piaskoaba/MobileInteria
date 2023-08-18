import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Listeners({ScreenshotTestListener.class})
public class TestClass {
    protected static AndroidDriver driver;
    PageService pageService;
    MainPage mainPage;
    ContactPage contactPage;
    NewMessagePage newMessagePage;

    @BeforeMethod
    public void run() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emu");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability("appPackage", "pl.interia.poczta_next");
        cap.setCapability("appActivity", "pl.interia.poczta.activity.NextLauncherActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void openAppAndSwipe() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        //MainPage mainPage = new MainPage(driver);
        PageService pageService = new PageService(driver);
        String myLogin = pageService.getCredentialValue("login");
        String myPassword = pageService.getCredentialValue("eMailPassword");
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow(myPassword);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isGoToAppButtonVisible(), "Przycisk 'GoToApp' nie jest widoczny");
        pageService.swipeUp(5);
        mainPage = loginPage.clickRemindMeLaterNutton();
        Assert.assertTrue(mainPage.isNewMessageButtonVisible(), "Przycisk nowej wiadomości nie jest widoczny");
        mainPage.clickCloseMic();
        pageService.swipeUp(7);
        pageService.swipeDown(3);
    }

    @Test
    public void AddContactInApp() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        PageService pageService = new PageService(driver);
        String myLogin = pageService.getCredentialValue("login");
        String myPassword = pageService.getCredentialValue("eMailPassword");
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow(myPassword);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isGoToAppButtonVisible(), "Przycisk 'GoToApp' nie jest widoczny");
        pageService.swipeUp(5);
        mainPage = loginPage.clickRemindMeLaterNutton();
        Assert.assertTrue(mainPage.isNewMessageButtonVisible(), "Przycisk nowej wiadomości nie jest widoczny");
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
        pageService.screenShoot();
    }

    @Test
    public void testFailedScreenshootTest() { //testListener
        LoginPage loginPage = new LoginPage(driver);
        PageService pageService = new PageService(driver);
        String myLogin = pageService.getCredentialValue("login");
        String myPassword = pageService.getCredentialValue("eMailPassword");
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow(myPassword);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isGoToAppButtonVisible(), "Przycisk 'GoToApp' nie jest widoczny");
        String text = contactPage.contactNameWindow.getText(); //Linia kodu, która przerwie test, wykona się screenshoot momentu, w którym wystąpił błąd
    }

    @Test
    public void sendMessage() throws InterruptedException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        PageService pageService = new PageService(driver);
        String myLogin = pageService.getCredentialValue("login");
        String myPassword = pageService.getCredentialValue("eMailPassword");
        loginPage.fillLoginWindow(myLogin);
        loginPage.fillPasswordWindow(myPassword);
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isGoToAppButtonVisible(), "Przycisk 'GoToApp' nie jest widoczny");
        pageService.swipeUp(5);
        mainPage = loginPage.clickRemindMeLaterNutton();
        Assert.assertTrue(mainPage.isNewMessageButtonVisible(), "Przycisk nowej wiadomości nie jest widoczny");
        mainPage.clickCloseMic();
        newMessagePage = mainPage.clickNewMessageButton();
        String name = pageService.getRandomValue(pageService.namesList());
        String sureName = pageService.getRandomValue(pageService.sureNamesList());
        String email = pageService.createEmailAddress(name, sureName, pageService.randomNumber(), pageService.randomValueFromDomainList());
        String recipient = name + sureName + email;
        System.out.println(recipient);
        newMessagePage.fillRecipientWindow(recipient);
        String subject = "Hello!";
        newMessagePage.fillSubjectWindow(subject);
        newMessagePage.clickSendMessageButton();
        pageService.screenShoot();
    }

}