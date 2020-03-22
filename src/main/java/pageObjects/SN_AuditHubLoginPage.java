package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.IOException;

import static org.testng.Assert.*;

public class SN_AuditHubLoginPage extends BasePage {

    private static By iframeMain = By.xpath("//iframe[@id='gsft_main']");
    private static By txtUsername = By.xpath("//input[@id='user_name']");
    private static By txtPassword = By.xpath("//input[@id='user_password']");
    private static By btnLogin = By.xpath("//button[@id='sysverb_login']");
    private static By lstUser = By.xpath("//button[@id=\"user_info_dropdown\"]");
    private static By btnLogout = By.xpath("//a[contains(text(),'Logout')]");
    //Locators for Impersonating User
    private static By userMenu = By.xpath("//*[@class='sn-avatar_xs sn-avatar_v2 ng-isolate-scope sn-avatar_noop']");
    private static By impersonateUserOption = By.xpath("/html/body/div/div/div/header/div[1]/div/div[2]/div/div[2]/div/ul/li[2]/a");
    private static By impersonateUserDropKey = By.xpath("//*[@id=\"s2id_autogen1\"]/a/span[2]");
    private static By ImpersonateUserValue = By.id("s2id_autogen2_search");
    WebDriverWait wait = new WebDriverWait(driver, 30);

    public SN_AuditHubLoginPage(WebDriver driver) {
        super(driver);
    }

    //## Description: This function is used to set the user name.
    //## History: Pallavi-- 29/Dec/2015-- Created
    public void setUsername(String sUsername) {
        driver.findElement(txtUsername).sendKeys(sUsername);
    }

    //## Description: This function is used to set the password.
    //## History: Pallavi-- 29/Dec/2015-- Created
    public void setPassword(String sPassword) {
        driver.findElement(txtPassword).sendKeys(sPassword);
    }

    //## Description: This function is used to click on the login button.
    //## History: Pallavi-- 29/Dec/2015-- Created
    public void clickLogin() {
        driver.findElement(btnLogin).click();
    }


    //## Description: This function is used to click on the logout button.
    //## History: Pallavi-- 29/Dec/2015-- Created
    public void clicklogout() throws InterruptedException {
        clickUserProfile();
        driver.findElement(btnLogout).click();
        //Thread.sleep(2000);
    }


    //## Description: This function is used to click on the logout button.
    //## History: Pallavi-- 01/Apr/2016-- Created
    public void clickUserProfile() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lstUser));
        driver.findElement(lstUser).click();
    }

    //## Description: This function will return true if logged out
    //## History: Pallavi-- 29/Dec/2015-- Created
    public boolean loggedOut() {
        switchToIframeByBy(iframeMain);
        boolean exist = objectExists(btnLogin, 10);
        driver.switchTo().defaultContent();
        return exist;
    }


    //## Description: This scenario is used to login to Service Now
    //## History: Pallavi-- 29/Dec/2015-- Created
    //## History: Pallavi-- 01/Apr/2016-- Included function for click user profile
    public void login(String sUsername, String sPassword) throws InterruptedException, IOException {

        //if(driver.findElement(btnLogout).isDisplayed()){
        if (!objectExists(btnLogin, 1)) {
            System.out.println("Service Now Audit Login page not reached");
            Reporter.log("Service Now Audit Login page not reached");
            assertEquals(true, false, "Service Now Audit Login page not reached");
        }

        setUsername(sUsername);
        setPassword(sPassword);
        clickLogin();

        if (objectExists(btnLogin, 1)) {
            System.out.println("Service Now Audit Login unsuccessful");
            Reporter.log("Service Now Audit Login page unsuccessful");
            assertEquals(true, false, "Service Now Audit Login unsuccessful");
        }


    }


    //## Description: This scenario is used to logout to Service Now
    //## History: Pallavi-- 29/Dec/2015-- Created
    //## History: Pallavi-- 01/Apr/2016-- Included function for click user profile
    public void logout(String username, String password) throws InterruptedException {
        clicklogout();
        loggedOut();
    }


    /**
     * Description: Impersonates user to execute the required functionality
     *
     * @param user
     * @throws InterruptedException History-- Hozefa April 2019 -- Created
     */


    public void impersonateUser(String user) throws InterruptedException {
        driver.switchTo().defaultContent();
        clickUserProfile();
        wait.until(ExpectedConditions.visibilityOfElementLocated(impersonateUserOption));
        waitForElement(driver.findElement(impersonateUserOption)).sendKeys(Keys.RETURN);
        waitForElement(driver.findElement(impersonateUserDropKey)).click();
        waitForElement(driver.findElement(ImpersonateUserValue)).sendKeys(user);
        Thread.sleep(2000);
        driver.findElement(ImpersonateUserValue).sendKeys(Keys.RETURN);
        Thread.sleep(1000);
        WebElement WFMUser = waitForElement(driver.findElement(By.xpath("(//*[contains(text(),'" + user + "')])[2]")));
        boolean userExist = WFMUser.isDisplayed();
        if (userExist) {
            assertTrue(userExist);
            System.out.println("User Impersonated: " + user);
        } else
            assertFalse(!userExist);
    }

}

