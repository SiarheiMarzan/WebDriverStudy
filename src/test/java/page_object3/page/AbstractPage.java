package page_object3.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page_odject.driver.DriverSingleton;

public class AbstractPage {
    WebDriver driver = DriverSingleton.getInstance();

    public String getPageTitle(){return driver.getTitle();}
}
