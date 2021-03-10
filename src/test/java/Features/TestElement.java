package Features;

import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestElement {
    private SelenideElement clickButtonSearchByVoice = $(By.xpath("//div[@jscontroller='MC8mtf']"));
    private SelenideElement microphoneButton = $(By.xpath("//span[@class='button']"));


    @Дано("Я нахожусь на странице поиска")
    public void яНахожусьНаСтраницеПоиска() {
        open("https://www.google.co.uk");
    }

    @Когда("Я нажимаю на кнопку голосового поиска")
    public void яНажимаюНаКнопкуГолосовогоПоиска() {
        clickButtonSearchByVoice.click();
    }

    @Тогда("На экране появляется логотип микрофона")
    public void наЭкранеПоявляетсяЛоготипМикрофона() {
        microphoneButton.shouldBe(Condition.id("spchb"));
    }

}
