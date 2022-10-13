package com.ebanking.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleNG {
	
	WebDriver driver;
	@BeforeMethod
	public void xyz()
	{
		// launch browser
		
		driver=new FirefoxDriver();
		// maximise
		
		driver.manage().window().maximize();
	
		
	}
	@Test
	public void abc() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.get("http://103.211.39.246/ranford2");
	
	}
	@Test
	public void bcd() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.get("http://www.google.com");
	
	}
	
	@AfterMethod
    public void pqr() throws InterruptedException
    {
    	
    	Thread.sleep(3000);
    	
       driver.close();
    	
    }
}
