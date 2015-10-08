package com.appsenseca.pageobjects;

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
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='gb_b gb_Qa gb_R gb_Ma']")));
        WebElement profileButton = driver.findElement(By.cssSelector("a[class='gb_b gb_Qa gb_R gb_Ma']"));
        profileButton.click();

        WebElement signOutButton = driver.findElement(By.id("gb_71"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gb_71")));
        signOutButton.click();
        return PageFactory.initElements(driver, SignInPage.class);
    }

    public boolean isElementExist(WebDriver driver) {
        return driver.findElements(By.partialLinkText("Inbox")).size() > 0;
    }

    public void clickCompose(WebDriver driver) {
        WebElement composeButton = driver.findElement(By.cssSelector("div[role='button'][gh='cm']"));
        composeButton.click();
    }

    public void fillInRecipient(WebDriver driver, String recipientName) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[name='to']")));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='gb_b gb_Qa gb_R gb_Ma']")));
        WebElement toInputTextArea = driver.findElement(By.cssSelector("textarea[name='to']"));
        toInputTextArea.clear();
        toInputTextArea.sendKeys(recipientName);
    }

    public void fillInSubject(WebDriver driver, String subjectText) {
        WebElement subjectInputBox = driver.findElement(By.cssSelector("input[name='subjectbox']"));
        subjectInputBox.clear();
        subjectInputBox.sendKeys(subjectText);
    }

    public void fillInEmailBody(WebDriver driver, String emailBodyText) {
        WebElement bodyTextArea = driver.findElement(By.cssSelector("div[role='textbox']"));
        bodyTextArea.clear();
        bodyTextArea.sendKeys(emailBodyText);
    }

    public void clickSendEmail(WebDriver driver) {
        WebElement sendEmailButton = driver.findElement(By.cssSelector("div[aria-label*='Send']"));
        sendEmailButton.click();
    }

    public void clickInboxWithNewEmail(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        WebElement inboxButton = driver.findElement(By.partialLinkText("Inbox"));
        inboxButton.click();
    }

    public EmailViewPage clickNewEmail(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='y6'] span[id] b")));
        WebElement newEmail = driver.findElement(By.cssSelector("div[class='y6'] span[id] b"));
        newEmail.click();

        return PageFactory.initElements(driver, EmailViewPage.class);
    }
}
