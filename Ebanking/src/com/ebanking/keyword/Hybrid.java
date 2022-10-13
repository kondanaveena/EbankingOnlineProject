package com.ebanking.keyword;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Hybrid 
{

	public static void main(String[] args) throws IOException, InterruptedException {
		
		// Instance class
		
				Lib LB=new Lib();
				String Res=null;
			    String Hpath="D:\\EvngAugLiveProject\\Ebanking\\src\\com\\ebanking\\keyword\\keyword_data.xlsx";
				
			    String Hout="D:\\EvngAugLiveProject\\Ebanking\\src\\com\\ebanking\\keyword\\keywordRes_data.xlsx";
			    
			    FileInputStream fi=new FileInputStream(Hpath);
			    
			    //workbook
			    XSSFWorkbook wb=new XSSFWorkbook(fi);
			    
			    // Sheet
			    
			    XSSFSheet ws=wb.getSheet("Testcase");
			    XSSFSheet ws1=wb.getSheet("TestSteps");
			    
			    //XSSFSheet ws2=wb.getSheet("TestData");
			    
			    //Row Count
			    
			    int tcRc=ws.getLastRowNum();
			    System.out.println(tcRc);
			    
			    int tsRc=ws1.getLastRowNum();
			    System.out.println(tsRc);
			    
			    //Test cases
			    
			    for (int i=1;i<=tcRc;i++)
			    {
			    	String exe=ws.getRow(i).getCell(2).getStringCellValue();
			    	if(exe.equalsIgnoreCase("Y"))
			    	{
			    		
			    		String tcId=ws.getRow(i).getCell(0).getStringCellValue();
			    		System.out.println(tcId);
			    		
			    		//test steps
			    		
			    		for (int j=1;j<=tsRc;j++)
			    		{
			    			
			    			String tsTcid=ws1.getRow(j).getCell(0).getStringCellValue();
			    			//System.out.println(tsTcid);
			    			if(tcId.equalsIgnoreCase(tsTcid))
			    			{
			    				String key=ws1.getRow(j).getCell(3).getStringCellValue();
			    				System.out.println(key);
			    				
			    				switch(key)
			    				{
			    				case "RLanch":
			    					Res=LB.openApp("http://103.211.39.246/ranford2");
			    					break;
			    				case "RLogin":
			    					Res=LB.AdmLgn("Admin","mq@system$");
			    					break;
			    					
			    				case "RLogout":
			    					LB.admlgt();
			    					break;
			    				case "RBranch":
			    					LB.branch();
			    					break;
			    				case "RRole":
			    					
			    					FileInputStream Fis=new FileInputStream("D:\\EvngAugLiveProject\\Ebanking\\src\\com\\ebanking\\testdata\\Role.xlsx");
			    					
			    					// WorkBook
			    					
			    					XSSFWorkbook WB=new XSSFWorkbook(Fis);
			    					
			    					//Sheet
			    					
			    					XSSFSheet WS=WB.getSheet("Rdata");
			    					
			    					//Row Count
			    					
			    					int Rcount=WS.getLastRowNum();
			    					System.out.println(Rcount);
			    					
			    					//Multiple iterations
			    					
			    					for (int k=1;k<=Rcount;k++)
			    					{
			    						
			    						//Row
			    						
			    						XSSFRow WR=WS.getRow(k);
			    						
			    						//cells
			    						
			    						XSSFCell WC=WR.getCell(0);
			    						XSSFCell WC1=WR.getCell(1);
			    						
			    						XSSFCell WC2=WR.createCell(2);
			    						
			    						//Cell values
			    						
			    						String Rname=WC.getStringCellValue();
			    						String Rtype= WC1.getStringCellValue();
			    						
			    						
			    					Res=LB.Role(Rname,Rtype);
			    					}
			    					break;
			    				case "RClose":
			    					LB.Appc();
			    					break;
			    				default:
			    					System.out.println("Pass a valid Keyword");
			    					break;
			    				}
			    					
			    				
			    			//result updation in test steps sheet
			    				ws1.getRow(j).createCell(4).setCellValue(Res);
			    				
			    				//result updation in test case sheet
			    				
			    				if(!ws1.getRow(j).getCell(4).getStringCellValue().equalsIgnoreCase("Fail"))
			    				{
			    					ws.getRow(i).createCell(3).setCellValue(Res);
			    				}
			    				else
			    				{
			    					ws.getRow(i).createCell(3).setCellValue("Fail");
			    				}
			    			}
			    		}
			    	}
			    	
			    	else
			    	{
			    		ws.getRow(i).createCell(3).setCellValue("BLOCKED");
			    		
			    	}
			    }
			    
			    FileOutputStream fo=new FileOutputStream(Hout);
			    wb.write(fo);
			    wb.close();
			    
			    

			}


	}


