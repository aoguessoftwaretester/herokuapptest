package herokuapptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FileDownload {

    private WebDriver driver;

    // Constructor
    public FileDownload(WebDriver driver) {
        this.driver = driver;
    }
    
    // Test method
    public void verifyFileDownload() {

	       // Locate all downloadable file links
        List<WebElement> files =
                driver.findElements(By.cssSelector("#content a"));

        System.out.println("Total downloadable files: " + files.size());

        // Validate at least one file exists
        if (files.size() > 0) {
            System.out.println("✅ Downloadable files found");

            // Click the first file
            String fileName = files.get(0).getText();
            files.get(0).click();

            System.out.println("⬇ Download initiated for file: " + fileName);
        } else {
            System.out.println("❌ No downloadable files found");
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
