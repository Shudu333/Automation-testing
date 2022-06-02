package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class RegistrationTest extends BaseTest {

	@Test
public static void Registration() throws InterruptedException {
		
		
		driver.findElement(By.linkText(loc.getProperty("signup_link"))).click();
		driver.findElement(By.id(loc.getProperty("reg_email_field"))).sendKeys("test");
		
		Thread.sleep(1000);
		driver.findElement(By.id(loc.getProperty("reg_pwd_field"))).sendKeys("password");
		Thread.sleep(1000);
		driver.findElement(By.id(loc.getProperty("terms_check"))).click();
		Thread.sleep(1000);
		driver.findElement(By.id(loc.getProperty("sign_up_button"))).click();
		Thread.sleep(1000);
	}
}
