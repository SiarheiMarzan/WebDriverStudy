package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WedDriverSynsDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.selenium.dev");
        WebElement searchInput = driver.findElement(By.id("gsc-i-id1"));
        searchInput.sendKeys("selenium java");
        List<WebElement> searchBtn = driver.findElements(By.xpath("//*[@id=\"gs_cb50\"]"));
        searchBtn.get(0).click();


        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeToBe(searchInput, "class","abc"));
        driver.quit();




    }
}
