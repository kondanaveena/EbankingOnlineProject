package com.ebanking.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class Pomexe
{
	WebDriver driver;
	@BeforeTest
     
	public void Alogin() throws InterruptedException
	{
	    driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://103.211.39.246/ranford2");
		
		//Login
		
		RanfordHP RHP=PageFactory.initElements(driver,RanfordHP.class);
		RHP.Login();
		Thread.sleep(3000);
	}
		//Branch
		@AfterTest
		public void Brcr(String Brname, String Add, String Zip, String Country, String State, String Cty) throws InterruptedException
		{
			
		// branch
		AdminHP AHP=PageFactory.initElements(driver,AdminHP.class);
		AHP.Br();
		
				
		NewBranchB NBB=PageFactory.initElements(driver,NewBranchB.class);
		NBB.Brb();
		
		NewBranchEntry NBE=PageFactory.initElements(driver,NewBranchEntry.class);
		NBE.BCreation(Brname,Add,Zip,Country,State,Cty);
		
		//Alert
		driver.switchTo().alert().accept();
		NBB.Bho();
		
		}
		//Roles
		
		@Test(dataProvider="Rdata")
		
		public void Rolecre(String Rname,String Rtype) throws InterruptedException 
		{
			//role
			
			AdminHP AHP=PageFactory.initElements(driver,AdminHP.class);
		AHP.Role();
		 Thread.sleep(3000);
		 
		 // new role
		 
		 RolesDetails RD=PageFactory.initElements(driver,RolesDetails.class);
		 RD.NewRole();
		 
		 //role creation
		 RoleCreation RC=PageFactory.initElements(driver,RoleCreation.class);
		 RC.Rcr(Rname,Rtype);
		 		
		 
		 //alert
		 driver.switchTo().alert().accept();
		 RD.RoleHome();
		}
		
		@DataProvider
		
		public Object[][] Rdata()
		{
			Object[][] Obj=new Object[3][2];
			
			Obj[0][0]="Cashierreddyaus";
			Obj[0][1]="E";
			
			Obj[1][0]="Managerraus";
			Obj[1][1]="E";
			
			Obj[2][0]="Informeraus";
			Obj[2][1]="E";
			
			return Obj;
			
		}
		 //Employee
		//public void Empcr() throws InterruptedException
		//{
		//AdminHP AHP=PageFactory.initElements(driver,AdminHP.class);
		 //AHP.Emp();
		 //Thread.sleep(3000);
		 
		 //New Employee
		 
		 //EmployeeDetails ED=PageFactory.initElements(driver,EmployeeDetails.class);
		 //ED.NewEmployee();
		 
		 //Employee Creation
		 //EmployeeCreation EC=PageFactory.initElements(driver,EmployeeCreation.class);
		 //EC.ECreation();
		 
		 //Alert
		 //driver.switchTo().alert().accept();
		 //ED.EmployeeHome();
		 
		 
		 
		 
		 
		
	}
//}
