import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
public class TC_01_PlayVideo {

	private WebDriver driver;
	@Test
	public void functionName() throws FindFailed, InterruptedException {
	  
	// Create a new instance of the Firefox driver
				//System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chrome/Application/chromedriver.exe");
		driver = new FirefoxDriver();

	// Load http://wapo.st/1w4Py7D
	driver.get("http://wapo.st/1w4Py7D");
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	//Create and initialize an instance of Screen object    
	Screen screen = new Screen();

	//Add image path  
	Pattern image1 =new Pattern("imgs/videostill.png");
	Pattern image2 = new Pattern("imgs/videoname.png");
	Pattern image3 = new Pattern("imgs/videoruntime.png"); 
	Pattern image4 = new Pattern("imgs/posttvlogo.png");
	Pattern image5 = new Pattern("imgs/play.png");
	image5.similar((float)0.77);
	   
	//Scroll Browser Window 

	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,250)", "");
	
	//Wait 10ms for image 
	screen.wait(image1,10);
	System.out.println("Video Still is displayed");
	screen.wait(image2,10);
	System.out.println("Video name is displayed");
	screen.wait(image3,10);
	System.out.println("Video runtime is displayed");
	screen.wait(image4,10);
	System.out.println("Post TV logo are shown on the page");
	screen.wait(image5, 10);
	System.out.println("Play button is displayed");
	Thread.sleep(1000);
	
	//play video
	screen.click(image5);
	Thread.sleep(5000);
	}	
	@AfterClass
	public void teardown() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
		
		driver.quit();
	}

}
