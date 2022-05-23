package tihsa.tihsa;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Constants;
import utilities.ExcelUtilities;

public class Jobsearch {
	
static ExcelUtilities excelUtils = new ExcelUtilities();
    
    
    static String excelFilePath =Constants.Path_TestData+Constants.excelFilePath;
	
	public static String browser = "chrome";
	public static WebDriver driver;
	@Test
	public void launch() {
		
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
		
		driver.get("https://telesure.jb.skillsmapafrica.com/");
//		driver.manage().window().maximize();
	}
	
	@Test
	public void loginPage() {
		
		driver.findElement(By.xpath("//*[@id=\"jbheader\"]/div/div/div/a[3]")).click();
		
	}
	@Test
	public void registration() throws InterruptedException, IOException {
		
   	 WebElement email=driver.findElement(By.name("UserName"));
     WebElement password=driver.findElement(By.name("Password"));
     WebElement confirmPassword=driver.findElement(By.name("ConfirmPassword"));
     WebElement submitBtn=driver.findElement(By.xpath("//*[@id=\"frmRegister\"]/fieldset/table/tbody/tr[5]/td[1]/input"));
     
     excelUtils.setExcelFile(excelFilePath,"Sheet1");

     
     for(int i=1;i<=excelUtils.getRowCountInSheet();i++)
     {
     	Thread.sleep(1000);
     	email.sendKeys(excelUtils.getCellData(i,0));
     	email.clear();
     	Thread.sleep(1000);
     	password.sendKeys(excelUtils.getCellData(i,1));
     	password.clear();
     	Thread.sleep(1000);
     	confirmPassword.sendKeys(excelUtils.getCellData(i,2));
     	Thread.sleep(1000);
     	confirmPassword.clear();
     	
     	
     	JavascriptExecutor js = (JavascriptExecutor) driver;
   
     	
     	js.executeScript("arguments[0].click();", submitBtn);


     
     	Thread.sleep(1000);
     	
         
         WebElement errormessage = driver.findElement(By.xpath("//span[@class='form-field__msg form-field__msg--error']"));
         
        
         if (errormessage.isDisplayed() ) {
         	
         	excelUtils.setCellValue(i,5,"PASS",excelFilePath);
         } else {
             
             excelUtils.setCellValue(i,5,"FAIL",excelFilePath);
         }

        
     }

		
	}
	@Test
	public void login() {
		
	}
	@Test
	public void search() {
		
	}

}
