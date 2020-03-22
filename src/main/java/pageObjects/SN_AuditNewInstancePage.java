package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.Globals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SN_AuditNewInstancePage extends BasePage {
    // Declare all elements
    private static By strProject = By.xpath("//span[text() = 'Project']//following::input[5]");
    private static By strAuditMaster = By.xpath("//span[text() = 'Audit Master']//following::input[5]");
    private static By strCompany = By.xpath("//span[text() = 'Company']//following::input[5]");
    private static By strTechnician = By.xpath("//span[text() = 'Technician']//following::input[5]");
    private static By strTaskID = By.xpath("//span[text() = 'Task ID']//following::input[5]");
    private static By strAssignedto = By.xpath("//span[text() = 'Assigned to']//following::input[5]");
    private static By btnSubmit = By.xpath("//button[@id='submit_button']");
    WebDriverWait wait = new WebDriverWait(driver, 20);

    public SN_AuditNewInstancePage(WebDriver driver) {
        super(driver);
    }

    public void popluateNewAuditField(By locator, String value) throws InterruptedException {
        driver.findElement(locator).sendKeys(value);
        Thread.sleep(1000);
    }

    public void calendarDate(String label) throws InterruptedException {
        //Select the current date
        DateFormat dateFormat2 = new SimpleDateFormat("dd");
        Date date2 = new Date();
        String today = dateFormat2.format(date2);
        //code to remove leading zeroes from single digit day
        int today1 = Integer.parseInt(dateFormat2.format(date2));


        WebElement calendarButton = waitForElement(driver.findElement(By.xpath("//span[text() = '" + label + "']//following::span[@class = 'input-group-btn'][1]")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", calendarButton);
        Thread.sleep(500);
        waitForElement(calendarButton).click();
        waitForElement(calendarButton).click();

        //calendarButton.click();
        //Find the calendar
        WebElement dataWidget = driver.findElement(By.className("calTable"));
        List<WebElement> columns = dataWidget.findElements(By.tagName("a"));
        for (WebElement value : columns) {
            if (value.getText().equals(Integer.toString(today1))) {
                value.click();
                value.sendKeys(Keys.ENTER);
                break;
            }
        }
    }

    //## Description: This method is used to populated new Audit fields of quality audit to create a new instance.
    //## History: Hozefa-- 24/Nov/2019-- Created

    public String populateNewAuditFields(String auditorType) throws InterruptedException {
        driver.switchTo().frame("gsft_main");
        popluateNewAuditField(strProject, "OMMA");
        popluateNewAuditField(strAuditMaster, "Quality Audit");
        popluateNewAuditField(strCompany, "Value Electrical and Airconditioning Services Pty Ltd");
        popluateNewAuditField(strTechnician, "Hitesh Garg");
        selectFromDropdown("Lookup Period", "Past 365 days");
        popluateNewAuditField(strTaskID, "TASK-OM-02364191");
        calendarDate("Due Date");
        selectFromDropdown("Auditor Type", Globals.AUDITOR_TYPE);
        popluateNewAuditField(strAssignedto, "Hozefa Vakanerwala");

        // Click submit button
        driver.findElement(btnSubmit).click();

        //Get AuditNo
        Globals.AUDIT_NO = driver.findElement(By.xpath("//*[contains(text(),'Audit Details')]//following ::div/dl/dd")).getText();
        return Globals.AUDIT_NO;

    }


}
