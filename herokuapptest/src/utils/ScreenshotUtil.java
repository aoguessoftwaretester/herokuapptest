package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String testName) {
        try {
            // Timestamp for unique screenshot name
            String timeStamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            // Take screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);

            // Screenshot folder path
            File screenshotDir = new File("C:\\Users\\Gel\\git\\herokuapptest\\herokuapptest\\screenshots");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdir();
            }

            // Destination file
            File destFile = new File(screenshotDir, testName + "_" + timeStamp + ".png");

            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}