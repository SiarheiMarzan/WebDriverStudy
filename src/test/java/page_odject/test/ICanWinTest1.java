package page_odject.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_odject.page.ResultPage;
import page_odject.page.SignUpPage;

public class ICanWinTest1 {

    private SignUpPage signUpPage = new SignUpPage();
    private ResultPage resultPage = new ResultPage();

    @Test(description = "Just first test, JIRA binding can be here")
    public void commonSearchTermResultsNotEmpty() {
        signUpPage.openPage();
        String pageTitle = signUpPage.getPageTitle();
        Assert.assertEquals(pageTitle, "Pastebin.com - #1 paste tool since 2002!", "Page title should be correct");

        signUpPage.enterCode("Hello from WebDriver");
        signUpPage.enterProgrammLanguage("Java");
        signUpPage.enterExpiration();
        signUpPage.pastName("helloweb");

        pageTitle = resultPage.getPageTitle();
        Assert.assertTrue(pageTitle.startsWith("helloweb"), "tittle shout be correct");
    }
}
