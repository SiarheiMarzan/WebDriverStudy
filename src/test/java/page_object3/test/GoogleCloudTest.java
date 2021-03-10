package page_object3.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page_object3.page.GoogleCalculatorPage;
import page_object3.page.GoogleCloudHomePage;

public class GoogleCloudTest {

    private GoogleCalculatorPage googleCalculatorPage = new GoogleCalculatorPage();
    private GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage();

    @Test

    public void googleCalculatorTest() {

        googleCalculatorPage.openPage();

        googleCalculatorPage.inputSearchField("Google Cloud Platform Pricing Calculator");

        googleCalculatorPage.searchResult();

        googleCalculatorPage.openIframe();

        googleCalculatorPage.sectionComputeEngine();

        googleCalculatorPage.numberOfInstances("4");


        googleCalculatorPage.choiceValue("Series","n1");
        googleCalculatorPage.choiceValue("Instance type","CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8");



        googleCalculatorPage.buttonGpu();

        googleCalculatorPage.choiceFieldNumberOne();

        googleCalculatorPage.gpuType();

        googleCalculatorPage.localSsd();

        googleCalculatorPage.choiceDatacenterLocation();

        googleCalculatorPage.choiceCommitedUsage();

        googleCalculatorPage.addEstimate();

        googleCalculatorPage.emailEstimate();

        SoftAssert softAssert = new SoftAssert();
    }

}


