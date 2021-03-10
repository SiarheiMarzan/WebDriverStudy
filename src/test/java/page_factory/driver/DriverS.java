package page_factory.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverS {
    public static WebDriver driver;

    public static WebDriver getInstance(String browserName, String width, String height) {
        if (driver == null) {
            if (browserName.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            } else if (browserName.equalsIgnoreCase("Chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                if (System.getProperty("isHeadles").equalsIgnoreCase("true")) {
                    options.addArguments("--headless");
                }
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();

            } else {
                driver = new ChromeDriver((ChromeOptions) setParameters(browserName, width, height));
                driver.manage().window().setSize(new Dimension(516, 672));
            }

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static WebDriver getInstance() {
        return driver;
    }

    public static WebDriver setParameters(String browserName, String width, String height) {
        return getInstance(browserName, width, height);
    }

    public static void kill() {
        driver.quit();
        driver = null;
    }

}
