package My_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ebay {
 	//declaring driver globally
	WebDriver driver ;
	
	@BeforeTest
	public void setup() {
		//creating an instance of chrome driver.
		driver = new ChromeDriver();		
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void tc1() throws InterruptedException {
		
	   
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
       WebElement search = driver.findElement(By.cssSelector("input[placeholder=\"Search for anything\"]"));
       
       search.sendKeys("Shoes");
       WebElement searchbtn = driver.findElement(By.id("gh-btn"));
       searchbtn.click();
      
      JavascriptExecutor js = (JavascriptExecutor) driver;
      
      WebElement shoe = driver.findElement(By.cssSelector("[class=\"srp-answer__title\"]"));
			
      js.executeScript("arguments[0].scrollIntoView(true)", shoe);
      Thread.sleep(3000); 
      
      js.executeScript("window.scrollTo(0, 0);");
      Thread.sleep(3000);	
      
      WebElement search1 = driver.findElement(By.cssSelector("input[placeholder=\"Search for anything\"]"));
      
      search1.sendKeys(Keys.CONTROL + "a");
      search1.sendKeys(Keys.BACK_SPACE);
           
	}
	
	@AfterTest
	public void teardwon() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}


}
