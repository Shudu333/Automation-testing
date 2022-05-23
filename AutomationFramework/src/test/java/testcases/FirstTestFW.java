package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class FirstTestFW extends BaseTest {
	
	@Test
	public static void LoginTest() throws InterruptedException {
		
		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys("ndou.pm@gmail.com");
		driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(loc.getProperty("pwd_field"))).sendKeys("123@Developer");
		driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
	}

}
