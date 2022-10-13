package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewBranchB 
{
	//Element Properties
	
	@FindBy(xpath=("//*[@id=\"BtnNewBR\"]"))
	WebElement NBbutton;
	
	@FindBy(xpath=("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img"))
	WebElement BHome;
	
	@FindBy(xpath=("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[3]/a/img"))
	WebElement Logobranch;
	
	//Element Methods
	
	public void Brb()
	{
		NBbutton.click();
	}
	public void Bho()
	{
		BHome.click();
	}
	public void LogBranch()
	{
		Logobranch.click();
	}

}
