package Academy;

import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by spasham@planittesting.com
 */

public class BrowserSetup {

    protected WebDriver driver;
	protected DesiredCapabilities capabilities = new DesiredCapabilities();

	protected String BROWSER = "chrome";
	protected String NODE = "local";
	//protected String NODE = "localhost";
	//protected String PLATFORM = "ANY";
	protected String PLATFORM = "linux";

    public void openBrowser(String url) {
    	String drivers= System.getProperty("user.dir")+"/src/main/java/resources/";

        /*
         * System environment variable config params
         */
        if(System.getProperty("browser")!=null)
            BROWSER=System.getProperty("browser");
        if(System.getProperty("node")!=null)
            NODE=System.getProperty("node");
        if(System.getProperty("platform")!=null)
            PLATFORM=System.getProperty("platform");

        /*
         * Setup for local drivers and default config
         */
        if (BROWSER.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOpts = new ChromeOptions();
            if(NODE.equals("local")) {
                System.setProperty("webdriver.chrome.driver", drivers + "chromedriver.exe");
                driver = new ChromeDriver(chromeOpts);
            } else
                capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOpts);
        } else if (BROWSER.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOpts = new FirefoxOptions();
            if(NODE.equals("local")) {
                System.setProperty("webdriver.gecko.driver", drivers + "geckodriver.exe");
                firefoxOpts.setCapability("marionette", true);
                driver = new FirefoxDriver(firefoxOpts);
            } else
                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOpts);
        } else if (BROWSER.equalsIgnoreCase("internet explorer") ||
                BROWSER.equalsIgnoreCase("ie") ||
                BROWSER.equalsIgnoreCase("iexplorer")) {
            InternetExplorerOptions ieOptions = new InternetExplorerOptions().destructivelyEnsureCleanSession();
            if(NODE.equals("local")) {
                System.setProperty("webdriver.ie.driver", drivers + "IEDriverServer.exe");
                driver = new InternetExplorerDriver(ieOptions);
            } else
                capabilities.setCapability("se:ieOptions", ieOptions);  //reference from InternetExplorerOptions class
        } else {
            Assert.fail("Invalid Browser Selection, choose from ie, firefox, chrome");
        }

        /*
         * Setup for Selenium Grid - Remote Driver configuration
         */
        if(!NODE.equals("local")) {
            if (PLATFORM.equalsIgnoreCase("linux"))
                capabilities.setPlatform(Platform.LINUX);
            else if (PLATFORM.contains("win")) {
                capabilities.setPlatform(Platform.WINDOWS);
                capabilities.setPlatform(Platform.WIN10);
            }
            else
                capabilities.setPlatform(Platform.ANY);
            try {
                driver = new RemoteWebDriver(new URL("http://"+NODE+":4444/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        getUrl(url);
    }

	private void getUrl(String url) {
		try {
			driver.get(url);
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}