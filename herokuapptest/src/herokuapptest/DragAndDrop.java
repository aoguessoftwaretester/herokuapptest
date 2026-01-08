package herokuapptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
//import java.util.List;

public class DragAndDrop {

	private WebDriver driver; // private → accessible only within this class.

    // Constructor
    public DragAndDrop(WebDriver driver) {
        this.driver = driver; // Receives WebDriver from the main script.
    }
    
	public void verifyDragAndDrop() {

		 // Locate source and target elements
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));
        
	    try {
	        Thread.sleep(1000); // 1 second
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

        // JavaScript for HTML5 drag and drop
        String dragAndDropScript =
                "function simulateDragDrop(sourceNode, destinationNode) {" +
                "  const dataTransfer = new DataTransfer();" +
                "  sourceNode.dispatchEvent(new DragEvent('dragstart', { dataTransfer }));" +
                "  destinationNode.dispatchEvent(new DragEvent('dragover', { dataTransfer }));" +
                "  destinationNode.dispatchEvent(new DragEvent('drop', { dataTransfer }));" +
                "  sourceNode.dispatchEvent(new DragEvent('dragend', { dataTransfer }));" +
                "}" +
                "simulateDragDrop(arguments[0], arguments[1]);";

        // Execute JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(dragAndDropScript, source, target);

        // Verify result
        System.out.println("Column A now contains: " + source.getText());

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
