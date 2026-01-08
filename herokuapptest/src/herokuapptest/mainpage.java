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
		
		//Call Challenging DOM class
		driver.findElement(By.linkText("Challenging DOM")).click();
		ChallengingDOM challengingDOM = new ChallengingDOM(driver);  
		challengingDOM.verifyChallengingDOM();		
		
		//Call Checkboxes class
		driver.findElement(By.linkText("Checkboxes")).click();
		Checkboxes checkboxes = new Checkboxes(driver);  
		checkboxes.verifyCheckboxes();	
		
		// Call Context Menu
		// Call Digest Authentication
		// Call Disappearing Elements
				
		// Call Drag and Drop class
		driver.findElement(By.linkText("Drag and Drop")).click();
		DragAndDrop draganddrop = new DragAndDrop(driver);  
		draganddrop.verifyDragAndDrop();	
		
		//Call Dropdown class
		driver.findElement(By.linkText("Dropdown")).click();
		Dropdown dropdown = new Dropdown(driver);  
		dropdown.verifyDropdown();	
		
		//Call Dynamic Content class
		driver.findElement(By.linkText("Dynamic Content")).click();
		DynamicContent dynamiccontent = new DynamicContent(driver);  
		dynamiccontent.verifyDynamicContent();	
		
		//Call Dynamic Controls class 
		//Call Dynamic Loading class 
		//Call Entry Ad class 
		//Call Exit Intent class 
		
		//Call File Download class 
		driver.findElement(By.linkText("File Download")).click();
		FileDownload filedownload = new FileDownload(driver);  
		filedownload.verifyFileDownload();	
		
		//Call File Upload class 
		driver.findElement(By.linkText("File Upload")).click();
		FileUpload fileupload = new FileUpload(driver);  
		fileupload.verifyFileUpload();	
		
		//Call Floating Menu class
		//Call Forgot Password class
		//Call Form Authentication class
		//Call Frames class
		//Call Geolocation class
		//Call Horizontal Slider class
		//Call Hovers class
		//Call Infinite Scroll class
		//Call Inputs class
		//Call JQuery UI Menus class
		//Call JavaScript Alerts class
		//Call JavaScript onload event error class
		// Call Key Presses class
		// Call Large & Deep DOM class
		// Call Multiple Windows class
		// Call Nested Frames class
		// Call Notification Messages class
		// Call Redirect Link class
		// Call Secure File Download class
		// Call Shadow DOM class
		// Call Shifting Content class
		// Call Slow Resources class
		// Call Sortable Data Tables class
		// Call Status Codes class
		// Call Typos calss
		
		
		//Call WYSIWYG Editor class
		
        driver.quit();

	}

}
