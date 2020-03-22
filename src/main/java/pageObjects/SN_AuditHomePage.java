package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SN_AuditHomePage extends BasePage {
    // Declare all elements
    private static By audtiorSignBox = By.xpath("//h3[contains(text(),'Auditor Sign Off')]//following::canvas");
    private static By btnSubmit = By.xpath("//button[@id='submit_button']");
    private static By btnLogout = By.xpath("//a[text()='Logout']");
    WebDriverWait wait = new WebDriverWait(driver, 20);


    public SN_AuditHomePage(WebDriver driver) {
        super(driver);
    }


    //## Description: This method is used to click on the Pending audit tab in the audit Home Page
    //## History: Hozefa-- 28/Apr/2019-- Created

    public void clicktab(String label) {
        driver.findElement(By.xpath("//a[text()='" + label + "']")).click();
    }

    //## Description: This method is used to click on the link to open the audit Page
    //## History: Hozefa-- 28/Apr/2019-- Created

    public void openAuditPage(String auditNum) {
        driver.findElement(By.xpath("//a[text()='" + auditNum + "']")).click();
    }


    public void openQualityAuditForm() {
        driver.findElement(By.xpath("//a[text()='Quality Audit']")).click();
    }

    //## Description: This method is used to click on the link to open the audit Page
    //## History: Hozefa-- 28/Apr/2019-- Created

    public void openAuditForm() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='Project HSE Pre-start inspection']")).click();
        //Thread.sleep(5000);
        /*((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", driver.findElement(audtiorSignBox));*/
        driver.switchTo().frame("gsft_main");
        waitForElement(driver.findElement(btnSubmit));
        selectFromDropdown("1.1 Tool of trade / commercial vehicle in good condition with no damage and smoke free (all lights, windscreen wipers, roof racks, towbar, windscreen wipers, windscreen, tyres have sufficient tread)", "Yes");
        selectFromDropdown("1.2 SSM decals attached to vehicle (SSM only)", "Yes");
        selectFromDropdown("1.3 Vented gas storage facility fitted in vehicle", "Yes");
        selectFromDropdown("1.4 Conduit carrier with end caps fitted on vehicle", "Yes");
        selectFromDropdown("1.5 Vehicle ladder racks and ladder strap", "Yes");
        selectFromDropdown("1.6 Loose / unrestrained items are securely stored (shelving, storage)", "Yes");
        selectFromDropdown("1.7 Cargo barriers fitted in vehicle (where required)", "Yes");
        selectFromDropdown("1.8 Vehicle maintance/servicing (check log book) has been kept up to date", "Yes");
        selectFromDropdown("1.9 First aid kit", "Yes");
        selectFromDropdown("1.10 First aid and emergency equipment stickers on vehicle", "Yes");
        selectFromDropdown("1.11 Fire extinguisher, tested within 6 months", "Yes");
        selectFromDropdown("1.12 Sharps kit (container, gloves & tongs)", "Yes");
        selectFromDropdown("2.1 Sun screen ++factor", "Yes");
        selectFromDropdown("2.2 Hard hat (within 3 years) wide brim/neck flaps/chin strap", "Yes");
        selectFromDropdown("2.3 Safety footwear (steel cap boots)", "Yes");
        selectFromDropdown("2.4 Bump cap (underfloor only)", "Yes");
        selectFromDropdown("2.5 Booties or 2nd pair of shoes (wear inside customer premise)", "Yes");
        selectFromDropdown("2.6 Long sleeved shirt and pants or overalls", "Yes");
        selectFromDropdown("2.7 Hi-vis shirt/vest (reflective tape for night)", "Yes");
        selectFromDropdown("2.8 Riggers gloves (leather)", "Yes");
        selectFromDropdown("2.9 LV gloves (within 3 years)", "Yes");
        selectFromDropdown("2.10 Safety glasses", "Yes");
        selectFromDropdown("2.11 Hearing protection", "Yes");
        selectFromDropdown("2.12 Wide brim hat", "Yes");
        selectFromDropdown("2.13  Torch / headlamp unit", "Yes");
        selectFromDropdown("2.14 Insulated rubber mat", "Yes");
        selectFromDropdown("2.15 Step ladder (fibreglass)", "Yes");
        selectFromDropdown("2.16 Insulated tools (pliers, cutters, screwdrivers)", "Yes");
        selectFromDropdown("2.17 Battery operated cordless hand tools & charger, tested and tagged (where required)", "Yes");
        selectFromDropdown("2.18 RCD, tested and tagged", "Yes");
        selectFromDropdown("2.19 Tool bag", "Yes");
        selectFromDropdown("2.20 Continuous Rodders/fibreglass rods (2 sizes 4.5mm & 6mm or 11mm)", "Yes");
        selectFromDropdown("2.21 Dust masks (P2)", "Yes");
        selectFromDropdown("2.22 Gas detector, calibrated 6 monthly (Guardalert Microclip XT preferred)", "Yes");
        selectFromDropdown("2.23 Danger / Lock Out Tags", "Yes");
        selectFromDropdown("2.24 Traffic / work signs - retro reflective “A” frame signs, digger-man/workman signs", "Yes");
        selectFromDropdown("2.25 Traffic cones (min 450mm) - 9 with 5 reflective", "Yes");
        selectFromDropdown("2.26 Pit/Manhole Guards - 1 FULL SET (not inspection guards)", "Yes");
        selectFromDropdown("2.27 Manhole Key/Manhole Lid Lifter/Pit Key/Seal breaker", "Yes");
        selectFromDropdown("3.1 Service Stream photo ID and induction card (one for each worker)", "Yes");
        selectFromDropdown("3.2 Client ID / Induction card (one for each worker)", "Yes");
        selectFromDropdown("3.3 Drivers licence (suits vehicle type)", "Yes");
        selectFromDropdown("3.4 OH&S Construction Industry Card", "Yes");
        selectFromDropdown("3.6 ACMA (Open Registration) Card with work types endorsements", "Yes");
        selectFromDropdown("3.7 Traffic control accreditation (if applicable)", "Yes");
        selectFromDropdown("3.8 First Aid Officers (if two or more workers on site)", "Yes");
        selectFromDropdown("4.1 project HSE Management Plan", "Yes");
        selectFromDropdown("4.2 Service Stream generic Traffic control plans", "Yes");
        selectFromDropdown("4.3 project SWMS and referenced Safe Work Guides/HSE Compliance Guides", "Yes");
        selectFromDropdown("4.4 Service Stream JSEA", "Yes");
        selectFromDropdown("4.5 Emergency Response Guide, Emergency Card, Contacts List", "Yes");
        selectFromDropdown("4.6 Safety Data Sheets available for all chemicals, within 5 years", "Yes");

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

    public void logout() {
        driver.findElement(btnLogout).click();
    }

}
