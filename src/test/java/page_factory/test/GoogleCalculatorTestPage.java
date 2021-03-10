package page_factory.test;

import org.testng.Assert;
import org.testng.annotations.*;
import page_factory.driver.CodePage;
import page_factory.driver.DriverS;
import page_factory.driver.Screenshots;
import page_factory.signUp.CloudGooglePage;
import page_factory.signUp.CalculatorGooglePage;
import page_factory.signUp.EmailPage;

import java.io.IOException;

import static org.openqa.selenium.support.PageFactory.initElements;

public class GoogleCalculatorTestPage {

    @BeforeMethod
    @Parameters({"browserName", "width", "height"})
    public void start(String browserName, String width, String height){
        DriverS.setParameters(browserName, width, height);
    }

    @Test
    public void signUp() throws IOException {

        CodePage codePage = initElements(DriverS.getInstance(), CodePage.class);
        EmailPage emailPage = initElements(DriverS.getInstance(), EmailPage.class);
        Screenshots screenshots = initElements(DriverS.getInstance(), Screenshots.class);
        CloudGooglePage cloudGooglePage = initElements(DriverS.getInstance(), CloudGooglePage.class);

        cloudGooglePage.open();
        cloudGooglePage.cloudGoogleSearchInputMessageTransition("Google Cloud Platform Pricing Calculator");
        CalculatorGooglePage calculatorGooglePage = initElements(DriverS.getInstance(), CalculatorGooglePage.class);
        calculatorGooglePage.openFormCompEngine();
        calculatorGooglePage.inputQuantity("4")
                .selectingValueInForm("Series", "n1")
//                .selectingValueInForm("Series", series)
//                .selectingValueInForm("Instance type", machineType)
                .selectingValueInForm("Instance type", "CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8")
                .clickGpu();
        calculatorGooglePage.choiseGpu().typeGpu().localSsd().centerLocation().commitedUsage().addToEstimate();
        String costFromGooglePage = calculatorGooglePage.saveCostEmailEstimated();
        calculatorGooglePage.emailEstimate();
        emailPage.pageEmail();
        emailPage.clickCopyButtonAndReturnToPreviousPage();
        calculatorGooglePage.clickEmptyField()
                .findFieldInput().inputEmail();
        calculatorGooglePage.sendEmail();
        calculatorGooglePage.transitPageToEmail();
        emailPage.waitEmailAndLook();
        String costFromWorkingEmail = emailPage.estimatedMonthlyCostFromWorkingEmail();
        Assert.assertEquals(costFromGooglePage, costFromWorkingEmail, "shout be correct");

    }

    @AfterMethod
    public void finish() {
        DriverS.kill();
    }


    @DataProvider(parallel = false)
    public Object[][] getData() {
        return new Object[][]{
                {"n1", "CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8"},
                //{"n2", "CP-COMPUTEENGINE-VMIMAGE-N2-STANDARD-2"}
        };
    }
}