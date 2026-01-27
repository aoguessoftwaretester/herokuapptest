package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

    public static void captureScreenshot(WebDriver driver, String testName) {

        try {
            // Timestamp for unique screenshot name
            String timeStamp = LocalDateTime.now().format(FORMATTER);

            // Take screenshot
            File srcFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            // CI-safe screenshot directory (OS-independent)
            Path screenshotDir = Paths.get(
                    System.getProperty("java.io.tmpdir"),
                    "herokuapptest",
                    "screenshots"
            );

            // Create directory if it does not exist
            Files.createDirectories(screenshotDir);

            // Destination file
            Path destFile = screenshotDir.resolve(
                    testName + "_" + timeStamp + ".png"
            );

            // Copy screenshot
            Files.copy(
                    srcFile.toPath(),
                    destFile,
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println("📸 Screenshot saved at: " + destFile.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("❌ Failed to capture screenshot: " + e.getMessage());
        }
    }
}
