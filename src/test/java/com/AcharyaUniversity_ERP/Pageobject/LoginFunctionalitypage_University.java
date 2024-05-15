package com.AcharyaUniversity_ERP.Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AcharyaUniversity_ERP.Utility.ExplicitwaitMethods;
import com.AcharyaUniversity_ERP.Utility.Readconfig;

public class LoginFunctionalitypage_University 
{
public WebDriver driver;
Readconfig read = new  Readconfig();
ExplicitwaitMethods	wait;

	public LoginFunctionalitypage_University(WebDriver driver)
	{
		this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement Loginbutton;
	
	@FindBy(xpath = "//button")
	WebElement visitsite;
	
	
	public void visitsite()
	{
	wait = new ExplicitwaitMethods(driver);
	wait.clickOnElement(visitsite, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void username()
	{
		wait = new ExplicitwaitMethods(driver);
		wait.typeTextIntoElement(username, read.getusername(), ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	}
	
	public void password()
	{
		wait = new ExplicitwaitMethods(driver);
		wait.typeTextIntoElement(password, read.getpassword(), ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	}
	
	public void Login()
	{
		wait = new ExplicitwaitMethods(driver);
		wait.waitForVisibilityOfElement(Loginbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		 wait.clickOnElement(Loginbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
}

