package selenide.selenide_page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class EmailPage {

    private SelenideElement copyButton = $(By.xpath("//span[@class='copy_icon']"));

    private SelenideElement clickEmail = $(By.xpath("//span[@class='small_message_icon']"));

    private SelenideElement waitElementEmail = $(By.id("inbox_count_number"));

    public EmailPage emailPostReturn() {
        switchTo().window(1);
        copyButton.click();
        switchTo().window(0);
        return this;
    }

    public EmailPage openEmail() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickEmail.click();
        return this;
    }
}
