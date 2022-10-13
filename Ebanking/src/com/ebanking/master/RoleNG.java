package com.ebanking.master;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RoleNG extends Base
{
	@Test(dataProvider="Rdata")
	public void Rol(String Rname,String Rtype) throws InterruptedException, IOException
	{
		LB.Rolecreation(Rname,Rtype);
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
}
