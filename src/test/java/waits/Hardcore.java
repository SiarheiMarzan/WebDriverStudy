package waits;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Hardcore {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://cloud.google.com");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        searchInput.click();
        searchInput.sendKeys("Google Cloud Platform Pricing Calculator" + Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class='gs-title']")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'index')]")));
        driver.switchTo().frame(driver.findElement(By.id("myFrame")));

        driver.findElement(By.xpath("//div[@class='name ng-binding'][text()='Compute Engine']")).click();   //Активировать раздел COMPUTE ENGINE

        driver.findElement(By.xpath("//input[@name='quantity']")).click();
        WebElement searchInput1 = driver.findElement(By.xpath("//*[@ng-model='listingCtrl.computeServer.quantity']"));
        searchInput1.sendKeys("4");

        driver.findElement(By.xpath("//*[@placeholder = 'Series']")).click();
        driver.findElement(By.xpath("//md-option[@value='n1']")).click(); //N1

        driver.findElement(By.xpath("//*[@placeholder='Instance type']")).click();
        driver.findElement(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")).click(); //30GB

        driver.findElement(By.xpath("//*[@ng-model='listingCtrl.computeServer.addGPUs']")).click(); //button GPU

        driver.findElement(By.xpath("//md-select[@placeholder='Number of GPUs']")).click();
        driver.findElement(By.cssSelector("#select_option_398")).click(); //Number of GPUs: 1

        driver.findElement(By.xpath("//md-select[@placeholder='GPU type']")).click();
        driver.findElement(By.xpath("//md-option[@value='NVIDIA_TESLA_V100']")).click(); //GPU type: NVIDIA Tesla V100

        driver.findElement(By.xpath("//md-select[@placeholder='Local SSD']")).click();
        driver.findElement(By.xpath("//md-option/div[contains(text(),'2x375 GB')]")).click();  //2*375Gb

        driver.findElement(By.xpath("//*[@placeholder='Datacenter location']")).click();
        driver.findElements(By.xpath("//md-option/div[contains(text(),'Frankfurt (europe-west3')]")).get(2).click(); //Frankfurt

        driver.findElement(By.xpath("//md-select[@placeholder='Committed usage']")).click();
        driver.findElement(By.cssSelector("#select_option_95")).click(); //1 Year

        driver.findElement(By.xpath("//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")).click(); //button

        String cost = driver.findElement(By.xpath("//b[@class='ng-binding']")).getText();
        String[] expectedCost = cost.split(" ");

        driver.findElement(By.xpath("//button[contains(text(),'Email Estimate')]")).click();


        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement emailBCopy = driver.findElement(By.xpath("//span[@class='copy_icon']"));
        emailBCopy.click();
        driver.switchTo().window(tabs.get(0));

        driver.findElement(By.xpath("//body[@type='marketing']")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'index')]")));
        driver.switchTo().frame(driver.findElement(By.id("myFrame")));
        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Email Estimate')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.sendKeys(Keys.PAGE_UP);
        button.sendKeys(Keys.PAGE_UP);
        button.click();

       WebElement fieldInput =  driver.findElement(By.xpath("//input[contains(@class, 'ng-valid-email')]"));
       fieldInput.click();

        String myText = null;
        try {
            myText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        fieldInput.sendKeys(myText);

        driver.findElement(By.xpath("//button[contains(text(),'Send Email')]")).click();
        driver.switchTo().window(tabs.get(1));
        WebDriverWait wait = new WebDriverWait(driver, 600);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("inbox_count_number"),"1"));
        driver.findElement(By.xpath("//span[@class='small_message_icon']")).click();

        int d = 0;

//        String a = driver.findElement(By.xpath("//td[contains(text(),'USD 1,082.77')]")).getText();
//        String b[] = a.split(" ");
//        return b[1];
    }
}

