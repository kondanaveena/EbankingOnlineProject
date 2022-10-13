package com.ebanking.master;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Bdataproviderwithpom 

{
	WebDriver driver;
	
@BeforeTest

public void Alogin() throws InterruptedException
{
   driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://103.211.39.246/ranford2");
	
	//page Factory
	
	//Login
	
			RanfordHP RHP=PageFactory.initElements(driver,RanfordHP.class);
			RHP.Login();
			Thread.sleep(3000);
			
			
}
@Test(dataProvider="Bdata")
public void Brcr(String Brname, String Add, String Zip, String Country, String State, String Cty) throws InterruptedException
{
	
// branch
AdminHP AHP=PageFactory.initElements(driver,AdminHP.class);
AHP.Br();

// New Branch

NewBranchB NBB=PageFactory.initElements(driver,NewBranchB.class);
NBB.Brb();

//Branch creation
NewBranchEntry NBE=PageFactory.initElements(driver,NewBranchEntry.class);
NBE.BCreation(Brname, Add, Zip,Country,State,Cty);

//Alert
		driver.switchTo().alert().accept();
		
		//Home
		
		NBB.Bho();
}
@DataProvider

public Object[][] Bdata()
{
	Object[][] Obj=new Object[3][6];
	
	Obj[0][0]="Mahatinagaraus";
	Obj[0][1]="dengatecrescent";
	Obj[0][2]="42364";
	Obj[0][3]="INDIA";
	Obj[0][4]="Andhra Pradesh";
	Obj[0][5]="Hyderabad";
	
	Obj[1][0]="Nagireddypalli";
	Obj[1][1]="srinivasanagar";
	Obj[1][2]="43652";
	Obj[1][3]="INDIA";
	Obj[1][4]="Andhra Pradesh";
	Obj[1][5]="secundarabad";
	
	Obj[2][0]="Sivapuramaus";
	Obj[2][1]="kalyananagar";
	Obj[2][2]="28647";
	Obj[2][3]="INDIA";
	Obj[2][4]="Andhra Pradesh";
	Obj[2][5]="Hyderabad";
	
	return Obj;
	
}
}


