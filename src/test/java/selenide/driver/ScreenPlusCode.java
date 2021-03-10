package selenide.driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import page_factory.driver.DriverS;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

public class ScreenPlusCode {

    public void captureCodePage() {
        try {
            String pageSource = DriverS.getInstance().getPageSource();
            writeInFile("screenshots\\"+""+GetTimeStampValue()+".html", pageSource);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void captureScreenShot() {
        try {
            File screenshotFile = ((TakesScreenshot) DriverS.getInstance()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("screenshots\\" + "" + GetTimeStampValue() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeInFile(String sFileName, String sTextToWrite) {

        FileWriter outFile;
        try {
            outFile = new FileWriter(sFileName);
            PrintWriter out = new PrintWriter(outFile);
            out.print(sTextToWrite);
            out.close();
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
