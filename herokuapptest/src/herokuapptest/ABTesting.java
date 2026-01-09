package herokuapptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.ScreenshotUtil;

import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class ABTesting {
	
	
	public WebDriver driver;

    // Constructor – pass WebDriver from main class
    public ABTesting(WebDriver driver) {
        this.driver = driver;
    }
    
    @Test
    // Method to verify page content
    public void verifyContent() {

        String expectedText = "aaAlso known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).";

        try {
            // Explicit wait until paragraph is visible 
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement paragraph = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("div.example p")
            ));

            String actualText = paragraph.getText().trim();
            System.out.println("A/B Testing Page Text: " + actualText);

            // Assert to mark failure in TestNG if content doesn't match
            Assert.assertEquals(actualText, expectedText, "A/B Testing page content does not match!");

        } catch (Exception e) {
            System.out.println("❌ Error verifying A/B Testing page: " + e.getMessage());

            // Capture screenshot on failure
            ScreenshotUtil.captureScreenshot(driver, "verifyABTestingPage");

            // Optional: re-throw exception to mark test as FAILED
            throw e;
        } finally {
            // Optional small delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

            // Ensure we always go back to home page
            driver.navigate().back();
        }
    }
}
