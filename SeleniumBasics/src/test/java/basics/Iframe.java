package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframe {



		public static String browser = "chrome";
		public static WebDriver driver;

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub

			if (browser.equals("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				
			} else if (browser.equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				
			}else if (browser.equals("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				
			}
			
			driver.get("https://www.sovtech.co.za/contact-us/");
//			driver.manage().window().maximize();
			
			
			Thread.sleep(1000);
			//Store the web element
			WebElement iframe = driver.findElement(By.cssSelector("#hs-form-iframe-0"));

			//Switch to the frame
			driver.switchTo().frame(iframe);


			  
			
			driver.findElement(By.id("your_name-c2e387f9-4bd8-496f-ab2a-81fbbc31712a")).sendKeys("mashudu Ndou");
			driver.findElement(By.name("email")).sendKeys("mashudu@example.com");
			driver.findElement(By.cssSelector("#mobilephone-c2e387f9-4bd8-496f-ab2a-81fbbc31712a")).sendKeys("+271234567890");
			Select numemployees = new Select (driver.findElement(By.name("numemployees")));
			numemployees.selectByValue("5-25");
			
			Select service = new Select (driver.findElement(By.id("what_kind_of_problem_is_your_business_currently_facing_-c2e387f9-4bd8-496f-ab2a-81fbbc31712a")));
			service.selectByValue("Develop & launch a product to market");

			driver.findElement(By.tagName("textarea")).sendKeys("This is an automation testing in selemium");
			driver.findElement(By.id("LEGAL_CONSENT.subscription_type_10841063-c2e387f9-4bd8-496f-ab2a-81fbbc31712a")).click();
			driver.findElement(By.xpath("//*[@id=\"hsForm_c2e387f9-4bd8-496f-ab2a-81fbbc31712a\"]/div/div[2]/input")).click();
		}

	}
