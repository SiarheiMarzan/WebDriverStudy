package selenide_test2.page;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CheckingPage {
    private SelenideElement checkingField = $(By.xpath("//div[@class='o6cuMc']"));
    private SelenideElement checkingValueTextField = $(By.xpath("//div[@class='Y4dIwd']"));
    private SelenideElement checkingLogoPage = $(By.xpath("//a[@id='archive-link-link']"));
    private SelenideElement checkingValuePageImage = $(By.xpath("//div[@class='logo-subtext']"));
    private SelenideElement checkingVisibleElementSearchImage = $(By.xpath("//span[@class='BwoPOe']"));
    private SelenideElement checkingVisibleElementSearchVoice = $(By.xpath("//div[@jscontroller='MC8mtf']"));
    private SelenideElement checkingFieldUrl = $(By.id("cjyo4e"));
    private SelenideElement checkingButtonUploadImage = $(By.xpath("//a[@class='iOGqzf H4qWMc aXIg1b']"));
    private SelenideElement checkingVisibleFieldChoiceApp = $(By.xpath("//div[@class='EHzcec eejsDc']"));
    private SelenideElement choiceRedirectedPage = $(By.xpath("//a[@class='gb_ue gb_qc gb_se']"));
    private SelenideElement microphoneButton = $(By.xpath("//span[@class='button']"));
    private SelenideElement checkingString = $(By.xpath("//h1[@class='ahT6S ']"));

    @Then("^I should see the next text$")
    public void iShouldSeeTheNextText(String message) {
        checkingField.shouldHave(text(message));
    }

    @Then("^I should see the text$")
    public void iShouldSeeTheText(String message) {
        checkingString.shouldHave(text("Не удалось войти в аккаунт"));
    }

    @Then("^I should see text$")
    public void iShouldSeeText(String message) {
        checkingValueTextField.shouldHave(text(message));
    }

    @Then("^I should see archive link doodles$")
    public void iShouldSeeArchiveLinkDoodles(String message) {
        checkingLogoPage.shouldHave(text(message));
    }

    @Then("^I should see on google image page text$")
    public void iShouldSeeOnGoogleImagePageText(String message) {
        checkingValuePageImage.shouldHave(text(message));
    }

    @Then("^I should see on google image page element search image$")
    public void iShouldSeeOnGoogleImagePageElementSearchImage() {
        checkingVisibleElementSearchImage.shouldBe(appear);
    }

    @Then("^I should see on google image page element search voice$")
    public void iShouldSeeOnGoogleImagePageElementSearchVoice() {
        checkingVisibleElementSearchVoice.shouldBe(appear);
    }

    @Then("^I should see tab past image url$")
    public void iShouldSeeTabPastImageUrl(String message) {
        checkingFieldUrl.shouldHave(text(message));
    }

    @Then("^I should see tab upload an image$")
    public void iShouldSeeTabUploadAnImage(String message) {
        checkingButtonUploadImage.shouldHave(text(message));
    }

    @Then("^I should see field choice app$")
    public void iShouldSeeFieldChoiceApp() {
        checkingVisibleFieldChoiceApp.shouldBe(appear);
    }

    @Then("^I should see http play google com$")
    public void iShouldSeeHttpPlayGoogleCom(String message) {
        choiceRedirectedPage.shouldBe(href(message));
    }

    @Then("^I should see microphone button$")
    public void iShouldSeeMicrophoneButton() {
        microphoneButton.shouldBe(id("spchb"));
    }

    @Then("^I should see the next text email \"([^\"]*)\"$")
    public void iShouldSeeTheNextTextEmail(String message) {
        checkingField.shouldHave(text(message));
    }
}
