package page_object2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import page_odject.page.BasePage;

public class SignUpPage2 extends BasePage2 {
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
        searchInput.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force\n");

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
