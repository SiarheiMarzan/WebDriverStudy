package page_object4.page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import page_object4.driver.Driver;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

import static org.openqa.selenium.Keys.PAGE_DOWN;

public class GoogleCloudPage extends BasePageHard {
    //private By clickButtonSearch = By.xpath("//input[@placeholder='Search']");
    private By clickButtonSearch = By.xpath("//button[contains(@aria-label,'Open search')]");
    private By inputTextSearchValue = By.xpath("//input[@placeholder='Search']");
    private By clickStringSearchResult = By.xpath("//a[@class='gs-title']");
    private By entranceIframeFirst = By.xpath("//iframe[contains(@src,'index')]");
    private By entranceIframeSecond = By.id("myFrame");
    private By clickButtonComputerEngine = By.xpath("//div[@class='name ng-binding'][text()='Compute Engine']");
    private By clickFieldInstanceAndInput = By.xpath("//input[@name='quantity']");
    private By inputValueInInstance = By.xpath("//*[@ng-model='listingCtrl.computeServer.quantity']");
    private By clickCheckGpu = By.xpath("//*[@ng-model='listingCtrl.computeServer.addGPUs']");
    private By clickNumberOfGpus = By.xpath("//md-select[@placeholder='Number of GPUs']");
    private By clickValueNumberOfGpus = By.cssSelector("#select_option_398");
    private By clickFieldTypeGpu = By.xpath("//md-select[@placeholder='GPU type']");
    private By choiseAndClickTypeGpu = By.xpath("//md-option[@value='NVIDIA_TESLA_V100']");
    private By clickFieldLocalSsd = By.xpath("//md-select[@placeholder='Local SSD']");
    private By clickValueLocalSsd = By.xpath("//md-option/div[contains(text(),'2x375 GB')]");
    private By clickFieldDataCenterLocation = By.xpath("//*[@placeholder='Datacenter location']");
    private By clickValueDataCenterLocation = By.xpath("//md-option/div[contains(text(),'Frankfurt (europe-west3')]");
    private By clickFieldCommitedUsage = By.xpath("//md-select[@placeholder='Committed usage']");
    private By clickValueCommitedUsage = By.cssSelector("#select_option_95");
    private By clickCheckAddToEstimate = By.xpath("//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']");
    private By clickButtonEmailEstimate = By.xpath("//button[contains(text(),'Email Estimate')]");
    private By clickButtonCopyEmail = By.xpath("//span[@class='copy_icon']");
    private By clickEmptyFieldPage = By.xpath("//body[@type='marketing']");
    private By clickButtonSendMail = By.xpath("//button[contains(text(),'Send Email')]");
    private By clickButtonOpenEmail = By.xpath("//span[@class='small_message_icon']");


    public GoogleCloudPage openPage() {
        driver.get("https://cloud.google.com/");
        return this;

    }

    public GoogleCloudPage cloudGoogleSearch(String message) {
       // WebElement searchInput = driver.findElement(clickButtonSearch);
        driver.findElement(clickButtonSearch).click();
        WebElement searchInput = driver.findElement(inputTextSearchValue);
        searchInput.click();
        searchInput.sendKeys(message + Keys.ENTER);
        return this;
    }

    public GoogleCloudPage moveSearhResult() {
        driver.findElement(clickStringSearchResult).click();
        return this;
    }

    public GoogleCloudPage getIframe() {
        driver.switchTo().frame(driver.findElement(entranceIframeFirst));
        driver.switchTo().frame(driver.findElement(entranceIframeSecond));
        return this;
    }

    public GoogleCloudPage activeComputerEngine() {
        driver.findElement(clickButtonComputerEngine).click();
        return this;
    }

    public GoogleCloudPage activeInstancesAndInput(String number) {
        driver.findElement(clickFieldInstanceAndInput).click();
        WebElement searchInput1 = driver.findElement(inputValueInInstance);
        searchInput1.sendKeys(number);
        return this;
    }

    public GoogleCloudPage choiceValue(String holder, String option) {
        String first = String.format("//*[@placeholder = '%s']", holder);
        driver.findElement(By.xpath(first)).click();
        String second = String.format("//md-option[@value='%s']", option);
        driver.findElement(By.xpath(second)).click();
        return this;
    }

    public GoogleCloudPage checkGpu() {
        driver.findElement(clickCheckGpu).click();
        return this;
    }

    public GoogleCloudPage choiseNumberOfGpus() {
        driver.findElement(clickNumberOfGpus).click();
        driver.findElement(clickValueNumberOfGpus).click();
        return this;
    }

    public GoogleCloudPage typeGpu() {
        driver.findElement(clickFieldTypeGpu).click();
        driver.findElement(choiseAndClickTypeGpu).click();
        return this;
    }

    public GoogleCloudPage choiseLocalSsd() {
        driver.findElement(clickFieldLocalSsd).click();
        driver.findElement(clickValueLocalSsd).click();
        return this;
    }

    public GoogleCloudPage locationDataCenter() {
        driver.findElement(clickFieldDataCenterLocation).click();
        driver.findElements(clickValueDataCenterLocation).get(2).click();
        return this;
    }

    public GoogleCloudPage commitedUsage() {
        driver.findElement(clickFieldCommitedUsage).click();
        driver.findElement(clickValueCommitedUsage).click();
        return this;
    }

    public GoogleCloudPage addToEstimate() {
        driver.findElement(clickCheckAddToEstimate).click();
        return this;
    }

    public GoogleCloudPage choiseEmailEstimate() {
        driver.findElement(clickButtonEmailEstimate).click();
        return this;
    }

    public GoogleCloudPage transitionNewPage() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.com");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public GoogleCloudPage copyEmail() {
        WebDriver driver = Driver.getInstance();
        Actions actionProvider = new Actions(driver);
        Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("c").build();
        keydown.perform();
//        WebElement emailBCopy = driver.findElement(clickButtonCopyEmail);
//        emailBCopy.click();
        return this;
    }

    public GoogleCloudPage returnPageBack() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        return this;
    }

    public GoogleCloudPage emailEstimateClick() {
        driver.findElement(clickEmptyFieldPage).click();
        driver.switchTo().frame(driver.findElement(entranceIframeFirst));
        driver.switchTo().frame(driver.findElement(entranceIframeSecond));
        WebElement button = driver.findElement(clickButtonEmailEstimate);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.sendKeys(Keys.PAGE_UP);
        button.sendKeys(Keys.PAGE_UP);
        button.click();
        return this;
    }

    public GoogleCloudPage inputCopyEmail() {
        WebElement fieldInput = driver.findElement(By.xpath("//input[contains(@class, 'ng-valid-email')]"));
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
        return this;
    }

    public GoogleCloudPage sendMail() {
        driver.findElement(clickButtonSendMail).click();
        return this;
    }

    public GoogleCloudPage transitPageToEmail() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public GoogleCloudPage openEmail() {
        driver.findElement(clickButtonOpenEmail).click();
        return this;
    }
}
