package base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.ConfigReader;
import utilities.ConsoleOutputCapture;

public class BaseTest {
	protected WebDriver driver;
    private Properties prop;

    @Before
    public void setup() {
    	ConsoleOutputCapture.captureConsoleOutput();
    	System.out.println();
    	System.out.println("############################### Execution started ##############################");
       System.out.println();
    	// Load configuration properties
        prop = ConfigReader.loadProperties();
        
        // Initialize WebDriver
        DriverFactory.initDriver(prop);
        driver = DriverFactory.getDriver();

        // Navigate to the application URL
        driver.get(prop.getProperty("url"));
    }

    @After
    public void tearDown() {
        // Quit the WebDriver instance after each test
        DriverFactory.quitDriver();
    	System.out.println();
    	System.out.println("############################### Execution stopped ##############################");
       System.out.println();
    }

}
