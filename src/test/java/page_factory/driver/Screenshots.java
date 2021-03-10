package page_factory.driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class Screenshots {
    public void captureScreenShot() {
        try {
            File screenshotFile = ((TakesScreenshot) DriverS.getInstance()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("screenshots\\" + "" + GetTimeStampValue() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String GetTimeStampValue() throws IOException {
        Calendar cal = Calendar.getInstance();
        Date time = cal.getTime();
        String timestamp = time.toString();
        System.out.println(timestamp);
        String systime = timestamp.replace(":", "-");
        System.out.println(systime);
        return systime;
    }
}
