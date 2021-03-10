package selenide.test;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenide.driver.ScreenPlusCode;
import selenide.selenide_page.CalculatorPage;
import selenide.selenide_page.EmailPage;
import selenide.selenide_page.StartCloudPage;

public class GoogleTest {

    CalculatorPage calculatorPage = new CalculatorPage();
    ScreenPlusCode screenPlusCode = new ScreenPlusCode();
    StartCloudPage startCloudPage = new StartCloudPage();
    EmailPage emailPage = new EmailPage();

    @BeforeMethod
    public void setup() {
        Configuration.browser = "Chrome";
        Configuration.startMaximized = true;
    }

    @Test
    public void cloudPage() {

        startCloudPage.open().cloudGoogleSearchInputMessageTransition("Google Cloud Platform Pricing Calculator");
        calculatorPage.openFormCompEngine().inputQuantity("4").selectingValueInForm().clickGpu()
                .choiseGpu().typeGpu().localSsd().centerLocation().addToEstimate();
        String costFromGooglePage = calculatorPage.saveCostEmailEstimated();
        calculatorPage.emailEstimate();
        emailPage.emailPostReturn();
        calculatorPage.clickEmptyField().openEmailForm().inputEmail();
        emailPage.openEmail();
        String costFromWorkingEmail = calculatorPage.estimatedMonthlyCostFromWorkingEmail();
        Assert.assertEquals(costFromGooglePage, costFromWorkingEmail, "shout be correct");
    }
}


//        open("https://cloud.google.com");
//        Robot r = null;
//        try {
//            r = new Robot();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//        r.keyPress(KeyEvent.VK_CONTROL);
//        r.keyPress(KeyEvent.VK_T);
//        r.keyRelease(KeyEvent.VK_CONTROL);
//        r.keyRelease(KeyEvent.VK_T);
//        switchTo().window(1);
//        open("https://10minutemail.com/");
//        switchTo().window(0);
//
//        $(By.xpath("//*[@class='devsite-search-field devsite-search-query']")).click();
//        $(By.xpath("//input[@placeholder='Search']")).click();
//        $(By.xpath("//input[@placeholder='Search']")).sendKeys("Google Cloud Platform Pricing Calculator" + Keys.ENTER);
//        $(By.xpath("//a[@class='gs-title']")).click();
//        switchTo().frame($(By.xpath("//iframe[contains(@src,'index')]")));
//        switchTo().frame($(By.id("myFrame")));
//        $(By.xpath("//div[@class='name ng-binding'][text()='Compute Engine']")).click();
//        $(By.xpath("//input[@name='quantity']")).click();
//        $(By.xpath("//*[@ng-model='listingCtrl.computeServer.quantity']")).sendKeys("4");
//        String first = String.format("//*[@placeholder = '%s']", "Series");
//        $(By.xpath(first)).click();
//        String second = String.format("//md-option[@value='%s']", "n1");
//        $(By.xpath(second)).click();
//        String third = String.format("//*[@placeholder = '%s']", "Instance type");
//        $(By.xpath(third)).click();
//        String fouth = String.format("//md-option[@value='%s']", "CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8");
//        $(By.xpath(fouth)).click();
//        $(By.xpath("//*[@ng-model='listingCtrl.computeServer.addGPUs']")).click();
//        $(By.xpath("//md-select[@placeholder='Number of GPUs']")).click();
//        $(By.xpath("//md-option[contains(@ng-repeat,'item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]')]/div[contains(text(),'1')]")).click();
//        $(By.xpath("//md-select[@placeholder='GPU type']")).click();
//        $(By.xpath("//md-option[@value='NVIDIA_TESLA_V100']")).click();
//        $(By.xpath("//md-select[@placeholder='Local SSD']")).click();
//        $(By.xpath("//md-option/div[contains(text(),'2x375 GB')]")).click();
//        $(By.xpath("//*[@placeholder='Datacenter location']")).click();
//        $$(By.xpath("//md-option/div[contains(text(),'Frankfurt (europe-west3')]")).get(2).click();
//        $(By.xpath("//md-select[@placeholder='Committed usage']")).click();
//        $(By.cssSelector("#select_option_96")).click();
//        $(By.xpath("//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")).click();
//        String costFromGooglePage = calculatorPage.saveCostEmailEstimated();
//        $(By.xpath("//button[contains(text(),'Email Estimate')]")).click();
//
//        switchTo().window(1);
//        $(By.xpath("//span[@class='copy_icon']")).click();
//        switchTo().window(0);
//
//        $(By.xpath("//body[@type='marketing']")).click();
//        switchTo().frame($(By.xpath("//iframe[contains(@src,'index')]")));
//        switchTo().frame($(By.id("myFrame")));
//        $(By.xpath("//button[contains(text(),'Email Estimate')]")).click();
//        $(By.xpath("//input[contains(@class, 'ng-valid-email')]")).click();
//
//        String myText = null;
//        try {
//            myText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
//        } catch (UnsupportedFlavorException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        $(By.xpath("//input[contains(@class, 'ng-valid-email')]")).sendKeys(myText);
//
//        $(By.xpath("//button[contains(text(),'Send Email')]")).click();
//
//        switchTo().window(1);
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        $(By.xpath("//span[@class='small_message_icon']")).click();
//
//        String costFromWorkingEmail = calculatorPage.estimatedMonthlyCostFromWorkingEmail();
//        Assert.assertEquals(costFromGooglePage, costFromWorkingEmail, "shout be correct");