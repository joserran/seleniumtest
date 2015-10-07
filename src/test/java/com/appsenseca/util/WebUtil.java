package com.appsenseca.util;

import com.appsenseca.pageobjects.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

/**
 * Created by joserran on 10/5/2015.
 */
public class WebUtil
{

    public static SignInPage goToSignInPage(WebDriver driver)
    {
        driver.get("http://gmail.com");
        return PageFactory.initElements(driver, SignInPage.class);
    }

}
