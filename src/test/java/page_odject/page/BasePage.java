package page_odject.page;

import org.openqa.selenium.WebDriver;
import page_odject.driver.DriverSingleton;

public class BasePage {
    WebDriver driver = DriverSingleton.getInstance();

    public String getPageTitle() {
        return driver.getTitle();
    }
}
