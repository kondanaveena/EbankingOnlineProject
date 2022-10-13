package com.ebanking.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewBranchEntry
{
	@FindBy(xpath="//*[@id=\"txtbName\"]")
	WebElement Brname;
	
	@FindBy(id="txtAdd1")
	WebElement Add1;
	
	@FindBy(id="txtZip")
	WebElement Zipcode;
	
	@FindBy(xpath="//*[@id=\"lst_counrtyU\"]")
	WebElement Country;
	
	@FindBy(xpath="//*[@id=\"lst_stateI\"]")
	WebElement State;
	
	@FindBy(xpath="//*[@id=\"lst_cityI\"]")
	WebElement City;
	
	@FindBy(xpath="//*[@id=\"btn_insert\"]")
	WebElement Bsubmit;
	
	@FindBy(xpath="//*[@id=\"Btn_Reset\"]")
	WebElement Breset;
	
	@FindBy(xpath="//*[@id=\"Btn_cancel\"]")
	WebElement Bcancel;
	
	//Element Methods
	
	public void BCreation(String Bn,String Ad, String Zi, String Co, String St, String Ci) throws InterruptedException
	{
		Brname.sendKeys(Bn);
		Add1.sendKeys(Ad);
		Zipcode.sendKeys(Zi);
		
		Select Ctry=new Select(Country);
		Ctry.selectByVisibleText(Co);
		
		Select Sta=new Select(State);
		Sta.selectByVisibleText(St);
		
		Select Cty=new Select(City);
		Cty.selectByVisibleText(Ci);
		
		Thread.sleep(3000);
		Bsubmit.click();
		
	}
	
	

}
