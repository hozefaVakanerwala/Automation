package Academy;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SimpleTest extends BaseTest {


    @Test

    public void base1PageNavigation() throws IOException {
        System.out.println("Simple Test one from Smoke suite is running ");
        Assert.assertTrue(true);

    }

    @Test

    public void base2PageNavigation() throws IOException {
        System.out.println("Simple Test two from Smoke suite is running ");
        Assert.assertTrue(true);

    }


}
