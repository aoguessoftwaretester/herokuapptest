package herokuapptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrokenImages {

    private WebDriver driver;

    // Constructor
    public BrokenImages(WebDriver driver) {
        this.driver = driver;
    }

	public void verifyBrokenImages() {
		
		 // Find all image elements
        List<WebElement> images = driver.findElements(By.tagName("img"));

        System.out.println("Total images found: " + images.size());

        int brokenImageCount = 0;

        // Check each image
        for (WebElement img : images) {

            // naturalWidth = 0 means image is broken
            if (img.getAttribute("naturalWidth").equals("0")) {
                brokenImageCount++;
                System.out.println("❌ Broken image: " + img.getAttribute("src"));
            }
        }

        System.out.println("Total broken images: " + brokenImageCount);
        
		// Optional: small delay to let page fully load (for demo purposes)
	    try {
	        Thread.sleep(1000); // 1 second
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    
		// Go back to homepage
        driver.navigate().back();
        System.out.println("Returned to Home Page Title: " + driver.getTitle());

	}

}
