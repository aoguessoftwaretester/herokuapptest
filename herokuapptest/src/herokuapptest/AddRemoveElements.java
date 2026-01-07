package herokuapptest;



import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddRemoveElements {

	private WebDriver driver;
	
    // Constructor – pass WebDriver from main class 
    public AddRemoveElements(WebDriver driver) {
        this.driver = driver;
    }
    
    // Method to test Add/Remove Elements functionality
    public void testAddRemoveElements() throws InterruptedException {

        // Locate "Add Element" button
        WebElement addButton =
                driver.findElement(By.xpath("//button[text()='Add Element']"));

        // Click "Add Element" button 3 times
        for (int i = 1; i <= 3; i++) {
            addButton.click();
            Thread.sleep(1000);
        }

        // Locate all Delete buttons
        List<WebElement> deleteButtons =
                driver.findElements(By.className("added-manually"));

        System.out.println("Number of Delete buttons: " + deleteButtons.size());

        // Click each Delete button
        for (WebElement deleteBtn : deleteButtons) {
            deleteBtn.click();
            Thread.sleep(1000);
        }

        // Verify all Delete buttons are removed
        List<WebElement> remainingButtons =
                driver.findElements(By.className("added-manually"));

        System.out.println("Remaining Delete buttons: " + remainingButtons.size());
        
		// Go back to homepage
        driver.navigate().back();
        System.out.println("Returned to Home Page Title: " + driver.getTitle());
    }
}