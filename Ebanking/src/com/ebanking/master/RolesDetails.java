package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RolesDetails
{
	
	// Element Properties
	
	@FindBy(xpath="//*[@id=\"btnRoles\"]")
	WebElement NewRButton;
	
	@FindBy(xpath="/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")
	WebElement RHome;
	
	//Element Methods
	
	public void NewRole()
	{
		NewRButton.click();
		
	}
	public void RoleHome()
	
	{
		RHome.click();
	}

}
