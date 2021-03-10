package page_object4.page;

import org.openqa.selenium.WebDriver;
import page_object4.driver.Driver;


public class BasePageHard {
    WebDriver driver = Driver.getInstance();

    public String getPageTitle(){return driver.getTitle();}
}
