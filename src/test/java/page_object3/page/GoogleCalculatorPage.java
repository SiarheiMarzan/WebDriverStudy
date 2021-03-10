package page_object3.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class GoogleCalculatorPage extends AbstractPage {
    private By clickSearchButtonAndInputSearchField = By.xpath("//input[@placeholder='Search']");
    private By clickSearchResult = By.xpath("//a[@class='gs-title']");
    private By entranceIframeOne = By.xpath("//iframe[contains(@src,'index')]");
    private By entranceIframeTwo = By.id("myFrame");
    private By activeSectionComputeEngine = By.xpath("//div[@class='name ng-binding'][text()='Compute Engine']");
    private By inputInNumberOfInstances = By.xpath("//input[@name='quantity']");
    private By findFieldNumberOfInstance = By.xpath("//*[@ng-model='listingCtrl.computeServer.quantity']");
    private By clickButtonGpu = By.xpath("//*[@ng-model='listingCtrl.computeServer.addGPUs']");
    private By choiceNumberOne = By.xpath("//md-select[@placeholder='Number of GPUs']");
    private By clickValueNumberOne = By.cssSelector("#select_option_398");
    private By choiceGpuTypeField = By.xpath("//md-select[@placeholder='GPU type']");
    private By clickGpuType = By.xpath("//md-option[@value='NVIDIA_TESLA_V100']");
    private By clickFieldLocalSsd = By.xpath("//md-select[@placeholder='Local SSD']");
    private By choiseLocalSsd = By.xpath("//md-option/div[contains(text(),'2x375 GB')]");
    private By clickFieldDatacenterLocation = By.xpath("//*[@placeholder='Datacenter location']");
    private By choiceDatacenterLocation = By.xpath("//md-option/div[contains(text(),'Frankfurt (europe-west3')]");
    private By clickFieldCommitedUsage = By.xpath("//md-select[@placeholder='Committed usage']");
    private By choiceAndClickCommitedUsage = By.cssSelector("#select_option_95");
    private By clickButtonAddEstimate = By.xpath("//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']");
    private By clickButtonEmailEstimate = By.xpath("//button[contains(text(),'Email Estimate')]");
    public By elementPlaceholder = By.xpath("//*[@placeholder = 'Series']");
    private By elementValue = By.xpath("//md-option[@value='n1']");


    public GoogleCalculatorPage openPage() {
        driver.get("https://cloud.google.com/");
        return this;
    }


    public GoogleCalculatorPage inputSearchField(String message) {
        WebElement searchInput = driver.findElement(clickSearchButtonAndInputSearchField);
        searchInput.click();
        searchInput.sendKeys(message + Keys.ENTER);
        return this;
    }

    public GoogleCalculatorPage searchResult() {
        driver.findElement(clickSearchResult).click();
        return this;
    }

    public GoogleCalculatorPage openIframe() {
        driver.switchTo().frame(driver.findElement(entranceIframeOne));
        driver.switchTo().frame(driver.findElement(entranceIframeTwo));
        return this;
    }

    public GoogleCalculatorPage sectionComputeEngine() {
        driver.findElement(activeSectionComputeEngine).click();
        return this;
    }

    public GoogleCalculatorPage numberOfInstances(String number) {
        driver.findElement(inputInNumberOfInstances).click();
        WebElement searchInput = driver.findElement(findFieldNumberOfInstance);
        searchInput.sendKeys(number);
        return this;
    }

    public GoogleCalculatorPage choiceValue(String holder, String option){
        String first = String.format("//*[@placeholder = '%s']",holder);
        driver.findElement(By.xpath(first)).click();
        String second = String.format("//md-option[@value='%s']", option);
        driver.findElement(By.xpath(second)).click();
        return this;
    }


    public GoogleCalculatorPage buttonGpu() {
        driver.findElement(clickButtonGpu).click();
        return this;
    }

    public GoogleCalculatorPage choiceFieldNumberOne() {
        driver.findElement(choiceNumberOne).click();
        driver.findElement(clickValueNumberOne).click();
        return this;
    }

    public GoogleCalculatorPage gpuType() {
        driver.findElement(choiceGpuTypeField).click();
        driver.findElement(clickGpuType).click();
        return this;
    }

    public GoogleCalculatorPage localSsd() {
        driver.findElement(clickFieldLocalSsd).click();
        driver.findElement(choiseLocalSsd).click();
        return this;
    }

    public GoogleCalculatorPage choiceDatacenterLocation() {
        driver.findElement(clickFieldDatacenterLocation).click();
        driver.findElements(choiceDatacenterLocation).get(2).click();
        return this;
    }

    public GoogleCalculatorPage choiceCommitedUsage() {
        driver.findElement(clickFieldCommitedUsage).click();
        driver.findElement(choiceAndClickCommitedUsage).click();
        return this;
    }

    public GoogleCalculatorPage addEstimate() {
        driver.findElement(clickButtonAddEstimate).click();
        return this;
    }

    public GoogleCalculatorPage emailEstimate() {
        driver.findElement(clickButtonEmailEstimate).click();
        return this;
    }
}
