package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeDetails
{
	
	//Element Properties
	
	@FindBy(xpath="//*[@id=\"BtnNew\"]")
	WebElement NewEmp;
	
	@FindBy(xpath="/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")
	WebElement EmpHome;
	
	//Element Methods
	
	public void NewEmployee()
	{
		NewEmp.click();
	}
	public void EmployeeHome()
	{
		EmpHome.click();
	}

}
