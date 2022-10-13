package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EmployeeCreation 
{
	
	//Element Properties
	@FindBy(xpath="//*[@id=\"txtUname\"]")
	WebElement Employername;
	
	@FindBy(xpath="//*[@id=\"txtLpwd\"]")
	WebElement LoginPwd;
	
	@FindBy(xpath="//*[@id=\"lst_Roles\"]")
	WebElement Role;
	
	@FindBy(xpath="//*[@id=\"lst_Branch\"]")
	WebElement Branch;
	
	@FindBy(xpath="//*[@id=\"BtnSubmit\"]")
	WebElement ESubmit;
	
	//Element Methods
	
	public void ECreation()
	{
		Employername.sendKeys("siddeswari");
		LoginPwd.sendKeys("@2varunreddy");
		Select Rl=new Select(Role);
		Rl.selectByVisibleText("Speakerausbnk");
		Select Br=new Select(Branch);
		Br.selectByVisibleText("Vasanthanagar");
		ESubmit.click();
		
		
	}

}
