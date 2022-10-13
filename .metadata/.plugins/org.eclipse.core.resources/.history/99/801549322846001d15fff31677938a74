package com.ebanking.master;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Grid {
	
	
	DesiredCapabilities Cap;
	@Parameters("Browser")
	@Test
	public void Gd(String Br) throws MalformedURLException, InterruptedException
	{
		
		if(Br.equalsIgnoreCase("firefox"))
		{
			
		
		Cap=new DesiredCapabilities();
		Cap.setBrowserName("firefox");
		Cap.setPlatform(Platform.WINDOWS);
		}
		else if (Br.equalsIgnoreCase("chrome"))
		{
			
			Cap=new DesiredCapabilities();
			Cap.setBrowserName("chrome");
			Cap.setPlatform(Platform.WINDOWS);
		}
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"),Cap);
	
	
	driver.manage().window().maximize();
	driver.get("http://103.211.39.246/ranford2");
	
	//Login
	
	RanfordHP RHP=PageFactory.initElements(driver,RanfordHP.class);
	RHP.Login();
	Thread.sleep(3000);
	//Role
	
	AdminHP AHP=PageFactory.initElements(driver,AdminHP.class);
	AHP.Role();
	 Thread.sleep(3000);
	 
	 // new role
	 
	 RolesDetails RD=PageFactory.initElements(driver,RolesDetails.class);
	 RD.NewRole();
	 
	 //role creation
	 RoleCreation RC=PageFactory.initElements(driver,RoleCreation.class);
	 RC.Rcr("Caretakeract","E");
	 		
	 
	 //alert
	 driver.switchTo().alert().accept();
	
}
}
