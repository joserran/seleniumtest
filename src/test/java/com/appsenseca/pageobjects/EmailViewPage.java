package com.appsenseca.pageobjects;

import com.appsenseca.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by joserran on 10/7/2015.
 */
public class EmailViewPage {

    public String getEmailSubjectText(WebDriver driver) {
        WebUtil.waitForElementVisible(driver, By.xpath("//div[@class='ha']/h2[@class='hP']"));
        return WebUtil.getElementText(driver, By.xpath("//div[@class='ha']/h2[@class='hP']"));
    }

    public String getEmailBodyText(WebDriver driver) {
        return WebUtil.getElementText(driver, By.cssSelector("div[class='gs'] div[dir='ltr']"));
    }
}
