package com.appsenseca.util;

import com.appsenseca.pageobjects.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

/**
 * Created by joserran on 10/5/2015.
 */
public class WebUtil
{
    final static int WAIT_TIME_OUT = 30;
    public static SignInPage goToSignInPage(WebDriver driver)
    {
        driver.get("http://gmail.com");
        return PageFactory.initElements(driver, SignInPage.class);
    }

    public static void click(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public static void waitForElementVisible(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_OUT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static boolean isElementExist(WebDriver driver, By by) {
        return driver.findElements(by).size() > 0;
    }

    public static void clearAndSendKeys(WebDriver driver, By by, String s) {
        WebElement webElement = driver.findElement(by);
        webElement.clear();
        webElement.sendKeys(s);
    }

    public static String getElementText(WebDriver driver, By by) {
        WebElement webElement = driver.findElement(by);
        System.out.println(webElement.getText());
        return webElement.getText();
    }
}
