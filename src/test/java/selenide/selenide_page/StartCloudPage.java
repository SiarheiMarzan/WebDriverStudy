package selenide.selenide_page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.awt.*;
import java.awt.event.KeyEvent;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class StartCloudPage {

    private SelenideElement clickSearchButtonInMobile = $(By.xpath("//*[@class='devsite-search-field devsite-search-query']"));

    private SelenideElement inputTextSearchValue = $(By.xpath("//input[@placeholder='Search']"));

    private SelenideElement clickValueString = $(By.xpath("//a[@class='gs-title']"));

    public StartCloudPage open() {
        Selenide.open("https://cloud.google.com");
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_T);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_T);
        switchTo().window(1);
        Selenide.open("https://10minutemail.com/");
        switchTo().window(0);
        return this;
    }

    public StartCloudPage cloudGoogleSearchInputMessageTransition(String message) {
        clickSearchButtonInMobile.click();
        inputTextSearchValue.click();
        inputTextSearchValue.sendKeys(message + Keys.ENTER);
        clickValueString.click();
        return this;
    }

}
