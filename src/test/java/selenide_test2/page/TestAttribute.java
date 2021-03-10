package selenide_test2.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class TestAttribute {

    private SelenideElement clickSignInButton = $(By.id("gb_70"));
    private SelenideElement clickFieldInputEmail = $(By.xpath("//input[@type='email']"));
    private SelenideElement inputEmail = $(By.xpath("//input[@type='email']"));
    private SelenideElement clickNextButton = $(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
    private SelenideElement checkingField = $(By.xpath("//div[@class='o6cuMc']"));
    private SelenideElement checkingValueText = $(By.xpath("//div[@class='PrDSKc']"));
    private SelenideElement clickForgotEmailButton = $(By.xpath("//button[@jsname='Cuz2Ue']"));
    private SelenideElement checkingValueTextField = $(By.xpath("//div[@class='Y4dIwd']"));
    private SelenideElement clickButtonLucky = $(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@class='RNmpXc']"));
    private SelenideElement checkingVisibleElement = $(By.id("logo"));
    private SelenideElement clickImageButton = $(By.xpath("//a[@data-pid='2']"));
    private SelenideElement checkingValuePageImage = $(By.xpath("//div[@class='logo-subtext']"));
    private SelenideElement checkingVisibleElementSearchImage = $(By.xpath("//span[@class='BwoPOe']"));
    private SelenideElement checkingVisibleElementSearchVoice = $(By.xpath("//div[@jscontroller='MC8mtf']"));
    private SelenideElement clickSearchImageButton = $(By.xpath("//div[@jscontroller='TJw5qb']"));
    private SelenideElement checkingFieldUrl = $(By.id("cjyo4e"));
    private SelenideElement checkingButtonUploadImage = $(By.xpath("//a[@class='iOGqzf H4qWMc aXIg1b']"));
    private SelenideElement clickButtonGoogleApp = $(By.xpath("//div[@class='gb_C gb_dd gb_i']"));
    private SelenideElement iFrameElement = $(By.xpath("//iframe[@role='presentation']"));
    private SelenideElement checkingVisibleFieldChoiceApp = $(By.xpath("//div[@class='EHzcec eejsDc']"));
    private SelenideElement clickButtonPlay = $(By.xpath("//span[contains(text(),'Play')]"));
    private SelenideElement choiseRedirectedPage = $(By.xpath("//div[@class='gb_pc']"));
    private SelenideElement clickButtonSearchByVoice = $(By.xpath("//div[@jscontroller='MC8mtf']"));

    public void checkingInvalidEmail(String message) {
        clickSignInButton.click();
        clickFieldInputEmail.click();
        inputEmail.sendKeys("testing.testing2003@");
        clickNextButton.click();
        checkingField.shouldHave(text("Введите адрес электронной почты или номер телефона."));
    }

    public void checkingNonExistentInDbEmail() {
        clickSignInButton.click();
        clickFieldInputEmail.click();
        inputEmail.sendKeys("testing.testingnon-existent2003@gmail.com");
        clickNextButton.click();
        checkingField.shouldHave(text("Не удалось найти аккаунт Google"));
    }

    public void checkingExistentEmail() {
        clickSignInButton.click();
        clickFieldInputEmail.click();
        inputEmail.sendKeys("testing.testing2003@gmail.com");
        clickNextButton.click();
        checkingValueText.shouldHave(text("Возможно, этот браузер или приложение небезопасны. "));
    }

    public void forgotEmail() {
        clickSignInButton.click();
        clickForgotEmailButton.click();
        checkingValueTextField.shouldHave(text("Укажите номер телефона или резервный адрес электронной почты"));
    }

    public void checkingButtonLucky() {
        clickButtonLucky.click();
        checkingVisibleElement.shouldBe(appear);
    }

    public void checkingShowLabelAndLogo() {
        clickImageButton.click();
        checkingValuePageImage.shouldHave(text("Картинки"));
        checkingVisibleElementSearchImage.shouldBe(appear);
        checkingVisibleElementSearchVoice.shouldBe(appear);
        clickSearchImageButton.click();
        checkingFieldUrl.shouldBe(appear);
        checkingButtonUploadImage.shouldBe(appear);
    }

    public void checkingButtonGoogleApp() {
        clickButtonGoogleApp.click();
        switchTo().frame(iFrameElement);
        checkingVisibleFieldChoiceApp.shouldBe(appear);
        clickButtonPlay.click();
        choiseRedirectedPage.shouldBe(appear);
    }

    public void checkingButtonSearchByVoice() {

        clickButtonSearchByVoice.click();
    }
}
