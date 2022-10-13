package com.ebanking.master;

import java.io.IOException;

public class Exelibrary {

	public static void main(String[] args) throws InterruptedException, IOException {
		// Instance class
		
		Library LB=new Library();
		
		String Rval =LB.OpenApp("http://103.211.39.246/ranford2");
		System.out.println(Rval);
		
		 Rval=LB.AdminLogin("Admin","mq@system$");
		
		System.out.println(Rval);
		
		Rval=LB.Brcreation("turneract","hawker","45366","INDIA","GOA","GOA");
		System.out.println(Rval);
		
		 Rval=LB.Rolecreation("trainer","E");
		System.out.println(Rval);
		
		Rval=LB.Empcreation("cristine","@2georga","supervisior","turneract");
		
		System.out.println(Rval);
		LB.AdminLogout();
		
		Rval=LB.Bankerlogin("turneract","cristine","@2georga");
		System.out.println(Rval);

	}

}
