package ru.netology.appium;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SampleTest {

    private AndroidDriver driver;
    private MobileObjects mobileObjects;

    String emptyString = " ";
    String newString = "New Activity";

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Some name");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", ".MainActivity");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        mobileObjects = new MobileObjects(driver);

    }


    @Test
    public void emptyString() {
        mobileObjects.startTitle.isDisplayed();
        String expected = mobileObjects.startTitle.getText();
        mobileObjects.inputString.isDisplayed();
        mobileObjects.inputString.sendKeys(emptyString);
        mobileObjects.buttonChange.isDisplayed();
        mobileObjects.buttonChange.click();
        mobileObjects.textToBeChanged.isDisplayed();
        String actual = mobileObjects.textToBeChanged.getText();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void newActivity() {
        mobileObjects.inputString.isDisplayed();
        mobileObjects.inputString.sendKeys(newString);
        mobileObjects.buttonActivity.isDisplayed();
        mobileObjects.buttonActivity.click();
        mobileObjects.text.isDisplayed();
        String actual = mobileObjects.text.getText();
        Assertions.assertEquals(newString, actual);

    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
