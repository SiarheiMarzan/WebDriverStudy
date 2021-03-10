import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelloWebDriver {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev");
        WebElement searchInput = driver.findElement(By.id("gsc-i-id1"));
        searchInput.sendKeys("selenium java");
        //WebElement searchBtn = driver.findElement(By.xpath(""));
        //searchBtn.click();
//        Thread.sleep(2000);
//        driver.quit();
        List<WebElement> searchBtn = driver.findElements(By.xpath(""));
        searchBtn.get(0).click();







    }
}
