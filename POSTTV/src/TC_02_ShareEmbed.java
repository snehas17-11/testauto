
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Env;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
public class TC_02_ShareEmbed {

	private WebDriver driver;
	@Test
	public void functionName() throws FindFailed, InterruptedException {
	  
	// Create a new instance of the Firefox driver
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chrome/Application/chromedriver.exe");
		driver = new ChromeDriver();

	// Load http://wapo.st/1w4Py7D
	driver.get("http://wapo.st/1w4Py7D");
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	//Create and initialize an instance of Screen object    
	Screen screen = new Screen();

	//Add image path  
	Pattern image1 =new Pattern("imgs/play.png");
	Pattern image2 = new Pattern("imgs/videoname.png");
	Pattern image3 = new Pattern("imgs/share.png"); 
	Pattern image4 = new Pattern("imgs/embed.png");
	Pattern image5 = new Pattern("imgs/scrubber.png");
	image5.similar((float)0.77);
	   
	//Scroll Browser Window 

	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,250)", "");
	
	//Wait 10ms for image 
	Thread.sleep(1000);
	screen.wait(image1,10);
	System.out.println("Play button is displayed");
	
	screen.wait(image2,10);
	System.out.println("Video name is displayed");
		//play video
	screen.click(image1);
	Thread.sleep(5000);
	    //share button
	screen.wait(image3,9000);
	Thread.sleep(2000);
	image3.similar((float)0.77);
	screen.mouseMove(Env.getMouseLocation().offset(50, 50));
	screen.hover(image3);
	System.out.println("share button is displayed");
	
	//embed button
	screen.wait(image4,9000);
	Thread.sleep(500);
	screen.mouseMove(Env.getMouseLocation().offset(20,20));
	screen.hover(image4);
	System.out.println("Embed button is displayed");
	
	//scrubber 
	screen.wait(image4,9000);
	Thread.sleep(500);
	screen.mouseMove(Env.getMouseLocation().offset(20,20));
	screen.hover(image4);
	System.out.println("Scubber is displayed");
	
	}	
	@AfterClass
	public void teardown() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
		
		driver.quit();
	}

}


