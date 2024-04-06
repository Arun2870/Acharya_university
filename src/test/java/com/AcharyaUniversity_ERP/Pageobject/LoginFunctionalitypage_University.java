package com.AcharyaUniversity_ERP.Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AcharyaUniversity_ERP.Utility.Readconfig;

public class LoginFunctionalitypage_University 
{
public WebDriver driver;
Readconfig read = new  Readconfig();

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
		visitsite.click();
	}
	
	public void username()
	{
		username.sendKeys(read.getusername());
	}
	
	public void password()
	{
		password.sendKeys(read.getpassword());
	}
	
	public void Login()
	{
		Loginbutton.click();
	}
	
}

