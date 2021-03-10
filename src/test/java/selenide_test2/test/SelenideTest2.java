package selenide_test2.test;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import selenide_test2.page.*;

import static com.codeborne.selenide.Selenide.open;

public class SelenideTest2 {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    CheckingPage checkingPage = new CheckingPage();
    GoogleImagesPage googleImagesPage = new GoogleImagesPage();

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        Configuration.browser = "Chrome";
        Configuration.startMaximized = true;
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        open("https://www.google.co.uk");
    }

    @Test
    public void enterInvalidEmail() {
        homePage.iNavigateToLoginPage();
        loginPage.iEnterTheFollowingForLogin("testing.testing2003@");
        loginPage.iClickNextButton();
        checkingPage.iShouldSeeTheNextText("Введите адрес электронной почты или номер телефона.");
    }

    @Test
    public void enterNonExistentDbEmail() {
        homePage.iNavigateToLoginPage();
        loginPage.iEnterTheFollowingForLogin("testing.testingnon-existent2003@gmail.com");
        loginPage.iClickNextButton();
        checkingPage.iShouldSeeTheNextText("Не удалось найти аккаунт Google");
    }

    @Test
    public void enterValidateEmail() {
        homePage.iNavigateToLoginPage();
        loginPage.iEnterTheFollowingForLogin("testing.testing2003@gmail.com");
        loginPage.iClickNextButton();
        checkingPage.iShouldSeeTheNextText("Возможно, этот браузер или приложение небезопасны. ");
    }

    @Test
    public void whenForgotEmail() {
        homePage.iNavigateToLoginPage();
        loginPage.iClickForgotEmailButton();
        checkingPage.iShouldSeeText("Укажите номер телефона или резервный адрес электронной почты");
    }

    @Test
    public void checkingLogoPage() {
        homePage.iClickImFeelingLuckyButton();
        checkingPage.iShouldSeeArchiveLinkDoodles("Архив дудлов");
    }

    @Test
    public void verifyVisibleElement() {
        homePage.iClickImageButton();
        checkingPage.iShouldSeeOnGoogleImagePageText("Картинки");
        checkingPage.iShouldSeeOnGoogleImagePageElementSearchImage();
        checkingPage.iShouldSeeOnGoogleImagePageElementSearchVoice();
        googleImagesPage.iClickSearchImageButton();
        checkingPage.iShouldSeeTabPastImageUrl("Указать ссылку");
        checkingPage.iShouldSeeTabUploadAnImage("Загрузить файл");
    }

    @Test
    public void verifyGoogleApp() {
        homePage.iClickGoogleAppButton();
        checkingPage.iShouldSeeFieldChoiceApp();
        homePage.iClickPlayButtonInFieldApp();
        checkingPage.iShouldSeeHttpPlayGoogleCom("https://play.google.com/store");
    }

    @Test
    public void checkingButtonVoice() {
        homePage.iClickSearchVoiceButton();
        checkingPage.iShouldSeeMicrophoneButton();
    }
}
