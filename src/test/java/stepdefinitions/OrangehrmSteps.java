package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangehrmSteps 
{	
	public WebDriver driver;

	@Given("^I open browser with url \"([^\"]*)\"$")
	public void i_open_browser_with_url(String url)  
	{
		System.setProperty("webdriver.gecko.driver","d:\\geckodriver.exe");		
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url); 
	    
	}

	@Then("^I should see Login Page$")
	public void i_should_see_Login_Page() 
	{
		if (driver.findElement(By.id("btnLogin")).isDisplayed()) 
		   {
			System.out.println("Application Launched Successfully");
		} else 
		{
			System.out.println("Application Launch Failed");
		}
	    
	}

	@When("^I enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String uname) 
	{
	 
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
	}

	@When("^I enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String pword) 
	{
		driver.findElement(By.id("txtPassword")).sendKeys(pword);
	}

	@When("^I click Login$")
	public void i_click_Login() 
	{
		driver.findElement(By.id("btnLogin")).click();
	}

	
	@Then("^I should see Admin Module$")
	public void i_should_see_Admin_Module() 
	{
		if (driver.findElement(By.linkText("Admin")).isDisplayed()) 
	    {
	    	System.out.println("Admin Login Successful");
		} else 
		{
			System.out.println("Admin Login Failed");
		}
		
	}
	
	@When("^I close browser$")
	public void i_close_browser() 
	{
	    driver.close();
	}
	
	@Then("^I should see Error Message$")
	public void i_should_see_Error_Message() 
	{
	    String errmsg=driver.findElement(By.id("spanMessage")).getText();
	    if(errmsg.toLowerCase().contains("invalid"))
	    {
	    	System.out.println("Admin Login Test Pass for invalid Data");
	    }else
	    {
	    	System.out.println("Admin Login Test fail for invalid Data");
	    }
	}
	
}
