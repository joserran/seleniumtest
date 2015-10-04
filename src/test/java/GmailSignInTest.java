//location of file on pc C:\Users\joserran\gmail-webui-test-selenium

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by joserran on 10/2/2015.
 */
public class GmailSignInTest{
    @Test
    public void gmailLoginShouldBeSuccessful() throws InterruptedException {

        //1. Go to Gmail website
        WebDriver driver = new FirefoxDriver();
        driver.get("http://gmail.com");

        //2. fill in username
        WebElement usernameTextbox = driver.findElement(By.id("Email"));//this is where the locator goes.
        usernameTextbox.clear();//make sure text box is clear (empty text box in this case)
        //usernameTextbox.sendKeys("jose.l.serrano.93@gmail.com");
        usernameTextbox.sendKeys("username@gmail.com");

        //3. click sign in
        WebElement nextBox = driver.findElement(By.id("next"));
        nextBox.click();

        //4. fill in password
        Thread.sleep(2000);
        WebElement passwordTextbox = driver.findElement(By.id("Passwd"));
        passwordTextbox.sendKeys("****");

        //5. click sign in
        WebElement signInButton = driver.findElement(By.id("signIn"));
        signInButton.click();

        //6. verify user signed in
        //The first argument will be displayed if the 2nd argument does not assert to true (false)
        //the tagname <a> denotes linkage
        //2 elements (WebDriver driver, long timeOutInSeconds)
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
        Assert.assertTrue("Inbox should exist", driver.findElements(By.partialLinkText("Inbox")).size() > 0);
        //Assert.assertTrue("Inbox should exist", driver.findElements(By.xpath("//div[@class='aio UKr6le']/span/a")).size() > 0);//By.partialLinkText("Inbox")).size() > 0);

        //7. sign out
        WebElement profileButton = driver.findElement(By.cssSelector("span[class='gb_Ja gbii']"));
        profileButton.click();

        WebElement signOutButton = driver.findElement(By.id("gb_71"));
        signOutButton.click();

        // verify user did sign out
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signIn")));
        Assert.assertTrue("signIn button should exist", driver.findElements(By.id("signIn")).size() > 0);
    }
}
