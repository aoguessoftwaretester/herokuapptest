package herokuapptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Checkboxes {

	private WebDriver driver; // private → accessible only within this class.

    // Constructor
    public Checkboxes(WebDriver driver) {
        this.driver = driver; // Receives WebDriver from the main script.
    }
    
    public void verifyCheckboxes() {
		
    	List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
    	
    	System.out.println("Total checkboxes found: " + checkboxes.size());

        // Loop through each checkbox
        for (int i = 0; i < checkboxes.size(); i++) {

            WebElement checkbox = checkboxes.get(i);

            // If checkbox is not selected, click it
            if (!checkbox.isSelected()) {
                checkbox.click();
                System.out.println("Checkbox " + (i + 1) + " was unchecked → now checked");
            } else {
                System.out.println("Checkbox " + (i + 1) + " was already checked");
            }
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
