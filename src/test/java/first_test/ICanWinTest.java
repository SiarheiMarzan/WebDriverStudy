package first_test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ICanWinTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test(description = "Just first test, JIRA binding can be here")
    public void commonSearchTermResultsNotEmpty() {

        driver.manage().window().maximize();

        driver.get("https://pastebin.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getTitle(),"Pastebin.com - #1 paste tool since 2002!");

        WebElement searchInput = driver.findElement(By.id("postform-text"));
        searchInput.sendKeys("Hello from WebDriver");

        driver.findElement(By.xpath("//div[label='Syntax Highlighting:']")).click();
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Java" + Keys.ENTER);

        driver.findElement(By.id("select2-postform-expiration-container")).click();
        driver.findElement(By.xpath("//li[text()='10 Minutes']")).click();

        driver.findElement(By.xpath("//div[label ='Paste Name / Title:']")).click();
        driver.findElement(By.id("postform-name")).sendKeys("helloweb" + Keys.ENTER);
        //int d = 0;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement web=driver.findElement(By.id("postform-name"));
        boolean bool=web.isDisplayed();
        Assert.assertEquals(true, bool);

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
