//location of file on pc C:\Users\joserran\gmail-webui-test-selenium

import com.appsenseca.pageobjects.EmailHomePage;
import com.appsenseca.pageobjects.SignInPage;
import com.appsenseca.util.WebUtil;
import com.appsenseca.util.WebUtil;
import com.gargoylesoftware.htmlunit.util.WebClientUtils;
import com.sun.xml.internal.ws.model.WrapperBeanGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

/**
 * Created by joserran on 10/2/2015.
 */
public class GmailSignInTest{
    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    @Test
    public void gmailLoginShouldBeSuccessful() throws InterruptedException {


        //1. Go to Gmail website
        SignInPage signInPage = WebUtil.goToSignInPage(driver);

        //2. fill in username
        signInPage.fillInUserName(driver, "configuration.properties");

        //3. click sign in
        //signInPage
        signInPage.clickNext(driver);

        //4. fill in password
        //Thread.sleep(2000);
        signInPage.fillInPassword(driver, "configuration.properties");


        //5. click sign in
        EmailHomePage emailHomePage = signInPage.clickSignIn(driver);

        //6. verify user signed in
        Assert.assertTrue("Inbox should exist", emailHomePage.isElementExist(driver));

        //7. sign out
        SignInPage afterSignOut = EmailHomePage.signOut(driver);

        // 8.verify user did sign out
        Assert.assertTrue("signIn button should exist", signInPage.isSignInButtonExist(driver));
    }

    @Test
    public void gmailSendAndReceiveEmail() throws InterruptedException{

        //1. Click sign in
        //Go to Gmail website
        WebDriver driver = new FirefoxDriver();
        driver.get("http://gmail.com");
        System.out.println(new Date().toString() + "\tFinished going to gmail.");

        //fill in username
        WebElement usernameTextbox = driver.findElement(By.id("Email"));//this is where the locator goes.
        usernameTextbox.clear();//make sure text box is clear (empty text box in this case)
        //usernameTextbox.sendKeys("jose.l.serrano.93@gmail.com");
        usernameTextbox.sendKeys("udemyjohn2015@gmail.com");
        System.out.println(new Date().toString() + "\tFilled in username.");

        //click sign in
        WebElement nextBox = driver.findElement(By.id("next"));
        nextBox.click();
        System.out.println(new Date().toString() + "\tClicked signin.");

        //fill in password
        Thread.sleep(2000);
        WebElement passwordTextbox = driver.findElement(By.id("Passwd"));
        passwordTextbox.sendKeys("udemyjohn2015123");
        System.out.println(new Date().toString() + "\tFilled in password.");

        //click sign in
        WebElement signInButton = driver.findElement(By.id("signIn"));
        signInButton.click();
        System.out.println(new Date().toString() + "\tClicked second sign in.");

        //The first argument will be displayed if the 2nd argument does not assert to true (false)
        //the tagname <a> denotes linkage
        //2 elements (WebDriver driver, long timeOutInSeconds)
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        Assert.assertTrue("Inbox should exist", driver.findElements(By.partialLinkText("Inbox")).size() > 0);
        System.out.println(new Date().toString() + "\tVerifyed user signin.");

        //2. Click compose
        WebElement composeButton = driver.findElement(By.cssSelector("div[role='button'][gh='cm']"));
        composeButton.click();

        //3. Fill in  recipient
        //use the following as locator for To: box
        //WebElement toInputTextArea = driver.findElement(By.cssSelector("textarea[id=':96']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[name='to']")));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='gb_b gb_Qa gb_R gb_Ma']")));
        WebElement toInputTextArea = driver.findElement(By.cssSelector("textarea[name='to']"));
        toInputTextArea.clear();
        toInputTextArea.sendKeys("udemyjohn2015@gmail.com");

        //4. Fill in subject
        WebElement subjectInputBox = driver.findElement(By.cssSelector("input[name='subjectbox']"));
        subjectInputBox.clear();
        final String subjectText = "Gmail Send Email Test";
        subjectInputBox.sendKeys(subjectText);

        //5. Fill in email body
        WebElement bodyTextArea = driver.findElement(By.cssSelector("div[role='textbox']"));
        final String body = "Hello Testers Good Morning";
        bodyTextArea.clear();
        bodyTextArea.sendKeys(body);

        //6. Click send
        WebElement sendEmailButton = driver.findElement(By.cssSelector("div[aria-label*='Send']"));
        sendEmailButton.click();

        //7. Click inbox again
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.partialLinkText("Inbox"))));
        WebElement inboxButton = driver.findElement(By.partialLinkText("Inbox"));
        //wait.until(ExpectedConditions.visibilityOf(inboxButton));
        inboxButton.click();

        //8. Click email
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='y6'] span[id] b")));
        WebElement newEmail = driver.findElement(By.cssSelector("div[class='y6'] span[id] b"));

        newEmail.click();

        //9. Verify the email subject and email body is correct
        WebElement subjectAreaText = driver.findElement(By.cssSelector("h2[class='hP']"));
        Assert.assertEquals("Email subject should be the same", subjectText, subjectAreaText.getText());
        WebElement bodyAreaText = driver.findElement(By.cssSelector("div[class='gs'] div[dir='ltr']"));
        Assert.assertEquals("Email body should be the same", body, bodyAreaText.getText());

        //10. Sign out
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='gb_b gb_Qa gb_R gb_Ma']")));
        WebElement profileButton = driver.findElement(By.cssSelector("a[class='gb_b gb_Qa gb_R gb_Ma']"));
        profileButton.click();

        WebElement signOutButton = driver.findElement(By.id("gb_71"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gb_71")));
        signOutButton.click();
        System.out.println(new Date().toString() + "\tSigned out.");
    }

}

