package herokuapptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List; // Imports the List interface to store multiple web elements (headers, rows, cells).

public class ChallengingDOM {

    private WebDriver driver; // private → accessible only within this class.

    // Constructor
    public ChallengingDOM(WebDriver driver) {
        this.driver = driver; // Receives WebDriver from the main script.
    }
    
	public void verifyChallengingDOM() {
	       // Click buttons using stable locators (text / class), inspect the code
        driver.findElement(By.cssSelector("a.button")).click();          // Blue button
        driver.findElement(By.cssSelector("a.button.alert")).click();    // Red button
        driver.findElement(By.cssSelector("a.button.success")).click();  // Green button

        System.out.println("✅ All buttons clicked successfully");

        // Locate table headers
        List<WebElement> headers =
                driver.findElements(By.cssSelector("table thead th"));

        System.out.println("Table Headers:");
        
        //Loops through each header. Prints header text separated by |
        for (WebElement header : headers) {
            System.out.print(header.getText() + " | ");
        }
        System.out.println();

        // Locate table rows. Finds all table rows (<tr>) in the table body.
        List<WebElement> rows =
                driver.findElements(By.cssSelector("table tbody tr"));
        
        // Prints the number of rows found.
        System.out.println("Total table rows: " + rows.size());

        // Gets the first row (index 0). Finds all data cells (<td>) inside that row.
        List<WebElement> firstRowCells =
                rows.get(0).findElements(By.tagName("td"));
        System.out.println("First Row Data:"); // Label for output.
        
        // Loops through each cell. Prints cell values.
        for (WebElement cell : firstRowCells) {
            System.out.print(cell.getText() + " | ");
        }
        System.out.println();
        
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
