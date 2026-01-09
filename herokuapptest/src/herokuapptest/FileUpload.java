package herokuapptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUpload {

    private WebDriver driver;

    // Constructor
    public FileUpload(WebDriver driver) {
        this.driver = driver;
    }
    
    public void verifyFileUpload() {

        // Locate file input field
        WebElement fileInput = driver.findElement(By.id("file-upload"));
        fileInput.sendKeys("C:\\Users\\Gel\\Documents\\05 Testing Stuff\\Selenium\\Sample_upload.txt");

        driver.findElement(By.id("file-submit")).click();

        // Re-locate element AFTER page reload
        String uploadedText =
                driver.findElement(By.tagName("h3")).getText();

        if (uploadedText.equals("File Uploaded!")) {
            System.out.println("✅ File uploaded successfully");
        } else {
            System.out.println("❌ File upload failed");
        }

        
	    try {
	        Thread.sleep(1000); // 1 second
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    
		// Go back to home page
        driver.navigate().back();
        System.out.println("Returned to Home Page Title: " + driver.getTitle());
        
	}

}
