package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import java.io.IOException;

//Adding logs
//Generating html reports
//Screenshots on failure
//JEnkins integration
public class validateNavigationBar extends BaseTest {

    public static Logger log = LogManager.getLogger(BaseTest.class.getName());

    @BeforeTest

    public void initialize() throws IOException {

        driver = initializeDriver();

        driver.get(prop.getProperty("url"));
    }

    @Test

    public void validateAppNavBar() throws IOException {

        //one is inheritance
        // creating object to that class and invoke methods of it
        LandingPage l = new LandingPage(driver);

        //compare the text from the browser with actual text.- Error..
        Assert.assertTrue(l.getNavigationBar().isDisplayed());
        log.info("Navigation Bar is displayed");
        System.out.println("Test completed");
        //   Assert.assertFalse(false);
        ;


    }

    @AfterTest
    public void teardown() {

        driver.close();
        driver = null;

    }


}
