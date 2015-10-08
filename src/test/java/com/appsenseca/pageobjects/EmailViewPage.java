package com.appsenseca.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by joserran on 10/7/2015.
 */
public class EmailViewPage {
    public String getEmailSubjectText(WebDriver driver) {
        WebElement subjectAreaText = driver.findElement(By.cssSelector("h2[class='hP']"));
        return subjectAreaText.getText();
    }

    public String getEmailBodyText(WebDriver driver) {
        WebElement bodyAreaText = driver.findElement(By.cssSelector("div[class='gs'] div[dir='ltr']"));
        return bodyAreaText.getText();
    }
}
