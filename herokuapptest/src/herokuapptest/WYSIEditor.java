package herokuapptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class WYSIEditor {

	public WebDriver driver;

    // Constructor – pass WebDriver from main class
    public WYSIEditor(WebDriver driver) {
        this.driver = driver;
    }
    
    @Test
    // Method to verify page content
    public void verifyWYSIEditor() {

	        // Open TinyMCE page
	 //       driver.get("https://the-internet.herokuapp.com/tinymce");
	        System.out.println("Page Title: " + driver.getTitle());

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Wait for iframe and switch to it
	        WebElement iframe = wait.until(
	                ExpectedConditions.presenceOfElementLocated(By.id("mce_0_ifr"))
	        );
	        driver.switchTo().frame(iframe);

	        // Locate the editor body
	        WebElement editor = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.id("tinymce"))
	        );

	        // Clear existing text
	        editor.clear();

	        // Small delay (demo purpose)
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Type new text
	        editor.sendKeys("This text is entered using Selenium WebDriver.");
	        System.out.println("Text entered into TinyMCE editor.");

	        // Delay to view text
	        try {
	            Thread.sleep(1500);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Switch back to main page
	        driver.switchTo().defaultContent();

	           // Ensure we always go back to home page
            driver.navigate().back();
	    }
	}