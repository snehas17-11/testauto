//import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Env;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
//import org.openqa.selenium.WebElement;

public class Sikuli_Play_Video {
	private WebDriver driver;

@Test
public void functionName() throws FindFailed, InterruptedException {
  
// Create a new instance of the Firefox driver
	
	//System.setProperty("webdriver.chrome.driver", "C:/Program Files/Google/Chrome/Application/chromedriver.exe");
	driver = new FirefoxDriver();

// And now use this to visit Google
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

Pattern image6 = new Pattern("imgs/share.png");
Pattern image7 = new Pattern("imgs/embed.png");
image5.similar((float)0.77);
   
//Wait 10ms for image  


JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("window.scrollBy(0,250)", "");
//Click on the image

//element1.click();
screen.wait(image5, 10);
screen.wait(image1,10);
System.out.println("Video Still is displayed");
screen.wait(image2,10);
System.out.println("Video name is displayed");
screen.wait(image3,10);
System.out.println("Video runtime is displayed");
screen.wait(image4,10);
System.out.println("Post TV logo are shown on the page");
Thread.sleep(1000);
screen.click(image5);
Thread.sleep(5000);

//WebDriverWait wait = new WebDriverWait(driver,100);
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='player-container-posttv-external-video-template']/div/div/div[10]/ul/li[1]/a")));
System.out.println("Element is visible");
//WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='player-container-posttv-external-video-template']/div/div/div[10]/ul/li[1]/a")));
System.out.println("Share button is displayed");
screen.wait(image6,9000);
Thread.sleep(2000);
image6.similar((float)0.77);
screen.mouseMove(Env.getMouseLocation().offset(50, 50));
screen.hover(image6);
//screen.click(image6);

screen.wait(image7,9000);
Thread.sleep(500);
screen.mouseMove(Env.getMouseLocation().offset(20,20));
screen.hover(image7);
screen.click(image7);
}

@AfterClass
public void teardown() throws InterruptedException
{
	Thread.sleep(1000);
	driver.close();
	
	driver.quit();
}
}