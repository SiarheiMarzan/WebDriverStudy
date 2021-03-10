package selenide_test2.page;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GoogleImagesPage {

    private SelenideElement clickSearchImageButton = $(By.xpath("//div[@jscontroller='TJw5qb']"));

    @When("I click search image button")
    public void iClickSearchImageButton() {
        clickSearchImageButton.click();
    }
}
