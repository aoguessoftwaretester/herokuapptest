package herokuapptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ABTesting {
	
	private WebDriver driver;

    // Constructor – pass WebDriver from main class
    public ABTesting(WebDriver driver) {
        this.driver = driver;
    }
    

    // Method to verify page content
    public void verifyContent() {
        String expectedText = "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).";

        try {
                // Explicit wait until paragraph is visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement paragraph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.example p"))
                );
                
            String actualText = paragraph.getText().trim();
            System.out.println("A/B Testing Page Text: " + actualText);

            if (actualText.equals(expectedText)) {
                System.out.println("✅ Content Test Passed!");
            } else {
                System.out.println("❌ Content Test Failed!");
            }

        } catch (Exception e) {
            System.out.println("❌ Paragraph element not found on the A/B Testing page.");
        }
        
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