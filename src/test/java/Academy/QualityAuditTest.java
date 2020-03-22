package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObjects.SN_AuditFormPage;
import pageObjects.SN_AuditHomePage;
import pageObjects.SN_AuditHubLoginPage;
import pageObjects.SN_AuditNewInstancePage;

import java.io.IOException;

public class QualityAuditTest extends BaseTest {
    public static Logger log = LogManager.getLogger(BaseTest.class.getName());

    @BeforeTest
    public void initialize() throws IOException {

        driver = initializeDriver();
        log.info("Driver is initialized");

        driver.get(prop.getProperty("audit_url"));
        log.info("Navigated to Audit Login Page");
    }
    //@Test

    public void qualityAudit() throws IOException, InterruptedException {
        SN_AuditHubLoginPage loginPage = new SN_AuditHubLoginPage(driver);
        loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
        Assert.assertTrue(false);
        SN_AuditHomePage auditHomePage = new SN_AuditHomePage(driver);
        auditHomePage.clicktab("New Audit");

        SN_AuditNewInstancePage auditNewInstance = new SN_AuditNewInstancePage(driver);
        String auditNumber = auditNewInstance.populateNewAuditFields(prop.getProperty("auditorType"));
        auditHomePage.clicktab("Pending Audits");
        auditHomePage.openAuditPage(auditNumber);
        auditHomePage.openQualityAuditForm();

        SN_AuditFormPage auditForm = new SN_AuditFormPage(driver);
        auditForm.fillUpQualityAuditForm("HFC", "SC 22");


    }

    @AfterTest
    public void teardown() {
		
		/*driver.close();
		driver=null;*/

    }


}
