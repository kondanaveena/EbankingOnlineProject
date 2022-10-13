package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Instance class
		
				Library LB=new Library();
				LB.OpenApp("http://103.211.39.246/ranford2");
				LB.AdminLogin("Admin", "mq@system$");
				
				
				
				// To get Test Data File
				
				FileInputStream FIS=new FileInputStream("D:\\EvngAugLiveProject\\Ebanking\\src\\com\\ebanking\\testdata\\Employee.xlsx");
				
				// WorkBook
				
				XSSFWorkbook WB=new XSSFWorkbook(FIS);
				
				//Sheet
				
				XSSFSheet WS=WB.getSheet("Edata");
				
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
					XSSFCell WC2=WR.getCell(2);
					XSSFCell WC3=WR.getCell(3);
					
					
					XSSFCell WC4=WR.createCell(4);
					
					//Cell values
					
					String Employername=WC.getStringCellValue();
					String LoginPwd= WC1.getStringCellValue();
					String Rolename= WC2.getStringCellValue();
					String Brname=WC3.getStringCellValue();
					
					String Res3=LB.Empcreation( Employername,LoginPwd,Rolename,Brname);
					
					WC4.setCellValue(Res3);

	}
				//Results
				
				FileOutputStream Fos=new FileOutputStream("D:\\EvngAugLiveProject\\Ebanking\\src\\com\\ebanking\\results\\Employeeresult.xlsx");
				WB.write(Fos);
				WB.close();

}
}
