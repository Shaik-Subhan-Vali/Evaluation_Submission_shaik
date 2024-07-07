package My_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class snapdeal {
	//declaring driver globally
		WebDriver driver ;
		
		@BeforeTest
		public void setup() {
			//creating an instance of chrome driver.
			driver = new ChromeDriver();		
			driver.get("https://www.snapdeal.com/");
			driver.manage().window().maximize();
		}
		
		@Test
		public void tc1() throws InterruptedException {
			
		   
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   
		    JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("document.getElementById('inputValEnter').value = 'Mobiles';");

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class=\"sd-icon sd-icon-search-under-catagory lfloat\"]")));
	        searchButton.click();

		}
		
		@AfterTest
		public void teardwon() throws InterruptedException
		{
			Thread.sleep(3000);
			driver.quit();
		}

}
