package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HurtMePlenty {
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

        driver.findElement(By.xpath("//*[@placeholder = 'Series']")).click();//создать метод 2 аргумента входных
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


        driver.findElement(By.xpath("//button[contains(text(),'Email Estimate')]")).click();
        driver.switchTo().defaultContent();

        String ActualText = driver.findElement(By.xpath("//span/div[contains(text(),'Regular')]")).getText();
        String ExpectedText = "Regular";
        Assert.assertEquals(ActualText, ExpectedText,"assert field VM");


        //h2[contains(text(),'Estimated Monthly Cost: USD 1,082.77')]
    }
}

