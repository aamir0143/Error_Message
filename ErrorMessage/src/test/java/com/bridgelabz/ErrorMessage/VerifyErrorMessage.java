package com.bridgelabz.ErrorMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyErrorMessage {
	
	
	WebDriver driver;
	
	
	@Test
	public void gmailTest() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Md Aamir Reza\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://gmail.com/");
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
		Thread.sleep(2000);
		String actual_error=driver.findElement(By.xpath("//div[@class='o6cuMc']")).getText();
		String expected_error="Enter an email or phone number";
		//type1
		Assert.assertEquals(actual_error, expected_error);
		//type2
		Assert.assertTrue(actual_error.contains("abcd"));
		System.out.println("Test Completed");
	}
}
