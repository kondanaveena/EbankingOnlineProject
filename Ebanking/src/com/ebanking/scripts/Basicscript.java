package com.ebanking.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Basicscript {

	public static void main(String[] args) throws InterruptedException{
		
		String Expval="Ranford Bank";
	
//Launch Browser
		WebDriver driver=new FirefoxDriver();
		//Maximise
		
		driver.manage().window().maximize();
		//URL
		
		driver.get("http://103.211.39.246/ranford2");
		
		String Actval=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
		
		//comparision
		if(Expval.equalsIgnoreCase(Actval))
		{
			System.out.println("Application Lunch Succeessfully");
		}
		else
		{
			System.out.println("Application Launch Failed ");
		}
		//get title
		
		String Tit=driver.getTitle();
		System.out.println(Tit);
		//Admin login
		
		Expval="welcome to admin";
		
		
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("mq@system$");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		
		Actval=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		
		if(Expval.equalsIgnoreCase(Actval))
		{
			System.out.println("Admin login page Succeessfully");
		}
		else
		{
			System.out.println("Admin login page Failed ");
		}
		
		// Branch creation
		
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
		
		
		// Role Creation
		
		Expval="Sucessfully";
		
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
		
		driver.findElement(By.id("BtnRoles")).click();
		
		driver.findElement(By.id("txtRname")).sendKeys("supervisior");
		
		driver.findElement(By.id("txtRDesc")).sendKeys("managing work");
		Select Catgry=new Select(driver.findElement(By.xpath("//*[@id=\"lstRtypeN\"]")));
		Catgry.selectByVisibleText("E");
		
		driver.findElement(By.id("btninsert")).click();
		
		//Alert
		Actval=driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		
		//comparision
		
		if(Actval.contains(Expval))
		{
			System.out.println("Role created successfully");
			
		}
		else
		{
			System.out.println("Role already existed");
		}
		
		driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
		
		//Employee Creation
		
		Expval="Successfully";
		
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[8]/td/a/img")).click();
		
		driver.findElement(By.xpath("//*[@id=\"BtnNew\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"txtUname\"]")).sendKeys("cristine");
		
		driver.findElement(By.xpath("//*[@id=\"txtLpwd\"]")).sendKeys("@2georga");
		
		Select Role=new Select(driver.findElement(By.xpath("//*[@id=\"lst_Roles\"]")));
		Role.selectByVisibleText("supervisior");
		
		Select Brch=new Select(driver.findElement(By.xpath("//*[@id=\"lst_Branch\"]")));
			Brch.selectByVisibleText("higginsact");
		
			driver.findElement(By.id("BtnSubmit")).click();
			
			//Alert
			
			Actval=driver.switchTo().alert().getText();
			
			driver.switchTo().alert().accept();
			
		// comparision
			
			if(Actval.contains(Expval))
			{
				System.out.println("Employee created successfully");
				
			}
			else
			{
				System.out.println("Employee already existed");
			}
			
			driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
			
			driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[4]/table/tbody/tr/td[3]/a/img")).click();
			
			
			// Banker login
			
			Expval="Welcome to higginsact Branch";
			
			Select Brname=new Select(driver.findElement(By.xpath("//*[@id=\"drlist\"]")));
			Brname.selectByVisibleText("higginsact");
			
			driver.findElement(By.xpath("//*[@id=\"txtuId\"]")).sendKeys("cristine");
			
			driver.findElement(By.xpath("//*[@id=\"txtPword\"]")).sendKeys("@2georga");
			
			Thread.sleep(3000);
			
			
			driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
			
			Actval=driver.findElement(By.xpath("//*[@id=\"Label1\"]")).getText();
			
			if(Expval.equalsIgnoreCase(Actval))
			{
				System.out.println("Banker login page Succeessfully");
			}
			else
			{
				System.out.println("Banker login page Failed ");
			}
			
			driver.findElement(By.xpath("//*[@id=\"IMG1\"]")).click();
			
	}

}
