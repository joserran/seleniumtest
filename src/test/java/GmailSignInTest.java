//location of file on pc C:\Users\joserran\gmail-webui-test-selenium

import com.appsenseca.pageobjects.EmailHomePage;
import com.appsenseca.pageobjects.EmailViewPage;
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
        signInPage.fillInPassword(driver, "configuration.properties");


        //5. click sign in
        EmailHomePage emailHomePage = signInPage.clickSignIn(driver);

        //6. verify user signed in
        Assert.assertTrue("Inbox should exist", emailHomePage.isInboxExist(driver));

        //7. sign out
        SignInPage afterSignOut = EmailHomePage.signOut(driver);

        // 8.verify user did sign out
        Assert.assertTrue("signIn button should exist", signInPage.isSignInButtonExist(driver));
    }

    @Test
    public void gmailSendAndReceiveEmail() throws InterruptedException{

        //1. Click sign in
        //Go to Gmail website
        SignInPage signInPage = WebUtil.goToSignInPage(driver);

       //fill in username
        signInPage.fillInUserName(driver, "configuration.properties");

        //click sign in
        signInPage.clickNext(driver);

        //fill in password
        signInPage.fillInPassword(driver, "configuration.properties");

        //click sign in
        EmailHomePage emailHomePage = signInPage.clickSignIn(driver);

        //The first argument will be displayed if the 2nd argument does not assert to true (false)
        //the tagname <a> denotes linkage
        //2 elements (WebDriver driver, long timeOutInSeconds)
        Assert.assertTrue("Inbox should exist", emailHomePage.isInboxExist(driver));

        //2. Click compose
        emailHomePage.clickCompose(driver);


        //3. Fill in  recipient
        //use the following as locator for To: box
        //WebElement toInputTextArea = driver.findElement(By.cssSelector("textarea[id=':96']"));
        String recipient = "udemyjohn2015@gmail.com";
        emailHomePage.fillInRecipient(driver, recipient);


        //4. Fill in subject
        final String subjectText = "Gmail Send Email Test";
        emailHomePage.fillInSubject(driver, subjectText);


        //5. Fill in email body
        final String emailBodyText = "Hello Testers Good Morning";
        emailHomePage.fillInEmailBody(driver, emailBodyText);

        //6. Click send
        emailHomePage.clickSendEmail(driver);

        //7. Click inbox again
        emailHomePage.clickInboxWithNewEmail(driver);


        //8. Click email
        EmailViewPage emailViewPage = emailHomePage.clickNewEmail(driver);


        //9. Verify the email subject and email body is correct
        String actualSubject = emailViewPage.getEmailSubjectText(driver);

        Assert.assertEquals("Email subject should be the same", subjectText, actualSubject);

        String actualBody = emailViewPage.getEmailBodyText(driver);
        WebElement bodyAreaText = driver.findElement(By.cssSelector("div[class='gs'] div[dir='ltr']"));
        Assert.assertEquals("Email body should be the same", emailBodyText, actualBody);

        //10. Sign out
        emailHomePage.signOut(driver);
    }

}

