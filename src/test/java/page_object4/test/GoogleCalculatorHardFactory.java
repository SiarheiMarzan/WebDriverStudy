package page_object4.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page_object4.page.GoogleCloudPage;
import page_object4.page.GoogleCloudPageFactory;
import page_object4.page.ResultGooglePage;

public class GoogleCalculatorHardFactory {
    private GoogleCloudPageFactory googleCloudPageFactory = new GoogleCloudPageFactory();
    private ResultGooglePage resultGooglePage = new ResultGooglePage();

    @Test
    public void googleCalculatorHardTest() {

        googleCloudPageFactory.openPage().cloudGoogleSearch("Google Cloud Platform Pricing Calculator").moveSearhResult().
                getIframe().activeComputerEngine().activeInstancesAndInput("4").choiceValue("Series", "n1").
                choiceValue("Instance type", "CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8").checkGpu().
                choiseNumberOfGpus().choiseNumberOfGpus().typeGpu().choiseLocalSsd().locationDataCenter().
                commitedUsage().addToEstimate().choiseEmailEstimate().transitionNewPage().copyEmail().returnPageBack().
                emailEstimateClick().inputCopyEmail().sendMail().transitPageToEmail().openEmail();
    }

}

