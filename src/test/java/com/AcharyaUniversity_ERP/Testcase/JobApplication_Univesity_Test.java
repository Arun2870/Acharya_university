package com.AcharyaUniversity_ERP.Testcase;

import org.testng.annotations.Test;

import java.awt.AWTException;
import java.text.ParseException;
import java.time.Duration;

import org.testng.annotations.Test;

import com.AcharyaUniversity_ERP.Pageobject.JobApplicationPage_University;
import com.AcharyaUniversity_ERP.Pageobject.LoginFunctionalitypage_University;

public class JobApplication_Univesity_Test extends BaseClass_University  {
	
	public JobApplicationPage_University page;
	LoginFunctionalitypage_University login;
	

	@Test
	public void jobapplication() throws InterruptedException, ParseException, AWTException 
	{  
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
			login = new LoginFunctionalitypage_University(driver);
			
			page = new JobApplicationPage_University(driver);	
			
			//login.visitsite();

			login.username();

			log.info("username is passed");

			login.password();

			log.info("password is passed");
			
			login.Login();
			
			log.info("clicked on login");
						
			Thread.sleep(3000);
			
			page.LandingonJobportalpage();	
	       page.updating_HR_status();
			page.Scheduling_interview();
		 
	       		
	}
	
/*	public void jobapplicatiobn() throws InterruptedException  
	{
		
			login = new LoginFunctionalitypage_University(driver);
			
			page = new JobApplicationPage_University(driver);	
			
			//login.visitsite();

			login.username();

			log.info("username is passed");

			login.password();

			log.info("password is passed");

			login.Login();

			log.info("clicked on login");
			
			page.LandingonJobportalpage();
		
		   // page.Result();
			//page.salaryBreakUp();
			//page.validatingofferletter();
			//page.job_offer();
			//page.FixedTerm_Recruitment();
			
		
	          page.salaryBreakUp_validation () ;
	       		
	}
	*/
	
	
}
