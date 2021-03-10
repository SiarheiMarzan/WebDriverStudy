package page_object2.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_object2.page.ResultPage2;
import page_object2.page.SignUpPage2;
import page_odject.page.ResultPage;

import java.util.concurrent.TimeUnit;

public class BringItOnTest2 {
    WebDriver driver;

    private SignUpPage2 signUpPage2 = new SignUpPage2();
    private ResultPage2 resultPage2 = new ResultPage2();

    @Test

    public void bringItOnMySecondTest() {


        signUpPage2.openPage();
        signUpPage2.enterCode("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force\n");
        signUpPage2.enterProgrammLanguage("Bash");
        signUpPage2.enterExpiration();
        signUpPage2.pastName("how to gain dominance among developers");


        WebElement expectedTitle = driver.findElement(By.xpath("//div[h1= 'how to gain dominance among developers']"));
        expectedTitle.getText();
        Assert.assertTrue(expectedTitle.equals("how to gain dominance among developers"));


    }

}
