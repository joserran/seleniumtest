package com.appsenseca.pageobjects;

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
        //getting the username from the file.
        String[] accessArgs = new String[2];
        try {
            Scanner in = new Scanner(new File(stringFileName));
            accessArgs[0] = in.next();
            accessArgs[1] = in.next();
            in.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found" + e);
        }

        WebElement usernameTextbox = driver.findElement(By.id("Email"));//this is where the locator goes.

        usernameTextbox.clear();//make sure text box is clear (empty text box in this case)
        //usernameTextbox.sendKeys("jose.l.serrano.93@gmail.com");
        usernameTextbox.sendKeys(accessArgs[0]);
    }

    public void clickNext(WebDriver driver) {
        WebElement nextBox = driver.findElement(By.id("next"));
        nextBox.click();
    }

    public void fillInPassword(WebDriver driver, String stringFileName) {

        //passwordTextbox.sendKeys(credentials[1]);
        String[] accessArgs = new String[2];
        try {
            Scanner in = new Scanner(new File(stringFileName));
            accessArgs[0] = in.next();
            accessArgs[1] = in.next();
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found" + e);
        }
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
        WebElement passwordTextbox = driver.findElement(By.id("Passwd"));
        passwordTextbox.clear();
        passwordTextbox.sendKeys(accessArgs[1]);
    }

    public EmailHomePage clickSignIn(WebDriver driver) {
        WebElement signInButton = driver.findElement(By.id("signIn"));
        signInButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));

        return PageFactory.initElements(driver, EmailHomePage.class);
    }

    public boolean isSignInButtonExist(WebDriver driver) {
        return driver.findElements(By.id("signIn")).size() > 0;
    }
}
