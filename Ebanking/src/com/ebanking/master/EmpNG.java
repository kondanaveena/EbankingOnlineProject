package com.ebanking.master;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmpNG extends Base

{
	@Test(dataProvider="Edata")
	public void Employee(String Employername,String LoginPwd,String Rolename,String Brname) throws InterruptedException, IOException
	{
		LB.Empcreation(Employername,LoginPwd,Rolename,Brname);
	}
	
@DataProvider
	
	public Object[][] Edata()
	{
		Object[][] Obj=new Object[3][4];
		
		Obj[0][0]="Staciegordon";
		Obj[0][1]="Bentley";
		Obj[0][2]="Cashierreddyaus";
		Obj[0][3]="Mahatinagaraus";
		
		Obj[1][0]="Promilasharma";
		Obj[1][1]="Mounika";
		Obj[1][2]="Managerraus";
		Obj[1][3]="Sivapuramaus";
		

		Obj[2][0]="Shilpavala";
		Obj[2][1]="Sakshireddy";
		Obj[2][2]="Informeraus";
		Obj[2][3]="Nagireddypalli";
		
		return Obj;
		
	}

}
