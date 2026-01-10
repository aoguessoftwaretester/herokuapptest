package herokuapptest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utils.ScreenshotListener;

@Listeners(ScreenshotListener.class)
public class mainpage {
	
    public WebDriver driver;

    @BeforeClass  // used @BeforeClass instead of @BeforeMethod so that the browser will remain opens in every test 
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\selenium webdriver\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
	public void verifyHomePageTitle() 
    {
		// small delay to let page fully load 
	    try {
	        Thread.sleep(2000); // 2 second 
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
    	System.out.println("Home Page Title: " + driver.getTitle());
    	//assert driver.getTitle().equals("Incorrect Title"); // force fail
    }
	
    @Test
    public void verifyABTestingPage() 		//Call A/B Testing class
    {
		driver.findElement(By.linkText("A/B Testing")).click();
		ABTesting abtesting = new ABTesting(driver);  // Call the ABTesting class
		abtesting.verifyContent();

        System.out.println("✅ The A/B Testing text link is working");
    }
	
    @Test
    public void verifyAddRemoveElementsPage() 		//Call Add/Remove Elements class
    {
		driver.findElement(By.linkText("Add/Remove Elements")).click();
		AddRemoveElements page = new AddRemoveElements(driver);  // Call the AddRemoveElements class
		page.verifyelements();
    }
		
    @Test
    public void verifyBasicAuthPage() 		//Call Basic Auth class
    {
	    driver.findElement(By.linkText("Basic Auth")).click();
	    BasicAuth basicAuth = new BasicAuth(driver);  
 		basicAuth.verifyBasicAuth();
    }
		
    @Test
    public void verifyBrokenImagesPage()		 //Call Broken Image class
    {
		driver.findElement(By.linkText("Broken Images")).click();
		BrokenImages brokenImages = new BrokenImages(driver);  
		brokenImages.verifyBrokenImages();
    }
		
    @Test
    public void verifyChallengingDOMPage()		//Call Challenging DOM class
    {
		driver.findElement(By.linkText("Challenging DOM")).click();
		ChallengingDOM challengingDOM = new ChallengingDOM(driver);  
		challengingDOM.verifyChallengingDOM();	
    }
		
    @Test
    public void verifyCheckboxesPage()		//Call Checkboxes class
    {
		driver.findElement(By.linkText("Checkboxes")).click();
		Checkboxes checkboxes = new Checkboxes(driver);  
		checkboxes.verifyCheckboxes();
    }
		
		// Call Context Menu
		// Call Digest Authentication
		// Call Disappearing Elements
				
    @Test
    public void verifyDragAndDropPage()		// Call Drag and Drop class
    {
		driver.findElement(By.linkText("Drag and Drop")).click();
		DragAndDrop draganddrop = new DragAndDrop(driver);  
		draganddrop.verifyDragAndDrop();
    }
		
    @Test
    public void verifyDropdownPage()		//Call Dropdown class
    {
		driver.findElement(By.linkText("Dropdown")).click();
		Dropdown dropdown = new Dropdown(driver);  
		dropdown.verifyDropdown();
    }
		
    @Test
    public void verifyDynamicContentPage()		//Call Dynamic Content class
    {
		driver.findElement(By.linkText("Dynamic Content")).click();
		DynamicContent dynamiccontent = new DynamicContent(driver);  
		dynamiccontent.verifyDynamicContent();	
    }
		
		//Call Dynamic Controls class 
		//Call Dynamic Loading class 
		//Call Entry Ad class 
		//Call Exit Intent class 
		
    @Test
    public void verifyFileDownloadPage()		//Call File Download class 
    {
		driver.findElement(By.linkText("File Download")).click();
		FileDownload filedownload = new FileDownload(driver);  
		filedownload.verifyFileDownload();
    }
		
    @Test
    public void verifyFileUploadPage()		//Call File Upload class 
    {
		driver.findElement(By.linkText("File Upload")).click();
		FileUpload fileupload = new FileUpload(driver);  
		fileupload.verifyFileUpload();	
    }
		
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
		
		
    @Test
    public void verifyWYSIEditorPage()	//Call WYSIWYG Editor class
    {
		driver.findElement(By.linkText("WYSIWYG Editor")).click();
		WYSIEditor wysiwygeditor = new WYSIEditor(driver);  
		wysiwygeditor.verifyWYSIEditor();   // this test will always fail because the TinyMCE is in read-only mode	
    }
				
      @AfterClass
	  public void tearDown() 
	  {   
	    driver.quit();
	  }  

	}
