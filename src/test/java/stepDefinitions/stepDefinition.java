package stepDefinitions;

import Academy.BaseTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

//@RunWith(Cucumber.class)
public class stepDefinition extends BaseTest {
    @Given("^Initialise browser with Chrome$")
    public void initialise_browser_with_Chrome() throws Throwable {
        driver = initializeDriver();
    }

    @Given("^Navigage to \"([^\"]*)\" Site$")
    public void navigage_to_Site(String arg1) throws Throwable {
        driver.get(arg1);
    }

    @Given("^Click on Login link in home page to land on secure sign in Page$")
    public void click_on_Login_link_in_home_page_to_land_on_secure_sign_in_Page() throws Throwable {
        LandingPage l = new LandingPage(driver);
        l.getLogin().click();
    }

    @When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
    public void user_enters_and_and_logs_in(String arg1, String arg2) throws Throwable {
        LoginPage lp = new LoginPage(driver);
        lp.getEmail().sendKeys(arg1);
        lp.getPassword().sendKeys(arg2);
        lp.getLogin().click();
    }

    @Then("^Verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in() throws Throwable {
        System.out.println("Validation pending");
        //Assert.assertTrue(false);
    }

}
