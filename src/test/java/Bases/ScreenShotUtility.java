package Bases;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtility {
    public void takeScreenShot(String imageName, ChromeDriver driver) {
        DateTime dateTime = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yy-MM-dd-HH-mm");
        String timeStamp = dateTime.toString(formatter);
        imageName = imageName + "-" + timeStamp;
        File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String imageFolder = "screenshots";
        try {
            FileUtils.copyFile(imageFile, new File(imageFolder + File.separator + imageName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
