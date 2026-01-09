package herokuapptest;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuth {
	
    private WebDriver driver;

    // Constructor
    public BasicAuth(WebDriver driver) {
        this.driver = driver;
    }

	public void verifyBasicAuth() {

		// Pass username and password in the URL
        // Format: https://username:password@url
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        // Print page title
        System.out.println("Page Title: " + driver.getTitle());

        // Print page source validation message (optional)
        if (driver.getPageSource().contains("Congratulations")) {
            System.out.println("Basic Authentication successful");
        } else {
            System.out.println("Basic Authentication failed");
        }
		
		// Optional: small delay to let page fully load (for demo purposes)
	    try {
	        Thread.sleep(1000); // 1 second
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    
		// Go back to homepage
	    driver.get("https://the-internet.herokuapp.com/");
        System.out.println("Returned to Home Page Title: " + driver.getTitle());

	}

}
