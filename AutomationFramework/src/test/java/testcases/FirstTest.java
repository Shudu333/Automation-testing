package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest extends BaseTest{

	@Test(dataProvider="test1")
	public static void LoginTest(String email, String password) throws InterruptedException {
		
		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(email);
		driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(loc.getProperty("pwd_field"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
	}

	@DataProvider(name = "test1")
	public Object[][] createData1() {
	 return new Object[][] {
	   { "ndou.pm@gmail.com","@Developer" },
	   { "ndou.pm@gm.com","123@veloper" },
	   { "ndou@gmail.com","12Developer" },
	   { "ndou.pm@gmail.com","123@Developer" },
	 };
	}


}
