import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.sikuli.script.Button;
import org.sikuli.script.Env;
import org.sikuli.script.FindFailed;
//import org.sikuli.script.Location;
import org.sikuli.script.Pattern;
//import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class test {

	public WebDriver driver;

@Test

public void test_video() throws FindFailed, InterruptedException
{
//Create a new instance of the Firefox driver
 driver = new FirefoxDriver();

//And now use this to visit Google
driver.get("http://wapo.st/1w4Py7D");
driver.manage().window().maximize();
//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("window.scrollBy(0,250)", "");

//Create and initialize an instance of Screen object    
Screen screen = new Screen();

//Add image path  
Pattern image = new Pattern("imgs/play.png");
Pattern image1 = new Pattern("imgs/pause.png");
Pattern image2 = new Pattern("imgs/volumw.png");
//driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
screen.wait(image, 10);
image1.similar((float)0.77);
screen.click(image);
Thread.sleep(5000);
screen.wait(image1,90000);
screen.mouseMove(Env.getMouseLocation().offset(50,-100));
screen.hover(image1);
image1.similar((float)0.77);
screen.click(image1);
Thread.sleep(1000);

screen.wait(image2,5000);
image2.similar((float)0.77);
screen.click(image2);
Thread.sleep(1000);

//slider drag and drop

/*Region lRegion = screen.find("C:\\volumw.png");
String pStartingOffset = null;
Location lLocation = lRegion.getCenter().above(Integer.parseInt(pStartingOffset));
screen.hover(lLocation);
screen.mouseDown(Button.WHEEL_UP);
screen.mouseMove(lLocation.offset(327,406));
screen.mouseUp();*/

}

@AfterClass
public void teardown() 
{
	driver.quit();
}


}