package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Instance class
		
		Library LB=new Library();
		LB.OpenApp("http://103.211.39.246/ranford2");
		LB.AdminLogin("Admin", "mq@system$");

		// To get Test Data File
		
		FileInputStream FIS=new FileInputStream("D:\\EvngAugLiveProject\\Ebanking\\src\\com\\ebanking\\testdata\\Branches.xlsx");
	
		// WorkBook
		
				XSSFWorkbook WB=new XSSFWorkbook(FIS);
				
				//Sheet
				
				XSSFSheet WS=WB.getSheet("Bdata");
				
	
				//Row Count
				
				int Rcount=WS.getLastRowNum();
				System.out.println(Rcount);
				//multiple iterations
				
				for (int i=1;i<=Rcount;i++)
				{
					
					//Row
					
					XSSFRow WR=WS.getRow(i);
					
					//cells
					
					XSSFCell WC=WR.getCell(0);
					XSSFCell WC1=WR.getCell(1);
					XSSFCell WC2=WR.getCell(2);
					XSSFCell WC3=WR.getCell(3);
					XSSFCell WC4=WR.getCell(4);
					XSSFCell WC5=WR.getCell(5);
					
					XSSFCell WC6=WR.createCell(6);
					
					//Cell values
					
					String Brname=WC.getStringCellValue();
					String Add= WC1.getStringCellValue();
					
					String Zip= WC2.getStringCellValue();
					String Country= WC3.getStringCellValue();
					String State= WC4.getStringCellValue();
					String Cty= WC5.getStringCellValue();
					
					String Res1=LB.Brcreation( Brname,Add,Zip,Country,State,Cty);
					
					WC6.setCellValue(Res1);
				}
				//Results
				
				FileOutputStream Fos=new FileOutputStream("D:\\EvngAugLiveProject\\Ebanking\\src\\com\\ebanking\\results\\Branchesresult.xlsx");
				WB.write(Fos);
				WB.close();
					
	
	
	}

}
