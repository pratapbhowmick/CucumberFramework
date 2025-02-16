package base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
        return driver;
    }

    public static void initDriver(Properties prop) {
        String browser = prop.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (Boolean.parseBoolean(prop.getProperty("headless"))) {
                options.addArguments("--headless");
            }
            driver=new ChromeDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();

        }
    }
}
