package herokuapptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	private WebDriver driver;

    // Constructor
    public Dropdown(WebDriver driver) {
        this.driver = driver;
    }
    
	public void verifyDropdown() {
		
	    // Navigate to Dropdown page
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Locate dropdown element
        WebElement dropdownElement =
                driver.findElement(By.id("dropdown"));

        // Create Select object
        Select dropdown = new Select(dropdownElement);

        // Select Option 1
        dropdown.selectByVisibleText("Option 1");
        System.out.println("Selected: " + dropdown.getFirstSelectedOption().getText());

        // Select Option 2
        dropdown.selectByVisibleText("Option 2");
        System.out.println("Selected: " + dropdown.getFirstSelectedOption().getText());

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
