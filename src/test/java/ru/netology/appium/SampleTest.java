package ru.netology.appium;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

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
    public void newActivity() throws InterruptedException {
        WebElement el1 = (WebElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
        el1.click();
        el1.sendKeys(newString);
        WebElement el2 = (WebElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonActivity"));
        el2.click();
        Thread.sleep(2000);
        WebElement el3 = (WebElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/text"));
        el3.isDisplayed();
        Assertions.assertEquals(el3.getText(), newString);

        /*mobileObjects.inputString.isDisplayed();
        mobileObjects.inputString.sendKeys(newString);
        mobileObjects.buttonActivity.isDisplayed();
        mobileObjects.buttonActivity.click();
        mobileObjects.text.isDisplayed();
        String actual = mobileObjects.text.getText();
        Assertions.assertEquals(newString, actual);*/

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
