package page_factory.signUp;

import com.sun.org.apache.xpath.internal.XPath;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_factory.driver.CodePage;
import page_factory.driver.DriverS;
import page_factory.driver.Screenshots;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


import java.io.IOException;
import java.util.ArrayList;

import static org.openqa.selenium.support.PageFactory.initElements;

public class EmailPage {

    private WebDriver driver;
    private WebDriverWait wait;
    CodePage codePage = initElements(DriverS.getInstance(), CodePage.class);
    Screenshots screenshots = initElements(DriverS.getInstance(), Screenshots.class);

    public EmailPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//span[@class='copy_icon']")
    private WebElement clickCopyButton;

    @FindBy(xpath = "//span[@class='small_message_icon']")
    private WebElement clickIconButton;

    public void pageEmail() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.com");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        screenshots.captureScreenShot();
        codePage.captureCodePage();
            }

    public void clickCopyButtonAndReturnToPreviousPage() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        Integer windowSize = DriverS.driver.manage().window().getSize().width;
        if (windowSize < 1000) {
            Actions actionProvider = new Actions(driver);
            Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("c").build();
            keydown.perform();
        } else {
            clickCopyButton.click();
        }
        driver.switchTo().window(tabs.get(0));
    }

    public void waitEmailAndLook() {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("inbox_count_number"), "1"));
        clickIconButton.click();
    }

    public String estimatedMonthlyCostFromWorkingEmail() {
        String third = driver.findElement(By.xpath("//td/h3[text()='USD 1,288.71']")).getText();
        String[] thirdValue = third.split(" ");
        return thirdValue[1];
    }
}







