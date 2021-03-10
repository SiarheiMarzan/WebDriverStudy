package page_object4.page;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;


public class GoogleCloudPageFactory extends BasePageHard {

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement clickButtonSearch;
    @FindBy(xpath = "//a[@class='gs-title']")
    private WebElement clickStringSearchResult;
    @FindBy(xpath = "//iframe[contains(@src,'index')]")
    private WebElement entranceIframeFirst;
    @FindBy(id = "myFrame")
    private WebElement entranceIframeSecond;
    @FindBy(xpath = "//div[@class='name ng-binding'][text()='Compute Engine']")
    private WebElement clickButtonComputerEngine;
    @FindBy(xpath = "//input[@name='quantity']")
    private WebElement clickFieldInstanceAndInput;
    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement inputValueInInstance;
    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement clickCheckGpu;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement clickNumberOfGpus;
    @FindBy(css = "#select_option_398")
    private WebElement clickValueNumberOfGpus;
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement clickFieldTypeGpu;
    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement choiseAndClickTypeGpu;
    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement clickFieldLocalSsd;
    @FindBy(xpath = "//md-option/div[contains(text(),'2x375 GB')]")
    private WebElement clickValueLocalSsd;
    @FindBy(xpath = "//*[@placeholder='Datacenter location']")
    private WebElement clickFieldDataCenterLocation;
    //    @FindBy(xpath = "//md-option/div[contains(text(),'Frankfurt (europe-west3')]")
//    private WebElement clickValueDataCenterLocation;
    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement clickFieldCommitedUsage;
    @FindBy(css = "#select_option_95")
    private WebElement clickValueCommitedUsage;
    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement clickCheckAddToEstimate;
    @FindBy(xpath = "//button[contains(text(),'Email Estimate')]")
    private WebElement clickButtonEmailEstimate;
    @FindBy(xpath = "//span[@class='copy_icon']")
    private WebElement clickButtonCopyEmail;
    @FindBy(xpath = "//body[@type='marketing']")
    private WebElement clickEmptyFieldPage;
    @FindBy(xpath = "//input[contains(@class, 'ng-valid-email')]")
    private WebElement inputCopyInFieldEmail;
    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement clickButtonSendMail;
    @FindBy(xpath = "//span[@class='small_message_icon']")
    private WebElement clickButtonOpenEmail;

    private By clickValueDataCenterLocation = By.xpath("//md-option/div[contains(text(),'Frankfurt (europe-west3')]");

    public GoogleCloudPageFactory openPage() {
        driver.get("https://cloud.google.com/");
        return this;

    }

    public GoogleCloudPageFactory cloudGoogleSearch(String message) {
        clickButtonSearch.click();
        clickButtonSearch.sendKeys(message + Keys.ENTER);
        return this;
    }

    public GoogleCloudPageFactory moveSearhResult() {
        clickStringSearchResult.click();
        return this;
    }

    public GoogleCloudPageFactory getIframe() {
        driver.switchTo().frame(entranceIframeFirst);
        driver.switchTo().frame(entranceIframeSecond);
        return this;
    }

    public GoogleCloudPageFactory activeComputerEngine() {
        clickButtonComputerEngine.click();
        return this;
    }

    public GoogleCloudPageFactory activeInstancesAndInput(String number) {
        clickFieldInstanceAndInput.click();
        inputValueInInstance.sendKeys(number);
        return this;
    }

    public GoogleCloudPageFactory choiceValue(String holder, String option) {
        String first = String.format("//*[@placeholder = '%s']", holder);
        driver.findElement(By.xpath(first)).click();
        String second = String.format("//md-option[@value='%s']", option);
        driver.findElement(By.xpath(second)).click();
        return this;
    }

    public GoogleCloudPageFactory checkGpu() {
        clickCheckGpu.click();
        return this;
    }

    public GoogleCloudPageFactory choiseNumberOfGpus() {
        clickNumberOfGpus.click();
        clickValueNumberOfGpus.click();
        return this;
    }

    public GoogleCloudPageFactory typeGpu() {
        clickFieldTypeGpu.click();
        choiseAndClickTypeGpu.click();
        return this;
    }

    public GoogleCloudPageFactory choiseLocalSsd() {
        clickFieldLocalSsd.click();
        clickValueLocalSsd.click();
        return this;
    }

    public GoogleCloudPageFactory locationDataCenter() {
        clickFieldDataCenterLocation.click();
        driver.findElements(clickValueDataCenterLocation).get(2).click();
        return this;
    }

    public GoogleCloudPageFactory commitedUsage() {
        clickFieldCommitedUsage.click();
        clickValueCommitedUsage.click();
        return this;
    }

    public GoogleCloudPageFactory addToEstimate() {
        clickCheckAddToEstimate.click();
        return this;
    }

    public GoogleCloudPageFactory choiseEmailEstimate() {
        clickButtonEmailEstimate.click();
        return this;
    }

    public GoogleCloudPageFactory transitionNewPage() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public GoogleCloudPageFactory copyEmail() {
//        WebElement element = driver.findElement(By.xpath("//div[@id = 'copy_address']")); //Test1
//        String script = "var object = arguments[0];"
//                + "var theEvent = document.createEvent(\"MouseEvent\");"
//                + "theEvent.initMouseEvent(\"click\", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
//                + "object.dispatchEvent(theEvent);"
//                ;
//        ((JavascriptExecutor)driver).executeScript(script, element);
        WebElement emailBCopy = clickButtonCopyEmail;
        emailBCopy.click();
        return this;
    }

    public GoogleCloudPageFactory returnPageBack() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        return this;
    }

    public GoogleCloudPageFactory emailEstimateClick() {
        clickEmptyFieldPage.click();
        driver.switchTo().frame(entranceIframeFirst);
        driver.switchTo().frame(entranceIframeSecond);
        WebElement button = clickButtonEmailEstimate;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.sendKeys(Keys.PAGE_UP);
        button.sendKeys(Keys.PAGE_UP);
        button.click();
        return this;
    }

    public GoogleCloudPageFactory inputCopyEmail() {
        WebElement fieldInput = inputCopyInFieldEmail;
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

    public GoogleCloudPageFactory sendMail() {
        clickButtonSendMail.click();
        return this;
    }

    public GoogleCloudPageFactory transitPageToEmail() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public GoogleCloudPageFactory openEmail() {
        clickButtonOpenEmail.click();
        return this;
    }
}
