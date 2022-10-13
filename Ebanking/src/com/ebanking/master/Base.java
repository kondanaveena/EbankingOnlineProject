package com.ebanking.master;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.testng.annotations.AfterSuite;

public class Base {
	
	Library LB=new Library();
  
  @BeforeTest
  public void BeforeTest() throws InterruptedException, IOException
  {
	 LB.AdminLogin("Admin","mq@system$");
	  
  }

  @AfterTest
  public void AfterTest() throws IOException, InterruptedException 
  
  {
	  LB.AdminLogout();
	  
	  
	  
  }

  @BeforeSuite
  public void BeforeSuite() throws IOException 
  {
	  LB.OpenApp("http://103.211.39.246/ranford2");
	  
  }

  @AfterSuite
  public void AfterSuite() throws InterruptedException 
  {
	  
	LB.Adminclose();  
	  
  }

}
