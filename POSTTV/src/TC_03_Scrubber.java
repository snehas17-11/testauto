import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.sikuli.script.Button;
import org.sikuli.script.Env;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.sikuli.script.Location;
public class TC_03_Scrubber {


	public WebDriver driver;

	@Test

	public void test_scrubber() throws FindFailed, InterruptedException, AWTException
	{
	//Create a new instance of the Firefox driver
	//driver = new FirefoxDriver();
		 
	System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chrome/Application/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//And now use this to visit Google
	driver.get("http://wapo.st/1w4Py7D");
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Thread.sleep(1000);
	WebElement element = driver.findElement(By.xpath("//*[@id='article-body']/article/div[1]"));
	Coordinates coordinate = ((Locatable)element).getCoordinates();
	coordinate.inViewPort();

	//Create and initialize an instance of Screen object    
	Screen screen = new Screen();

	//Add image path  
	Pattern image = new Pattern("imgs/play.png");
	Pattern image1 = new Pattern("imgs/play_Scrubber.png");
	Pattern image2 = new Pattern("imgs/volume.png");
	Pattern image4 = new Pattern("imgs/pause_scrubber.png");
	Pattern image7 = new Pattern("imgs/volume_down.png");
	Pattern image6 = new Pattern("imgs/point.png");
	Pattern image8 = new Pattern("imgs/skipad.png");
	Pattern image9 = new Pattern("imgs/fullscreen.png");
	Pattern image10 = new Pattern("imgs/escapefullscreen.png");
	Pattern image11= new Pattern("imgs/posttvlogo.png");
	//Pattern image5 = new Pattern("imgs/videotime.png");
	//driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	screen.wait(image, 10000);
	image.similar((float)0.77);
	screen.click(image);
	Thread.sleep(30000);
	/*//video runtime
	screen.wait(image5,10);
	screen.mouseMove(Env.getMouseLocation().offset(50,-100));
	Thread.sleep(30000);
    image5.similar((float)0.77);
    screen.click(image5);*/
	
	// skip the add
	if(screen.exists(image8,2000)!=null)
	{
		screen.hover(image8);
		image8.similar((float)0.77);
		screen.click(image8);
	}
	
	Robot robot = new Robot();
	 robot.mouseMove(403,463 );
	 Thread.sleep(1000);
	 screen.mouseMove(Env.getMouseLocation());
	//screen.mouseMove(Env.getMouseLocation().offset(50,50));
// Pause Video	
	if(screen.exists(image4, 3000) != null)
	{
	    		
		screen.mouseMove(Env.getMouseLocation().offset(50,-50));
		//Thread.sleep(3000);
		screen.hover(image4);
	image4.similar((float)0.77);
	    screen.click(image4);
	}
	
	/*if(screen.exists(image4) != null)
	{
	screen.wait(image4,90);
	screen.hover(image4);
	screen.click(image4);
	*/
	//video is paused
	image1.similar((float)0.77);
	screen.hover(image1);
	if(screen.exists(image1) != null)
	{
		screen.wait(image1,50);
		screen.hover(image1);
		screen.click(image1);
		Thread.sleep(500);
	}
	
	// volume of the video
	screen.mouseMove(Env.getMouseLocation().offset(50,-100));
	screen.wait(image2,5000);
	image2.similar((float)0.77);
	screen.wait(image2,10);
	screen.click(image2);
	Thread.sleep(1000);
	screen.wait(image7,1000);
	image7.similar((float)0.77);
	screen.click(image7);
	
		
// Mouse click on scrubber
	
	Thread.sleep(9000);
	screen.mouseMove(Env.getMouseLocation().offset(50,-100));
	Region lRegion = screen.find(image6);
	//String pStartingOffset = null;
	
	Location lLocation = lRegion.getCenter();//.above(Integer.parseInt(pStartingOffset));
	screen.hover(lLocation);
	//screen.mouseDown(Button.RIGHT);
	screen.mouseMove(lLocation.offset(404, 448));
	screen.click(image6);
	//screen.mouseUp();
	/*Location wheelPoint = new Location(404, 448);
	try {
	    int steps = 0;
		screen.wheel(wheelPoint, Button.LEFT, steps);
		
	} catch (Exception e)
	{
	    Assert.fail("Mouse did not move to desired location");
	}
	}*/
	
	
//switch video to full screen
	    robot.mouseMove(403,463 );
		screen.mouseMove(Env.getMouseLocation());
	    screen.wait(image9,10);
	    image9.similar((float)0.77);
		screen.click(image9);
//switch video to normal screen
		screen.mouseMove(Env.getMouseLocation().offset(50,-100));
	    screen.wait(image10,10);
	    image10.similar((float)0.77);
		screen.click(image10);
	
//hit on post tv logo
		robot.mouseMove(403,463 );
		screen.mouseMove(Env.getMouseLocation());
		screen.wait(image11,100);
		image11.similar((float)0.77);
		screen.click(image11);
	}
	@AfterClass
	public void teardown() 
	{
		driver.quit();
	}


	}