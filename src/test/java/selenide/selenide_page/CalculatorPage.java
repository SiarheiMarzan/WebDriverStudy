package selenide.selenide_page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;

public class CalculatorPage {

    private SelenideElement iFrameContains = $(By.xpath("//iframe[contains(@src,'index')]"));
    private SelenideElement myIframe = $(By.id("myFrame"));
    private SelenideElement computeEngine = $(By.xpath("//div[@class='name ng-binding'][text()='Compute Engine']"));
    private SelenideElement nameQuantity = $(By.xpath("//input[@name='quantity']"));
    private SelenideElement computeServerQuantity = $(By.xpath("//*[@ng-model='listingCtrl.computeServer.quantity']"));
    private SelenideElement checkAddGpu = $(By.xpath("//*[@ng-model='listingCtrl.computeServer.addGPUs']"));
    private SelenideElement popUpnumberGpus = $(By.xpath("//md-select[@placeholder='Number of GPUs']"));
    private SelenideElement chooseValue = $(By.xpath("//md-option[contains(@ng-repeat,'item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]')]/div[contains(text(),'1')]"));
    private SelenideElement gpuType = $(By.xpath("//md-select[@placeholder='GPU type']"));
    private SelenideElement nvidiaTeslaV = $(By.xpath("//md-option[@value='NVIDIA_TESLA_V100']"));
    private SelenideElement choiseLocalSsd = $(By.xpath("//md-select[@placeholder='Local SSD']"));
    private SelenideElement twoThreeSevenFive = $(By.xpath("//md-option/div[contains(text(),'2x375 GB')]"));
    private SelenideElement dataCenter = $(By.xpath("//*[@placeholder='Datacenter location']"));
    private SelenideElement locationPlace = $$(By.xpath("//md-option/div[contains(text(),'Frankfurt (europe-west3')]")).get(2);
    private SelenideElement commitUsage = $(By.xpath("//md-select[@placeholder='Committed usage']"));
    private SelenideElement valueCommit = $(By.cssSelector("#select_option_96"));
    private SelenideElement clickAddToEstimate = $(By.xpath("//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']"));
    private SelenideElement clickButton = $(By.xpath("//button[contains(text(),'Email Estimate')]"));
    private SelenideElement clickEmptyPlace = $(By.xpath("//body[@type='marketing']"));
    private SelenideElement emailEstimatebutton = $(By.xpath("//button[contains(text(),'Email Estimate')]"));
    private SelenideElement inputFromBuffEmail = $(By.xpath("//input[contains(@class, 'ng-valid-email')]"));
    private SelenideElement clickSendButton = $(By.xpath("//button[contains(text(),'Send Email')]"));

    public CalculatorPage openFormCompEngine() {
        switchTo().frame(iFrameContains);
        switchTo().frame(myIframe);
        computeEngine.click();
        return this;
    }

    public CalculatorPage inputQuantity(String numberInstance) {
        nameQuantity.click();
        computeServerQuantity.sendKeys(numberInstance);
        return this;
    }

    public CalculatorPage selectingValueInForm() {
        String first = String.format("//*[@placeholder = '%s']", "Series");
        $(By.xpath(first)).click();
        String second = String.format("//md-option[@value='%s']", "n1");
        $(By.xpath(second)).click();
        String third = String.format("//*[@placeholder = '%s']", "Instance type");
        $(By.xpath(third)).click();
        String fouth = String.format("//md-option[@value='%s']", "CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8");
        $(By.xpath(fouth)).click();
        return this;
    }

    public CalculatorPage clickGpu() {
        checkAddGpu.click();
        return this;
    }

    public CalculatorPage choiseGpu() {
        popUpnumberGpus.click();
        chooseValue.click();
        return this;
    }

    public CalculatorPage typeGpu() {
        gpuType.click();
        nvidiaTeslaV.click();
        return this;
    }

    public CalculatorPage localSsd() {
        choiseLocalSsd.click();
        twoThreeSevenFive.click();
        return this;
    }

    public CalculatorPage centerLocation() {
        dataCenter.click();
        locationPlace.click();
        return this;
    }

    public CalculatorPage commitedUsage() {
        commitUsage.click();
        valueCommit.click();
        return this;
    }

    public String saveCostEmailEstimated() {
        String cost = $(By.xpath("//h2[@class='md-title']/b")).getText();
        String[] expectedCost = cost.split(" ");
        return expectedCost[4];
    }

    public String estimatedMonthlyCostFromWorkingEmail() {
        String third = $(By.xpath("//td/h3[text()='USD 1,288.71']")).getText();
        String[] thirdValue = third.split(" ");
        return thirdValue[1];
    }

    public CalculatorPage addToEstimate() {
        clickAddToEstimate.click();
        return this;
    }

    public CalculatorPage emailEstimate() {
        clickButton.click();
        return this;
    }

    public CalculatorPage clickEmptyField() {
        clickEmptyPlace.click();
        return this;
    }

    public CalculatorPage openEmailForm() {
        switchTo().frame(iFrameContains);
        switchTo().frame(myIframe);
        emailEstimatebutton.click();
        inputFromBuffEmail.click();
        return this;
    }

    public CalculatorPage inputEmail() {
        String myText = null;
        try {
            myText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputFromBuffEmail.sendKeys(myText);
        clickSendButton.click();
        switchTo().window(1);
        return this;
    }
}