package com.ebanking.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Notepad1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		//Instance class
		
				Library LB=new Library();
				LB.OpenApp("http://103.211.39.246/ranford2");
				LB.AdminLogin("Admin", "mq@system$");
				// to get test data file path
				
				String Fpath="D:\\EvngAugLiveProject\\Ebanking\\src\\com\\ebanking\\testdata\\Branches.txt";
				
				//to get results file path
				
				String Rpath="D:\\EvngAugLiveProject\\Ebanking\\src\\com\\ebanking\\results\\Branchesresult.txt";
				String SD;
				// to get test data file
				FileReader FR= new FileReader(Fpath);
				BufferedReader BR=new BufferedReader(FR);
				
				String Sread= BR.readLine();
				System.out.println(Sread);
				
				//Header in Results
				
				FileWriter FW=new FileWriter(Rpath);
				
				BufferedWriter BW=new BufferedWriter(FW);
				BW.write(Sread);
				BW.newLine();
				
				// Multiple iterations
				
				while((SD=BR.readLine())!=null)
				{
					System.out.println(SD);
					
					//Split
					
					String SR[]=SD.split("###");
					String Brname=SR[0];
					String Add=SR[1];
					String Zip=SR[2];
					String Country=SR[3];
					String State=SR[4];
					String Cty=SR[5];
					
					String Res1=LB.Brcreation(Brname,Add,Zip,Country,State,Cty);
					System.out.println(Res1);

					// Results
					BW.write(SD+"^$^%$&"+Res1);
					BW.newLine();
				}
				

				BW.close();
				BR.close();

				
				

	}

}
