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
}
