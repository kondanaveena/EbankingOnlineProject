package com.ebanking.master;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Excelwithpom 
{
	WebDriver driver;
	


     @BeforeTest
     public void Alogin() throws InterruptedException
     {
    	 driver=new FirefoxDriver();
 		driver.manage().window().maximize();
 		driver.get("http://103.211.39.246/ranford2");
 		 
     //PageFactory
 		
 		RanfordHP RHP=PageFactory.initElements(driver,RanfordHP.class);
		RHP.Login();
		Thread.sleep(3000);
	}
     @Test
     
     public void Rolecre() throws IOException, InterruptedException
     {
    	 
    	 // to get testdata excel file
    	 
    	 FileInputStream FIS=new FileInputStream("D:\\EvngAugLiveProject\\Ebanking\\src\\com\\ebanking\\testdata\\Role.xlsx");
 		
 		// WorkBook
 		
 		XSSFWorkbook WB=new XSSFWorkbook(FIS);
 		
 		//Sheet
 		
 		XSSFSheet WS=WB.getSheet("Rdata");
 		
 		//Row Count
 		
 		int Rcount=WS.getLastRowNum();
 		System.out.println(Rcount);
 		
 		//Multiple iterations
 		
 		for (int i=1;i<=Rcount;i++)
 		{
 			
 			//Row
 			
 			XSSFRow WR=WS.getRow(i);
 			
 			//cells
 			
 			XSSFCell WC=WR.getCell(0);
 			XSSFCell WC1=WR.getCell(1);
 			
 			XSSFCell WC2=WR.createCell(2);
 			
 			//Cell values
 			
 			String Rname=WC.getStringCellValue();
 			String Rtype= WC1.getStringCellValue();
 			
 			AdminHP AHP=PageFactory.initElements(driver,AdminHP.class);
 			AHP.Role();
 			 Thread.sleep(3000);
 			 
 			 // new role
 			 
 			RolesDetails RD=PageFactory.initElements(driver,RolesDetails.class);
 			 RD.NewRole();
 			 
 			 // role creation
 			 
 			RoleCreation RC=PageFactory.initElements(driver,RoleCreation.class);
 			 RC.Rcr(Rname,Rtype);
 			 
 			 // alert
 			driver.switchTo().alert().accept();
 			
 			// home
 			RD.RoleHome();
 			 
 			 
     }
     }
}
