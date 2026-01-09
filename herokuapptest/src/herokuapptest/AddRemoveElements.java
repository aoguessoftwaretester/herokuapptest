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
    public void verifyelements() {

        try {
            WebElement addButton =
                    driver.findElement(By.xpath("//button[text()='Add Element']"));

            for (int i = 1; i <= 3; i++) {
                addButton.click();
                Thread.sleep(1000);
            }

            List<WebElement> deleteButtons =
                    driver.findElements(By.className("added-manually"));

            System.out.println("Number of Delete buttons: " + deleteButtons.size());

            for (WebElement deleteBtn : deleteButtons) {
                deleteBtn.click();
                Thread.sleep(1000);
            }

            List<WebElement> remainingButtons =
                    driver.findElements(By.className("added-manually"));

            System.out.println("Remaining Delete buttons: " + remainingButtons.size());

            driver.navigate().back();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}