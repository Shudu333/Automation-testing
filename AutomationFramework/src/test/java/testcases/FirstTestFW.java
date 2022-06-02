package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class FirstTestFW extends BaseTest {
	
	@Test(dataProviderClass=ReadXLSdata.class,dataProvider="loginTestData")
	public static void LoginTest(String email, String password) throws InterruptedException {
		
		
		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(email);
		driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(loc.getProperty("pwd_field"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
	}

}
