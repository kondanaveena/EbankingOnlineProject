package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSd 

{
	WebDriver driver;
	@Given("^User Should on Ranford HP$")
	public void User_Should_on_Ranford_HP() throws Throwable
	{
		 driver=new FirefoxDriver();
		//Maximise
		
		driver.manage().window().maximize();
		//URL
		
		driver.get("http://103.211.39.246/ranford2");
	}
	
	@When("^User Enters \"(.*)\" and \"(.*)\" click on Login$")
	public void user_Enters_UserName_Password_and_click_on_Login(String Un, String Pwd) throws Throwable 
	{
		driver.findElement(By.id("txtuId")).sendKeys(Un);
		driver.findElement(By.id("txtPword")).sendKeys(Pwd);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"login\"]")).click();
		
		
	}
	
	
	
	@Then("^User Validates Admin Login$")
	public void User_Validates_Admin_Login()
	{
		
		String Expval="welcome to admin";
		
		String Actval=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
		//Comparison
		

		if(Expval.equalsIgnoreCase(Actval))
		{
			System.out.println("Admin login page Succeessfully");
		}
		else
		{
			System.out.println("Admin login page Failed ");
		}
		
	}
}
