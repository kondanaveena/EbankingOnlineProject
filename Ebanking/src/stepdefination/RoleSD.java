package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RoleSD 
{
	WebDriver driver;
	
	@Given("^Tester Should on Ranford Home Page$")
	public void tester_Should_on_Ranford_Home_Page() throws Throwable 
	{
		
		 driver=new FirefoxDriver();
			//Maximise
			
			driver.manage().window().maximize();
			//URL
			
			driver.get("http://103.211.39.246/ranford2");
		}
	
	@When("^Tester enters \"(.*)\" and \"(.*)\" click on Login$")
	public void tester_enters_Username_and_Password_click_on_Login(String Un, String Pwd) throws Throwable
	{
	    
	driver.findElement(By.id("txtuId")).sendKeys(Un);
	driver.findElement(By.id("txtPword")).sendKeys(Pwd);
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
	
	}
	
	@Then("^Tester Click on Role button$")
	public void tester_Click_on_Role_button() throws Throwable 
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[4]/td/a/img")).click();
	}

	@When("^Tester click on New Role and enter \"(.*)\" and \"(.*)\"$")
	public void tester_click_on_New_Role_and_enter_and(String Rname, String Rtype) throws Throwable 
	{
        driver.findElement(By.id("BtnRoles")).click();
		
		driver.findElement(By.id("txtRname")).sendKeys(Rname);
		driver.findElement(By.id("lstRtypeN")).click();
		
		driver.findElement(By.id("lstRtypeN")).sendKeys(Rtype);
		
		
		driver.findElement(By.id("btninsert")).click();
		driver.switchTo().alert().accept();
		
	}
	@When("^Tester Close the Application$")
	public void tester_Close_the_Application() throws Throwable 
	{
	    Thread.sleep(3000);
	    driver.close();
	}

	
}
