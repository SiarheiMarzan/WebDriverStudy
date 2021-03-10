package page_factory.signUp;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_factory.driver.CodePage;
import page_factory.driver.DriverS;
import page_factory.driver.Screenshots;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.support.PageFactory.initElements;

public class CloudGooglePage {
    WebDriver driver;
    CodePage codePage = initElements(DriverS.getInstance(), CodePage.class);
    Screenshots screenshots = initElements(DriverS.getInstance(), Screenshots.class);

    public CloudGooglePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//button[contains(@aria-label,'Open search')]")
    private WebElement clickSearchButtonInMobile;

    @FindBy(xpath = "//*[@class='devsite-search-field devsite-search-query']")
    private WebElement clickSearchButton;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement inputTextSearchValue;


    @FindBy(xpath = "//a[@class='gs-title']")
    private WebElement clickValueString;

    public CloudGooglePage open() {
        Selenide.open("https://cloud.google.com");
        //driver.get("https://cloud.google.com");
        screenshots.captureScreenShot();
        codePage.captureCodePage();
        return this;
    }

    public CloudGooglePage cloudGoogleSearchInputMessageTransition(String message) {
        Integer windowSize = DriverS.driver.manage().window().getSize().width;
        if (windowSize < 1000) {
            clickSearchButtonInMobile.click();
        }
        clickSearchButton.click();
        inputTextSearchValue.click();
        inputTextSearchValue.sendKeys(message + Keys.ENTER);
        clickValueString.click();
        return this;
    }
}
