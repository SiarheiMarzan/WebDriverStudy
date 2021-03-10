package selenide_test2.page;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement clickFieldInputEmail = $(By.xpath("//input[@type='email']"));
    private SelenideElement inputEmail = $(By.xpath("//input[@type='email']"));
    private SelenideElement clickNextButton = $(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
    private SelenideElement clickForgotEmailButton = $(By.xpath("//button[@jsname='Cuz2Ue']"));

    @And("^I enter the following for Login \"([^\"]*)\"$")
    public void iEnterTheFollowingForLogin(String message) {
        clickFieldInputEmail.click();
        inputEmail.sendKeys(message);
    }

    @And("^I click next button$")
    public void iClickNextButton() {
        clickNextButton.click();
    }

    @And("^I click forgot email button$")
    public void iClickForgotEmailButton() {
        clickForgotEmailButton.click();
    }

    @And("^I enter the following for Login email \"([^\"]*)\"$")
    public void iEnterTheFollowingForLoginEmail(String message) {
        clickFieldInputEmail.click();
        inputEmail.sendKeys(message);
    }
}
