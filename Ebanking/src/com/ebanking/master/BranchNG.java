package com.ebanking.master;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BranchNG extends Base

{
	@Test(dataProvider="Bdata")
	public void Branch(String Brname,String Add,String Zip,String Country, String State,String Cty) throws InterruptedException, IOException
	{
		LB.Brcreation(Brname,Add,Zip,Country,State,Cty);
		
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
