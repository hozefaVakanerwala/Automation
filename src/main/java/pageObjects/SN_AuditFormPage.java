package pageObjects;

import Utils.ExcelUtil;
import Utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import resources.Globals;

public class SN_AuditFormPage extends BasePage {
    // Declare all elements
    private static By audtiorSignBox = By.xpath("//h3[contains(text(),'Auditor Sign Off')]//following::canvas");
    private static By btnSubmit = By.xpath("//button[@id='submit_button']");
    WebDriverWait wait = new WebDriverWait(driver, 20);


    public SN_AuditFormPage(WebDriver driver) {
        super(driver);
    }

    public void validateAndAnswerQuestion(String label) {
        try {
            //Get random value as either "Pass" or "Fail"
            selectFromDropdown(label, Utilities.getRandom());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Couldn't find question: " + label);
        }

    }

    //## Description: This method is used to fill up the quality audit form
    //## History: Hozefa-- 27/Nov/2019-- Created

    public void fillUpQualityAuditForm(String technologyType, String classType) throws InterruptedException {
        driver.switchTo().frame("gsft_main");
        ExcelUtil.setExcelFileSheet("C:\\Users\\hozefa.vakanerwala\\Desktop\\", "OMMA_SNOW_QualityChklst_questions_V2_20191003.xlsx", "OMMA_Quality_Audit_SNOW");
        int rows = ExcelUtil.getTotalRows();

        for (int i = 1; i <= rows; i++) {
            String techFlag = ExcelUtil.getCellData(i, ExcelUtil.getColumnIndex(technologyType));
            String classFlag = ExcelUtil.getCellData(i, ExcelUtil.getColumnIndex(classType));
            String FSFlag = ExcelUtil.getCellData(i, ExcelUtil.getColumnIndex(Globals.AUDITOR_TYPE));

            if (FSFlag.equalsIgnoreCase("Y") && classFlag.equalsIgnoreCase("Y") && techFlag.equalsIgnoreCase("Y")) {
                String label = ExcelUtil.getCellData(i, 2);
                validateAndAnswerQuestion(label);
            }
        }

        /*Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(audtiorSignBox));
        Thread.sleep(1000);*/
        Actions builder = new Actions(driver);
        Action drawAction = builder.moveToElement(driver.findElement(audtiorSignBox), 50, 50)  // start point
                .clickAndHold()
                .moveByOffset(10, 10) // second point
                .build();
        drawAction.perform();
        Thread.sleep(1000);
        waitForElement(driver.findElement(btnSubmit)).click();
        driver.switchTo().defaultContent();

    }

}
