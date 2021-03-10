package page_factory.signUp;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.FindBy;
import page_factory.driver.CodePage;
import page_factory.driver.DriverS;
import page_factory.driver.Screenshots;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CalculatorGooglePage {

    WebDriver driver;
    CodePage codePage = initElements(DriverS.getInstance(), CodePage.class);
    Screenshots screenshots = initElements(DriverS.getInstance(), Screenshots.class);

    public CalculatorGooglePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//iframe[contains(@src,'index')]")
    private WebElement iFrameContains;

    @FindBy(id = "myFrame")
    private WebElement myIframe;

    @FindBy(xpath = "//div[@class='name ng-binding'][text()='Compute Engine']")
    private WebElement computeEngine;

    @FindBy(xpath = "//input[@name='quantity']")
    private WebElement nameQuantity;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement computeServerQuantity;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement checkAddGpu;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement popUpnumberGpus;

    @FindBy(xpath = "//md-option[contains(@ng-repeat,'item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]')]/div[contains(text(),'1')]")
    private WebElement chooseValue;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuType;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement nvidiaTeslaV;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement choiseLocalSsd;

    @FindBy(xpath = "//md-option/div[contains(text(),'2x375 GB')]")
    private WebElement twoThreeSevenFive;

    @FindBy(xpath = "//*[@placeholder='Datacenter location']")
    private WebElement dataCenter;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement commitUsage;

    @FindBy(css = "#select_option_96")
    private WebElement valueCommit;

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement clickAddToEstimate;

    @FindBy(xpath = "//button[contains(text(),'Email Estimate')]")
    private WebElement clickButton;

    @FindBy(xpath = "//body[@type='marketing']")
    private WebElement clickEmptyPlace;

    @FindBy(xpath = "//button[@class='md-button md-ink-ripple']")
    private WebElement clickCancel;

    @FindBy(xpath = "//button[contains(text(),'Email Estimate')]")
    private WebElement emailEstimatebutton;

    @FindBy(xpath = "//input[contains(@class, 'ng-valid-email')]")
    private WebElement inputFromBuffEmail;

    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement clickSendButton;

    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement chooseSeries;

    @FindBy(xpath = "//input[contains(@name,'ephemeralIpCount')]")
    private WebElement ephemeralIpCount;

    public CalculatorGooglePage openFormCompEngine() {
        driver.switchTo().frame(iFrameContains);
        driver.switchTo().frame(myIframe);
        computeEngine.click();
        return this;
    }

    public CalculatorGooglePage inputQuantity(String numberInstance) {
        nameQuantity.click();
        computeServerQuantity.sendKeys(numberInstance);
        return this;
    }

    public CalculatorGooglePage selectingValueInForm(String holder, String option) {
        String browsers = DriverS.getInstance().getClass().getName();
        if (browsers.equals("org.openqa.selenium.firefox.FirefoxDriver")) {
            WebElement webElement = chooseSeries;
            ((Locatable) webElement).getCoordinates();
            webElement.sendKeys(Keys.PAGE_DOWN);
        }

        String first = String.format("//*[@placeholder = '%s']", holder);
        driver.findElement(By.xpath(first)).click();

        if (browsers.equals("org.openqa.selenium.firefox.FirefoxDriver")) {
            WebElement webElement2 = ephemeralIpCount;
            ((Locatable) webElement2).getCoordinates();
            webElement2.sendKeys(Keys.PAGE_DOWN);
        }

        String second = String.format("//md-option[@value='%s']", option);
        driver.findElement(By.xpath(second)).click();
        return this;
    }

    public CalculatorGooglePage clickGpu() {
        checkAddGpu.click();
        return this;
    }

    public CalculatorGooglePage choiseGpu() {
        popUpnumberGpus.click();
        chooseValue.click();
        return this;
    }

    public CalculatorGooglePage typeGpu() {
        gpuType.click();
        nvidiaTeslaV.click();
        return this;
    }

    public CalculatorGooglePage localSsd() {
        String browsers = DriverS.getInstance().getClass().getName();
        if (browsers.equals("org.openqa.selenium.firefox.FirefoxDriver")) {
            WebElement webElement3 = driver.findElement(By.xpath("//input[contains(@name,'ephemeralIpCount')]"));
            ((Locatable) webElement3).getCoordinates();
            webElement3.sendKeys(Keys.PAGE_DOWN);
        }

        choiseLocalSsd.click();
        twoThreeSevenFive.click();
        return this;
    }

    public CalculatorGooglePage centerLocation() {
        String browsers = DriverS.getInstance().getClass().getName();
        if (browsers.equals("org.openqa.selenium.firefox.FirefoxDriver")) {
            WebElement webElement4 = driver.findElement(By.xpath("//input[contains(@name,'hours')]"));
            ((Locatable) webElement4).getCoordinates();
            webElement4.sendKeys(Keys.PAGE_DOWN);
        }

        dataCenter.click();
        driver.findElements(By.xpath("//md-option/div[contains(text(),'Frankfurt (europe-west3')]")).get(2).click();
        return this;
    }

    public CalculatorGooglePage commitedUsage() {
        String browsers = DriverS.getInstance().getClass().getName();
        if (browsers.equals("org.openqa.selenium.firefox.FirefoxDriver")) {
            WebElement webElement5 = driver.findElement(By.xpath("//input[contains(@name,'ephemeralIpCount')]"));
            ((Locatable) webElement5).getCoordinates();
            webElement5.sendKeys(Keys.PAGE_DOWN);
        }
        commitUsage.click();
        valueCommit.click();
        return this;
    }

    public CalculatorGooglePage addToEstimate() {
        clickAddToEstimate.click();
        return this;
    }

    public String saveCostEmailEstimated() {
        String cost = driver.findElement(By.xpath("//h2[@class='md-title']/b")).getText();
        String[] expectedCost = cost.split(" ");
        return expectedCost[4];

    }

    public CalculatorGooglePage emailEstimate() {
        clickButton.click();
        return this;
    }

    public CalculatorGooglePage clickEmptyField() {
        clickEmptyPlace.click();
        return this;
    }

    public CalculatorGooglePage findFieldInput() {
        driver.switchTo().frame(iFrameContains);
        driver.switchTo().frame(myIframe);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emailEstimatebutton);
        emailEstimatebutton.sendKeys(Keys.PAGE_UP);
        emailEstimatebutton.sendKeys(Keys.PAGE_UP);
        emailEstimatebutton.click();
        return this;
    }

    public CalculatorGooglePage inputEmail() {
        Integer windowSize = DriverS.driver.manage().window().getSize().width;
        if (windowSize <= 800) {
            WebElement webElement5 = inputFromBuffEmail;
            ((Locatable) webElement5).getCoordinates();
            webElement5.sendKeys(Keys.PAGE_UP);
        }
        inputFromBuffEmail.click();

        String myText = null;
        try {
            myText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputFromBuffEmail.sendKeys(myText);
        screenshots.captureScreenShot();
        codePage.captureCodePage();


        return this;
    }

    public CalculatorGooglePage sendEmail() {
        String browsers = DriverS.getInstance().getClass().getName();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (browsers.equals("org.openqa.selenium.firefox.FirefoxDriver")) {
            WebElement webElement5 = driver.findElement(By.xpath("//button[contains(text(),'Send Email')]"));
            ((Locatable) webElement5).getCoordinates();
            webElement5.sendKeys(Keys.PAGE_DOWN);
        }
        clickSendButton.click();

        return this;
    }

    public CalculatorGooglePage transitPageToEmail() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }
}

