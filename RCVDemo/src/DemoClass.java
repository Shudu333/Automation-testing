import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\browserDrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
//		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\browserDrivers\\geckodriver.exe");
//		FirefoxDriver driver = new FirefoxDriver();
		
		
//		System.setProperty("webdriver.edge.driver", "C:\\Selenium\\browserDrivers\\msedgedriver.exe");
//		EdgeDriver driver = new EdgeDriver();
		
		driver.get("http://www.google.com");

	}

}
