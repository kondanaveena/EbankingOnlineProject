package com.ebanking.keyword;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

public class Lib 
{
	public static Properties Pr;
    public static FileInputStream Fis;
	public static WebDriver driver;
	public static String Expval,Actval;

	public String openApp(String Url) throws IOException
	{
		String Expval="Ranford Bank";
		driver=new FirefoxDriver();
			driver.get(Url);
		
		String Actval=driver.findElement(By.xpath(".//*[@id='Form1']/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();	
				System.out.println(Actval);
		if (Expval.equalsIgnoreCase(Actval)) 
		{
		System.out.println("Application is launched");
		return "pass";
		}
		else
		{
			System.out.println("Application not opened");
			return "fail";
		}
	}
	public String AdmLgn(String Un,String Pwd)
	{
		Expval="Welcome to Admin";
		driver.manage().window().maximize();
		driver.findElement(By.id("txtuId")).sendKeys(Un);
		driver.findElement(By.id("txtPword")).sendKeys(Pwd);
		driver.findElement(By.id("login")).click();
		
		Actval=driver.findElement(By.xpath("html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		System.out.println(Actval);
		//driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
	if (Expval.equalsIgnoreCase(Actval)) 
	{
	System.out.println("adminhome is displayed");
	return "pass";
	}
	else
	{
		System.out.println("adminhome is not displayed");
	return "fail";
	}
		}

	public String Role(String RN,String RT)
	{
		Expval="Sucessfully";
		
		driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
		driver.findElement(By.xpath(".//*[@id='btnRoles']")).click();
		driver.findElement(By.id("txtRname")).sendKeys(RN);
		driver.findElement(By.id("lstRtypeN")).click();
		driver.findElement(By.id("lstRtypeN")).sendKeys(RT);
		driver.findElement(By.xpath(".//*[@id='btninsert']")).click();
		
		String Actval=driver.switchTo().alert().getText();
		
		System.out.println(Actval);
		
		
	      driver.switchTo().alert().accept();
	      driver.findElement(By.xpath(".//*[@id='Table_01']/tbody/tr/td[1]/a/img")).click();  
	      if (Actval.contains(Expval)) 
	      {
	    	  System.out.println("Role Created");
	    	  return "Pass";
			
		}
	      else{
	    	  System.out.println("role not created");
	    	  return "Fail";
	      }
	      
	     }

	     public void branch() throws InterruptedException
	     {
	    	 Expval="Sucessfully";
	 		
	 		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/a/img")).click();
	 		driver.findElement(By.id("BtnNewBR")).click();
	 		
	 		driver.findElement(By.id("txtbName")).sendKeys("higginsact");
	 		driver.findElement(By.id("txtAdd1")).sendKeys("fullagarcrescent");
	 		driver.findElement(By.id("txtZip")).sendKeys("45366");
	 		
	 		//Drop Down
	 		Select Ctry=new Select(driver.findElement(By.xpath("//*[@id=\"lst_counrtyU\"]")));
	 		Ctry.selectByVisibleText("INDIA");
	 		
	 		Select St=new Select(driver.findElement(By.xpath("//*[@id=\"lst_stateI\"]")));
	 		St.selectByVisibleText("GOA");
	 		
	 		Select City= new Select(driver.findElement(By.xpath("//*[@id=\"lst_cityI\"]")));
	 		City.selectByVisibleText("GOA");
	 		
	 		driver.findElement(By.id("btn_insert")).click();
	 		
	 		
	 		//Alert
	 		Actval=driver.switchTo().alert().getText();
	 		
	 		driver.switchTo().alert().accept();
	 		
	 		
	 		//comparision
	 		
	 		
	 		if(Actval.contains(Expval))
	 		{
	 			System.out.println("Branch created successfully");
	 			
	 		}
	 		else
	 		{
	 			System.out.println("Branch already existed");
	 		}
	 		
	 		driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
	 		
	 		
	      }
	     public void admlgt()
	     
	     {
	    	 driver.findElement(By.xpath(".//*[@id='Table_02']/tbody/tr/td[3]/a/img")).click();
	    	 
	    	 }

	     public void Appc()
	     {
	    	 driver.close();
	     }

	}