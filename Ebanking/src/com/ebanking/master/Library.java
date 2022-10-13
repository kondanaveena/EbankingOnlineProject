package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Library {
	
	public static WebDriver driver;
	public static String Expval,Actval;
	public static FileInputStream FIS;
	public static Properties PR;
	
	
	public String OpenApp(String URL) throws IOException
	
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Parvatham\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		FIS=new FileInputStream("D:\\EvngAugLiveProject\\Ebanking\\src\\com\\ebanking\\properties\\Repository.properties");
		
		PR=new Properties();
		
		PR.load(FIS);
		
		Expval="Ranford Bank";
		
		//Launch Browser
				 driver=new FirefoxDriver();
				//Maximise
				
				driver.manage().window().maximize();
				//URL
				
				driver.get(URL);
				
				 Actval=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
				
				//comparision
				if(Expval.equalsIgnoreCase(Actval))
				{
					System.out.println("Application Lunch Succeessfully");
				}
				else
				{
					System.out.println("Application Launch Failed ");
				}
				return "Pass";
	}
	public String AdminLogin(String Uname, String Pwd) throws InterruptedException, IOException
	
	{
		
FIS=new FileInputStream("D:\\EvngAugLiveProject\\Ebanking\\src\\com\\ebanking\\properties\\Repository.properties");
		
		PR=new Properties();
		
		PR.load(FIS);
		
Expval="welcome to admin";
		
		
		driver.findElement(By.xpath(PR.getProperty("Uname"))).sendKeys(Uname);
		driver.findElement(By.xpath(PR.getProperty("Pwd"))).sendKeys(Pwd);
		
		
		
		driver.findElement(By.xpath(PR.getProperty("login"))).click();
		
		Actval=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		
		if(Expval.equalsIgnoreCase(Actval))
		{
			System.out.println("Admin login page Succeessfully");
		}
		else
		{
			System.out.println("Admin login page Failed ");
		}
		return Actval;
		
	}
	
	public String Brcreation(String Brname, String Add,String Zip, String Country, String State, String Cty) throws InterruptedException, IOException
	{
		
FIS=new FileInputStream("D:\\EvngAugLiveProject\\Ebanking\\src\\com\\ebanking\\properties\\Repository.properties");
		
		PR=new Properties();
		
		PR.load(FIS);
Expval="Sucessfully";
		
		driver.findElement(By.xpath(PR.getProperty("Bbutton"))).click();
		driver.findElement(By.id(PR.getProperty("Newbranch"))).click();
		
		driver.findElement(By.id(PR.getProperty("Brname"))).sendKeys(Brname);
		driver.findElement(By.id(PR.getProperty("Add"))).sendKeys(Add);
		driver.findElement(By.id(PR.getProperty("Zip"))).sendKeys(Zip);
		
		//Drop Down
		Select Ctry=new Select(driver.findElement(By.xpath(PR.getProperty("Country"))));
		Ctry.selectByVisibleText(Country);
		
		Select St=new Select(driver.findElement(By.xpath(PR.getProperty("State"))));
		St.selectByVisibleText(State);
		
		Select City= new Select(driver.findElement(By.xpath(PR.getProperty("Cty"))));
		City.selectByVisibleText(Cty);
		
		driver.findElement(By.id(PR.getProperty("Bbuttonsubmit"))).click();
		
		
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
		
		
		driver.findElement(By.xpath(PR.getProperty("BHomebutton"))).click();
		
		return Actval;
	}
	
	
	public String Rolecreation(String Rname,String Rtype) throws InterruptedException, IOException
	{
		
FIS=new FileInputStream("D:\\EvngAugLiveProject\\Ebanking\\src\\com\\ebanking\\properties\\Repository.properties");
		
		PR=new Properties();
		
		PR.load(FIS);
		
Expval="Sucessfully";
		
		driver.findElement(By.xpath(PR.getProperty("Rbutton"))).click();
		
		driver.findElement(By.id(PR.getProperty("Newrole"))).click();
		
		driver.findElement(By.id(PR.getProperty("Rname"))).sendKeys(Rname);
		
		//driver.findElement(By.id(PR.getProperty("Rdesc"))).sendKeys(Rdesc);
		Select Catgry=new Select(driver.findElement(By.xpath(PR.getProperty("Rtype"))));
		Catgry.selectByVisibleText(Rtype);
		
		driver.findElement(By.id(PR.getProperty("Rbuttonsubmit"))).click();
		
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
		
		driver.findElement(By.xpath(PR.getProperty("RHomebutton"))).click();
		return Actval;
		
	}
	public String Empcreation(String Employername, String LoginPwd, String Rolename, String Brname) throws InterruptedException, IOException
	{
		
FIS=new FileInputStream("D:\\EvngAugLiveProject\\Ebanking\\src\\com\\ebanking\\properties\\Repository.properties");
		
		PR=new Properties();
		
		PR.load(FIS);
Expval="Successfully";
		
		driver.findElement(By.xpath(PR.getProperty("Empbutton"))).click();
		
		driver.findElement(By.xpath(PR.getProperty("Newemployeebutton"))).click();
		driver.findElement(By.xpath(PR.getProperty("EmpUname"))).sendKeys(Employername);
	
		driver.findElement(By.xpath(PR.getProperty("Employeeloginpwd"))).sendKeys(LoginPwd);
		
		Select Role=new Select(driver.findElement(By.xpath(PR.getProperty("Rolename"))));
		Role.selectByVisibleText(Rolename);
		
		Select Brch=new Select(driver.findElement(By.xpath(PR.getProperty("Branchname"))));
			Brch.selectByVisibleText(Brname);
		
			driver.findElement(By.id(PR.getProperty("Ebuttonsubmit"))).click();
			
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
			
			driver.findElement(By.xpath(PR.getProperty("EHomebutton"))).click();
			
		return Actval;
	}
	
	
	
		public void AdminLogout() throws IOException, InterruptedException 
		
		{
			
			Thread.sleep(30000);
			driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[4]/table/tbody/tr/td[3]/a/img")).click();
		}
	
		
		
		public void Adminclose() throws InterruptedException
		
		{
			Thread.sleep(30000);
			driver.close();
		}
		
	public String Bankerlogin (String Branchname,String Username,String BankerPwd) throws InterruptedException, IOException
	{
		FIS=new FileInputStream("D:\\EvngAugLiveProject\\Ebanking\\src\\com\\ebanking\\properties\\Repository.properties");
		
		PR=new Properties();
		
		PR.load(FIS);
		
		
		Expval="Welcome to turneract Branch";
	
	Select Brname=new Select(driver.findElement(By.xpath(PR.getProperty("Bbranchlogin"))));
	Brname.selectByVisibleText(Branchname);
	
	driver.findElement(By.xpath(PR.getProperty("Bankerusername"))).sendKeys(Username);
	
	driver.findElement(By.xpath(PR.getProperty("Bankerpassword"))).sendKeys(BankerPwd);
	
	Thread.sleep(3000);
	
	
	driver.findElement(By.xpath(PR.getProperty("Bankerloginbutton"))).click();
	
	Actval=driver.findElement(By.xpath(PR.getProperty("Bankerbranchdisplay"))).getText();
	
	if(Expval.equalsIgnoreCase(Actval))
	{
		System.out.println("Banker login page Succeessfully");
	}
	else
	{
		System.out.println("Banker login page Failed ");
	}
	
	
	driver.findElement(By.xpath(PR.getProperty("Bankerlogoutbutton"))).click();
	return Actval;
}

	}
	
	


