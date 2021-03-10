package page_object4.driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver driver;
    public static WebDriver getInstance() {
        if (driver == null) {
            driver = new ChromeDriver();
            //driver.manage().window().setSize(new Dimension(400, 672));
             driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void kill() {
        getInstance().quit();
    }
}
