package com.appsenseca.pageobjects;

import com.appsenseca.util.WebUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by joserran on 10/5/2015.
 */
public class SignInPage
{

    public void fillInUserName(WebDriver driver, String stringFileName) {
        WebUtil.clearAndSendKeys(driver, By.id("Email"), AccessProperties.getUserName("configuration.properties"));
    }

    public void clickNext(WebDriver driver) {
        WebElement nextBox = driver.findElement(By.id("next"));
        nextBox.click();
    }

    public void fillInPassword(WebDriver driver, String stringFileName) {
        WebUtil.waitForElementVisible(driver, By.id("Passwd"));
        WebUtil.clearAndSendKeys(driver, By.id("Passwd"), AccessProperties.getUserPassword("configuration.properties"));
    }

    public EmailHomePage clickSignIn(WebDriver driver) {
        WebUtil.click(driver, By.id("signIn"));
        WebUtil.waitForElementVisible(driver, By.partialLinkText("Inbox"));

        return PageFactory.initElements(driver, EmailHomePage.class);
    }

    public boolean isSignInButtonExist(WebDriver driver) {
        return WebUtil.isElementExist(driver, By.id("signIn"));
    }
}
