package selenide_test2.page;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private SelenideElement clickSignInButton = $(By.id("gb_70"));
    private SelenideElement clickButtonLucky = $(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@class='RNmpXc']"));
    private SelenideElement clickImageButton = $(By.xpath("//a[@data-pid='2']"));
    private SelenideElement clickButtonGoogleApp = $(By.xpath("//div[@class='gb_C gb_dd gb_i']"));
    private SelenideElement iFrameElement = $(By.xpath("//iframe[@role='presentation']"));
    private SelenideElement clickButtonPlay = $(By.xpath("//span[contains(text(),'Play')]"));
    private SelenideElement clickButtonSearchByVoice = $(By.xpath("//div[@jscontroller='MC8mtf']"));

    @Given("^I (am on|navigate to|go to) the login page$")
    public void I_am_on_the_login_page(String action) throws MalformedURLException {
        String urlToRemoteWD = "http://localhost:4444/wd/hub";
        RemoteWebDriver driver =new RemoteWebDriver(new URL(urlToRemoteWD), DesiredCapabilities.chrome());
        WebDriverRunner.setWebDriver(driver);
        open("https://www.google.co.uk");
    }

    @When("^I navigate to login email page$")
    public void iNavigateToLoginPage() {
        clickSignInButton.click();
    }

    @When("^I click im feeling lucky button$")
    public void iClickImFeelingLuckyButton() {
        clickButtonLucky.click();
    }

    @When("I click image button")
    public void iClickImageButton() {
        clickImageButton.click();
    }

    @When("^I click google app button$")
    public void iClickGoogleAppButton() {
        clickButtonGoogleApp.click();
        switchTo().frame(iFrameElement);
    }

    @When("^I click play button in field app$")
    public void iClickPlayButtonInFieldApp() {
        clickButtonPlay.click();
    }

    @When("^I click search voice button$")
    public void iClickSearchVoiceButton() {
        clickButtonSearchByVoice.click();
    }
}
