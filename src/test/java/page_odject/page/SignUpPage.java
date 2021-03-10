package page_odject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SignUpPage extends BasePage {
    private By searchInputBy = By.id("postform-text");
    private By findSearchInputField = By.xpath("//div[label='Syntax Highlighting:']");
    private By activeFieldSearch = By.xpath("//input[@type='search']");
    private By clickFieldChoiceValueTime = By.id("select2-postform-expiration-container");
    private By choiceValueTime = By.xpath("//li[text()='10 Minutes']");
    private By choiceFieldInputPastNameTitle = By.xpath("//div[label ='Paste Name / Title:']");
    private By inputValuePastNameTitle = By.id("postform-name");

    public void openPage() {
        driver.get("https://pastebin.com/");
    }

    public void enterCode(String message) {
        WebElement searchInput = driver.findElement(searchInputBy);
        searchInput.sendKeys("Hello from WebDriver");

    }

    public void enterProgrammLanguage(String message) {
        driver.findElement(findSearchInputField).click();
        driver.findElement(activeFieldSearch).sendKeys(message + Keys.ENTER);
    }

    public void enterExpiration() {
        driver.findElement(clickFieldChoiceValueTime).click();
        driver.findElement(choiceValueTime).click();
    }

    public void pastName(String message) {
        driver.findElement(choiceFieldInputPastNameTitle).click();
        driver.findElement(inputValuePastNameTitle).sendKeys(message + Keys.ENTER);
    }
}
