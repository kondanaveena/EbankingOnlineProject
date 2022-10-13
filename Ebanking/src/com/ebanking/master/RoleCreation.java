package com.ebanking.master;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RoleCreation 

{
	
	//Element properties
	
	@FindBy(xpath="//*[@id=\"txtRname\"]")
	WebElement Rname;
	
	@FindBy(xpath="//*[@id=\"lstRtypeN\"]")
	WebElement Rtype;
	
	@FindBy(xpath="//*[@id=\"btninsert\"]")
	WebElement RSubmit;
	
	//Element methods
	
	public void Rcr(String Rn, String Rt) throws InterruptedException
	{
		Rname.sendKeys(Rn);
		Select Rty=new Select(Rtype);
		Rty.selectByVisibleText(Rt);
		Thread.sleep(3000);
		
		RSubmit.click();
	}

}
