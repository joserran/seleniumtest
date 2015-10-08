package com.appsenseca.pageobjects;

import com.appsenseca.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by joserran on 10/7/2015.
 */
public class EmailHomePage {

    public static SignInPage signOut(WebDriver driver) {

        WebUtil.waitForElementVisible(driver, By.cssSelector("a[class='gb_b gb_Ra gb_R gb_Na']"));
        WebUtil.click(driver, By.cssSelector("a[class='gb_b gb_Ra gb_R gb_Na']"));
        WebUtil.waitForElementVisible(driver, By.id("gb_71"));
        WebUtil.click(driver, By.id("gb_71"));

        return PageFactory.initElements(driver, SignInPage.class);
    }

    public boolean isInboxExist(WebDriver driver)
    {
        return WebUtil.isElementExist(driver, By.partialLinkText("Inbox"));
    }

    public void clickCompose(WebDriver driver) {
        WebUtil.click(driver, By.cssSelector("div[role='button'][gh='cm']"));
        //WebElement composeButton = driver.findElement();
        //composeButton.click();
    }

    public void fillInRecipient(WebDriver driver, String recipientName) {
        WebUtil.waitForElementVisible(driver, By.cssSelector("textarea[name='to']"));

        WebUtil.clearAndSendKeys(driver, By.cssSelector("textarea[name='to']"), recipientName);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='gb_b gb_Qa gb_R gb_Ma']")));

    }

    public void fillInSubject(WebDriver driver, String subjectText) {
        WebUtil.clearAndSendKeys(driver, By.cssSelector("input[name='subjectbox']"), subjectText);
    }

    public void fillInEmailBody(WebDriver driver, String emailBodyText) {
        WebUtil.clearAndSendKeys(driver, By.cssSelector("div[role='textbox']"), emailBodyText);
    }

    public void clickSendEmail(WebDriver driver) {
        WebUtil.click(driver, By.cssSelector("div[aria-label*='Send']"));
    }

    public void clickInboxWithNewEmail(WebDriver driver) {
        WebUtil.waitForElementVisible(driver, By.partialLinkText("Inbox"));
        WebUtil.click(driver, By.partialLinkText("Inbox"));
    }

    public EmailViewPage clickNewEmail(WebDriver driver) {
        WebUtil.waitForElementVisible(driver, By.cssSelector("div[class='y6'] span[id] b"));
        WebUtil.click(driver, By.cssSelector("div[class='y6'] span[id] b"));

        return PageFactory.initElements(driver, EmailViewPage.class);
    }
}
