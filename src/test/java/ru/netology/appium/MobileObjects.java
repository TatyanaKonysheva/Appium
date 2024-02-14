package ru.netology.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MobileObjects {
    //    @AndroidFindBy(id="ru.netology.testing.uiautomator:id/textToBeChanged")
//    WebElement startTitle;
//
//    @AndroidFindBy(id="ru.netology.testing.uiautomator:id/userInput")
//    WebElement inputString;
//
//    @AndroidFindBy(id="ru.netology.testing.uiautomator:id/buttonChange")
//    WebElement buttonChange;
//
//    @AndroidFindBy(id="ru.netology.testing.uiautomator:id/textToBeChanged")
//    WebElement textToBeChanged;
    WebElement startTitle;
    WebElement inputString;
    WebElement buttonChange;
    WebElement textToBeChanged;
    WebElement buttonActivity;
    WebElement text;
    private AppiumDriver driver;

    MobileObjects(AppiumDriver driver) {
        this.driver = driver;
        startTitle = driver.findElement(By.id("ru.netology.testing.uiautomator:id/textToBeChanged"));
        inputString = driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
        buttonChange = driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonChange"));
        textToBeChanged = driver.findElement(By.id("ru.netology.testing.uiautomator:id/textToBeChanged"));
        buttonActivity = driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonActivity"));
        //text = driver.findElement(By.id("ru.netology.testing.uiautomator:id/text"));
        //PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
}
