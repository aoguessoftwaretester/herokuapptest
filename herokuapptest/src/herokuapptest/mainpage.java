package herokuapptest;

//import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class mainpage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium webdriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		System.out.println("Home Page Title: " + driver.getTitle());
		
		// Optional: small delay to let page fully load (for demo purposes)
	    try {
	        Thread.sleep(1000); // 1 second 
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
		//Call the A/B Testing class
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait until the A/B Testing link is clickable
		driver.findElement(By.linkText("A/B Testing")).click();
		ABTesting abtesting = new ABTesting(driver);  // Call the ABTesting class
		abtesting.verifyContent();

		//Call Add/Remove Elements class
		driver.findElement(By.linkText("Add/Remove Elements")).click();
		AddRemoveElements page = new AddRemoveElements(driver);  // Call the AddRemoveElements class
		page.testAddRemoveElements();
		
		//Call Basic Auth class
		driver.findElement(By.linkText("Basic Auth")).click();
		BasicAuth basicAuth = new BasicAuth(driver);  
		basicAuth.verifyBasicAuth();
		
		//Call Broken Image class
		driver.findElement(By.linkText("Broken Images")).click();
		BrokenImages brokenImages = new BrokenImages(driver);  
		brokenImages.verifyBrokenImages();
		
        driver.quit();

	}

}
