import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class BringItOn {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://pastebin.com/");

        WebElement searchInput = driver.findElement(By.id("postform-text"));
        searchInput.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force\n");

        driver.findElement(By.xpath("//div[label='Syntax Highlighting:']")).click();
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Bash" + Keys.ENTER);

        driver.findElement(By.id("select2-postform-expiration-container")).click();
        driver.findElement(By.xpath("//li[text()='10 Minutes']")).click();

        driver.findElement(By.xpath("//div[label ='Paste Name / Title:']")).click();
        driver.findElement(By.id("postform-name")).sendKeys("how to gain dominance among developers" + Keys.ENTER);

        Thread.sleep(2000);
        driver.quit();

    }
}
