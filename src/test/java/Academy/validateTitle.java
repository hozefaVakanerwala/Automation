package Academy;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import java.io.IOException;

public class validateTitle extends BaseTest {

    @Test

    public void validateAppTitle() throws IOException {

        //one is inheritance
        // creating object to that class and invoke methods of it
        LandingPage l = new LandingPage(driver);
        //compare the text from the browser with actual text.- Error..
        Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");

        System.out.println("Test running from Inside docker for tests dated 22-03-2020");
        System.out.println("Test completed");

        ;


    }

    @AfterTest
    public void teardown() {

        driver.quit();
        driver = null;

    }


}
