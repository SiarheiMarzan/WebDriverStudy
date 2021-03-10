package page_object3.test;

import org.testng.annotations.Test;
import page_object3.page.GoogleCalculatorPage;
import page_object3.page.GoogleCloudHomePage;

public class GoogleCloudTest_chain {

    private GoogleCalculatorPage googleCalculatorPage = new GoogleCalculatorPage();
    private GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage();

    @Test

    public void googleCalculatorTest() {

        googleCalculatorPage.openPage().inputSearchField("Google Cloud Platform Pricing Calculator").
                searchResult().openIframe().sectionComputeEngine().numberOfInstances("4").
                choiceValue("Series", "n1").
                choiceValue("Instance type", "CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8").
                buttonGpu().choiceFieldNumberOne().gpuType().localSsd().choiceDatacenterLocation().
                choiceCommitedUsage().addEstimate().emailEstimate();
    }

}


