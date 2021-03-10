package page_object2.page;

import org.openqa.selenium.WebDriver;
import page_odject.driver.DriverSingleton;

public class BasePage2 {
    WebDriver driver = DriverSingleton.getInstance();

    public String getPageTitle() {
        return driver.getTitle();
    }
}
