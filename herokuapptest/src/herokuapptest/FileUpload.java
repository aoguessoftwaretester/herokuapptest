package herokuapptest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {

    public WebDriver driver;
    public WebDriverWait wait;

    // Constructor
    public FileUpload(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void verifyFileUpload() {

        // Locate file input field
        WebElement fileInput = driver.findElement(By.id("file-upload"));
        fileInput.sendKeys("C:\\Users\\Gel\\Documents\\05 Testing Stuff\\Selenium\\Sample_upload.txt");

        driver.findElement(By.id("file-submit")).click();

        // ✅ WAIT for the success heading to appear
        WebElement header = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.tagName("h3"))
        );

        String uploadedText = header.getText();

        if (uploadedText.equals("File Uploaded!")) {
            System.out.println("✅ File uploaded successfully");
        } else {
            System.out.println("❌ File upload failed");
        }

        // Optional short pause for visibility
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ✅ Always go back to home explicitly
        driver.get("https://the-internet.herokuapp.com/");
    }
}
