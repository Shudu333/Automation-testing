package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {
	
	public static String browser = "edge";
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		
		driver.get("http://www.saucedemo.com/");
		
		WebElement password = driver.findElement(By.id("password"));
		WebElement email = driver.findElement(with(By.tagName("input")).above(password));
		
		email.sendKeys("gfgh");
				
//				By email = RelativeLocator.with(By.tagName("input")).above(By.id("password"));
				
		
// 		driver.findElement(By.id("user-name")).sendKeys("standard_user");
//		driver.findElement(By.id("password")).sendKeys("secret_sauce");
//		driver.findElement(By.id("login-button")).click();

	}

}
