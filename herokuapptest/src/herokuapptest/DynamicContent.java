package herokuapptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DynamicContent {

    private WebDriver driver;

    // Constructor
    public DynamicContent(WebDriver driver) {
        this.driver = driver;
    }

    // Test method
    public void verifyDynamicContent() {
	
        // Capture content text before refresh
        List<WebElement> contentBeforeElements =
                driver.findElements(By.cssSelector("#content .row .large-10"));

 //       System.out.println("Content BEFORE refresh:");
 //       for (WebElement content : contentBefore) {
 //           System.out.println(content.getText());
 //       }
        
        List<String> beforeText = new ArrayList<>();
        for (WebElement e : contentBeforeElements) {
            beforeText.add(e.getText());
        }

        // Refresh the page
        driver.navigate().refresh();

        // Capture content text after refresh
        List<WebElement> contentAfterElements =
                driver.findElements(By.cssSelector("#content .row .large-10"));

 //       System.out.println("\nContent AFTER refresh:");
 //       for (WebElement content : contentAfterElements) {
 //           System.out.println(content.getText());
 //       }
        
        List<String> afterText = new ArrayList<>();
        for (WebElement e : contentAfterElements) {
            afterText.add(e.getText());
        }

        // Simple validation (at least one block should change)
        boolean isDynamic = false;
        for (int i = 0; i < beforeText.size(); i++) {
            if (!beforeText.get(i).equals(afterText.get(i))) {
                isDynamic = true;
                break;
            }
        }

        if (isDynamic) {
            System.out.println("\n✅ Dynamic content verified (content changed)");
        } else {
            System.out.println("\n❌ Dynamic content NOT detected");
        }
        
	    try {
	        Thread.sleep(1000); // 1 second
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    
		// Go back to homepage
	    driver.get("https://the-internet.herokuapp.com/");
        
	}

}
