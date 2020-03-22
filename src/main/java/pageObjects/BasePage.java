package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BasePage {

    // Declare all elements
    private static By iframeMain = By.xpath("//iframe[@id='gsft_main']");
    private static By tblStatus = By.xpath("//span[contains(@class,'tabs2_section tabs2_section_0')]//span//table//tbody//tr//td//table/tbody//tr//td//div//table//tbody//tr");
    protected WebDriver driver;
    /*String sFSDStatusExcel="src/main/resources/VerificationFiles/FSDStatus.xlsx";
    String sOMMAStatusExcel="src/main/resources/VerificationFiles/OMMAStatus.xlsx";
    String sFSDStatusTemplate="src/main/resources/VerificationFiles/FSDStatus_Template.xlsx";
    String sOMMAStatusTemplate="src/main/resources/VerificationFiles/OMMAStatus_Template.xlsx";
    String sResponseXML="target/Jentrata Response/response.xml";
    String sPDFText="target/VerificationFiles/PDFText.txt";*/
    String sFSDStatusExcel = "C:\\workspace\\servicestream-automation-testing\\src\\main\\resources\\VerificationFiles\\FSDStatus.xlsx";
    String sOMMAStatusExcel = "C:\\workspace\\servicestream-automation-testing\\src\\main\\resources\\VerificationFiles\\OMMAStatus.xlsx";
    String sFSDStatusTemplate = "C:\\workspace\\servicestream-automation-testing\\main\\resources\\VerificationFiles\\FSDStatus_Template.xlsx";
    String sOMMAStatusTemplate = "C:\\workspace\\servicestream-automation-testing\\src\\main\\resources\\VerificationFiles\\OMMAStatus_Template.xlsx";
    String sResponseXML = "C:\\workspace\\servicestream-automation-testing\\target\\Jentrata Response\\response.xml";
    String sPDFText = "C:\\workspace\\servicestream-automation-testing\\target\\VerificationFiles\\PDFText.txt";
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static By getIframeMain() {
        return iframeMain;
    }

    //## Description: This function is used to switch an iFrame using the ID
    //## History: Michael-- 15/Dec/2015-- Created
    public void switchToIframeById(String IFrameId) {
        driver.switchTo().frame("//iframe[@id='" + IFrameId + "']");
    }

    //## Description: This function is used to switch an iFrame using the By parameters
    //## History: Michael-- 15/Dec/2015-- Created
    public void switchToIframeByBy(By Iframe) {
        driver.switchTo().frame(driver.findElement(Iframe));
    }

    //## Description: This function is used to find if an object exists
    //## History: Michael-- 15/Dec/2015-- Created
    public boolean objectExists(By ObjectBy, int timeoutSeconds) {
        Boolean isPresent = false;
        for (int i = 0; i < timeoutSeconds; i++) {
            if (driver.findElements(ObjectBy).size() > 0) {
                isPresent = true;
                break;
            } else {
                try {
                    Thread.sleep(timeoutSeconds * 1000);
                } catch (Exception e) {
                }
            }
        }
        return isPresent;
    }


    //## Description: This function is used to clear variables and arrays before every task
    //## History: Pallavi-- 25/Jan/2015-- Created
/*	public void taskCleanUp(){
		Globals.TEST_URL = "";
		Globals.TASK_ADDRESS="";
		Globals.CURRENT_TASK_STATUS = "";
		Globals.CURRENT_ACTION="None";
		Globals.TECHNICIAN_NAME="";
		Globals.ETAM_CLAIMS = new ArrayList<String>();
		Globals.SN_CLAIMS = new ArrayList<String>();
		Globals.BS_CLAIMS = new ArrayList<String>();
		Globals.CONVERSATION_ID="";
		Globals.MESSAGEID="";
	}*/


    //## Description: This function is used to handle unexpected / session expired alerts when opening web applications
    //## History: Sithikar-- 03/Apr/2018-- Created
    public void handleAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException exception) {
        }
    }

    /**
     * Waits for any button to be clickable
     *
     * @param element    The element to wait for
     * @param secsToWait The time to wait in seconds
     * @return WebElement or throws timeout exception
     */
    protected WebElement waitForButton(WebElement element, int secsToWait) {
        return (new WebDriverWait(driver, secsToWait))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Selects a value from a dropdown based on the label/text preceding it.
     *
     * @param label      Exact text preceding the field (Case sensitive)
     * @param option     The value inside the dropdown to select
     * @param secsToWait How long to wait for the value to become available
     */
    public void selectFromDropdown(String label, String option, int secsToWait) {
        WebElement input = null;
        try {
            input = waitForButton((driver.findElement(By.xpath(("//span[contains(text(),'" + label + "')]//following::select[1]")))), secsToWait);
        } catch (Exception e) {
            try {
                input = waitForButton((driver.findElement(By.xpath(("//td[contains(text(),'" + label + "')]//following::select[1]")))), secsToWait);
            } catch (Exception e1) {
                Assert.fail("Couldn't select from dropdown: " + label);
            }
        }
        selectFromDropdown(input, option);
    }

    /**
     * selects an element from a dropdown menu that exactly matches the option provided
     *
     * @param element the selector of the dropdown menu
     * @param option  the value we are setting in the dropdown menu
     */
    public void selectFromDropdown(WebElement element, String option) {
        Select selector = new Select(waitForElement(element));
        selector.selectByVisibleText(option);
    }

    /**
     * Selects a value from a dropdown based on the label/text preceding it. Default wait option.
     *
     * @param label  Exact text preceding the field (Case sensitive)
     * @param option The value inside the dropdown to select
     */
    public void selectFromDropdown(String label, String option) {
        selectFromDropdown(label, option, 10);
    }

    public WebElement waitForElement(WebElement element, int secsToWait) {
        WebElement find;
        WebDriverWait wait = new WebDriverWait(driver, secsToWait);
        try {
            Thread.sleep(secsToWait * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        find = wait.until(ExpectedConditions.visibilityOf(element));
        return find;
    }

    /**
     * waits for an element to become present on the page for 10 seconds
     *
     * @param element the selector of the element being waited for
     * @return whether the element was found on the page in the allotted time
     */
    protected WebElement waitForElement(WebElement element) {
        WebElement find;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        find = wait.until(ExpectedConditions.visibilityOf(element));
        return find;
    }

    /**
     * enters value into field type input
     *
     * @param label the name of the field
     * @param value the value of the field
     * @return void
     */
    public void enterValueIntoField(String label, String value) {
        WebElement element = waitForElement(driver.findElement(By.xpath("//span[text()='" + label + "']//following::input[2]")));
        element.sendKeys(value);
    }

    /**
     * switch to a new window
     */
    public void switchWindow() {

        for (String winHandle : driver.getWindowHandles()) {
            try {
                driver.switchTo().window(winHandle);
                //System.out.println(" pagina "+ winHandle);
            } catch (NoSuchWindowException e) {

            }
        }
    }

    /**
     * wait 5 seconds for all windows to close when multiple popup windows close simultaneously
     */
    public void waitForWindowAndSwitch() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.switchWindow();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.id("gsft_main")));
    }

    /**
     * Select a sublink-Add New Related Agency from the topFr under Agency Relationships->RelationshipType->Add New Related Agency.
     *
     * @param label Exact text of the link on the page (Case sensitive)
     */
    public void clickSearchGlassButton(String label) {
        WebElement input = null;

        try {
            input = waitForButton((driver.findElement(By.xpath(("//span[text()='" + label + "']//following::button")))), 10);
        } catch (Exception e) {
            Assert.fail("Couldn't click search button of: " + label);
        }
        input.click();
    }

    /**
     * Select the current day from the calendar
     *
     * @return void
     */

    public void calendarDatePicker(String label) throws InterruptedException {
        //Select the current date
        DateFormat dateFormat2 = new SimpleDateFormat("dd");
        Date date2 = new Date();
        String today = dateFormat2.format(date2);

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
            if (value.getText().equals(today)) {
                value.click();
                //value.sendKeys(Keys.ENTER);
                break;
            }
        }
    }

    public void clickLinkInTable(String label) {
        WebElement element = driver.findElement(By.xpath("(//a[contains(@aria-label,'" + label + "')])[2]"));
        element.click();
    }

    public WebElement populateInputField(String label, String value) {
        WebElement element = driver.findElement(By.xpath("//span[text() = '" + label + "']//following::input"));
        element.sendKeys(value);
        return element;
    }

    public String readSNField(String label) {
        WebElement element = driver.findElement(By.xpath("//span[text()='" + label + "']//following::input[1]"));
        return element.getAttribute("value");
    }

    //## Description: This method is used to sort the ccolumn
    //## History: Hozefa-- 18/Oct/2019-- Created
    public void sortColumnMostRecent(String columnName) {
        System.out.println("Sorting by most recent");
        WebElement column = driver.findElement(By.xpath("(//*[@glide_label='" + columnName + "'])[1]/span/i"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@glide_label='"+columnName+"'])[1]/span/i")));
        column.click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(createdColumnSortZtoA));
        driver.findElement(By.xpath("//*[contains(text(),'Sort (z to a)')]")).click();
    }


}