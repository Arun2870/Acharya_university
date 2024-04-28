package com.AcharyaUniversity_ERP.Pageobject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.AcharyaUniversity_ERP.Utility.ExplicitwaitMethods;
import com.AcharyaUniversity_ERP.Utility.Readconfig;
import com.AcharyaUniversity_ERP.Utility.ReuseMethods;

public class JobApplicationPage_University {
	public static  WebDriver driver;
	public static  ExplicitwaitMethods wait;
	public ReuseMethods reuse;

	public JobApplicationPage_University(WebDriver driver) {
		JobApplicationPage_University.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"root\"]//div[4]/button[2]")
	public static WebElement employee;

	@FindBy(xpath = "//div[text()='HR Support']")
	public static WebElement Hrsupport;
	
	@FindBy(xpath = "//div[text()='Job Portal']")
	public static WebElement jobportal;
	
	@FindBy(xpath = "//div[@role=\"grid\"]")
	public WebElement table;
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div")
	public List<WebElement> sheetrows;
	
	@FindBy(xpath = "//p[@class='MuiTablePagination-displayedRows css-1knho5n']")
	public WebElement totalrows;
	
	@FindBy(xpath = "//button[@title=\"Go to next page\"]")
	public WebElement nextpage;
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[1]/div[6]/button")
	public WebElement HRSplusicon;
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[1]/div[7]/div")
	public WebElement HRStatus;
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[1]/div[8]/button")
	public WebElement Interviewplusicon;
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[1]/div[9]/button")
	public WebElement Resultplusicon;
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[1]/div[10]/button")
	public WebElement salaryBreakUp_Plusicon;
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[1]/div[12]/button")
	public WebElement Job_offer;
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[1]/div[13]/button")
	public WebElement Recruitment;
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[1]/div[11]/button")
	public WebElement offerletter;
	
	@FindBy(id = "mui-component-select-hrStatus")
	public WebElement status;
	
	@FindBy(xpath = "(//input[@autocapitalize=\"none\"])[1]")
	public WebElement interviewer;
	
	@FindBy(xpath = "(//input[@autocapitalize=\"none\"])[2]")
	public WebElement position;
	
	@FindBy(xpath = "(//input[@aria-invalid=\"false\"])[3]")
	public WebElement interview_date;
	
	@FindBy(id = ":r34:")
	public WebElement comments;
	
	@FindBy(xpath = "//input[@type=\"search\"]")
	public static WebElement applicantsearchfield;
	
	@FindBy(xpath = "//div[@class=\"MuiFormControl-root MuiFormControl-fullWidth MuiTextField-root css-feqhe6\"]/div/div/span)[1]")
	public WebElement interviewervalue;
	
	@FindBy(xpath = "//textarea[@name='description']")
	public WebElement Hrstatuscomments;
	
	public static void LandingonJobportalpage() throws InterruptedException
	{
		wait = new ExplicitwaitMethods(driver);
		
		wait.clickOnElement(employee, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		Actions act = new Actions(driver);
		act.moveToElement(Hrsupport).click().perform();
		
		wait.clickOnElement(jobportal, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);	
		
       //Readconfig read = new Readconfig();
		
		//applicantsearchfield.sendKeys(read.applicant_search_field());
		
	}
	

	/*public void rowssize() throws InterruptedException, ParseException {
		
		wait = new ExplicitwaitMethods(driver);
		
		Thread.sleep(3000);
		
		String text = totalrows.getText();
		System.out.println(text);
		
		int inte = Integer.parseInt(text.substring(8));
		System.out.println(inte);
		
		//nextpage.click();
				
	}*/
	
	public void updating_HR_status() throws InterruptedException, ParseException
	{
		Readconfig read = new Readconfig();
		 wait = new ExplicitwaitMethods(driver);
		 
		 wait.typeTextIntoElement(applicantsearchfield, read.applicant_search_field(), ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		 	 		
		 wait.clickOnElement(HRSplusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		 	 
		 wait.clickOnElement(status, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		List<WebElement> stadropdowns = driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li"));
		
	wait.selectdropdownwithnoselecttag(stadropdowns, "Shortlisted" , 3000);		
	
	Thread.sleep(1500);
	 wait.clickOnElement(Hrstatuscomments, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	 wait.typeTextIntoElementforclearingtext(Hrstatuscomments, "candidate shortlisted", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

	 WebElement HrstatusUpdatebutton = driver.findElement(By.xpath("//button[text()='Update']"));  // update button
	 wait.clickOnElement(HrstatusUpdatebutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	String Hrsstatus = wait.getTextFromElement(HRStatus, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	System.out.println(Hrsstatus);
	
	Assert.assertEquals(Hrsstatus, "Shortlisted");
	
	}
	
	
	
	public void Scheduling_interview() throws ParseException
	{
		wait = new ExplicitwaitMethods(driver);
		wait.clickOnElement(Interviewplusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		for(int i=0; i<2; i++)
		{		
			wait.waitForVisibilityOfElement(interviewer, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
            wait.clickOnElement(interviewer, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
            wait.typeTextIntoElementactionclass(interviewer, "abcde13@acharya.ac.in", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
            wait.typeTextIntoElementactionclass(interviewer, "abcde15@acharya.ac.in", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
            wait.typeTextIntoElementactionclass(interviewer, "abcde30@acharya.ac.in", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
       	}
		
						
		commonmethod(position, "Librarian");
		
		wait.clickOnElement(interview_date, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);		
		
    WebElement PenIcon =  driver.findElement(By.xpath("//*[@data-testid=\"PenIcon\"]"));// pencil icon
	wait.displayStatusOfElement(PenIcon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
    wait.clickOnElement(PenIcon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
    
   
    WebElement date = 	driver.findElement(By.xpath("//*[@placeholder=\"dd/mm/yyyy hh:mm (a|p)m\"]"));
    wait.typeTextIntoElementforclearingtext(date, ReuseMethods.getthefreshdatewithHrs(), ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
    
	WebElement okbutton = driver.findElement(By.xpath("//button[text()='OK']"));
	wait.displayStatusOfElement(okbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.clickOnElement(okbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement Comments = driver.findElement(By.name("comments"));
	wait.typeTextIntoElementforclearingtext(Comments, "candidate shortlisted", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement savebutton = driver.findElement(By.xpath("//button[text()='Save']"));
	wait.displayStatusOfElement(savebutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.clickOnElement(savebutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement sendmailtointerviewer = driver.findElement(By.xpath("//button[text()=\"Send mail to Interviewer\"]"));
	wait.displayStatusOfElement(sendmailtointerviewer, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.clickOnElement(sendmailtointerviewer, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement yesbuttonforinterviewermail = driver.findElement(By.xpath("//strong[text() = 'Yes']"));
	wait.displayStatusOfElement(yesbuttonforinterviewermail, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.clickOnElement(yesbuttonforinterviewermail, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement candidatemail = driver.findElement(By.xpath("//button[text() = 'Send mail to Candidate']"));
	wait.displayStatusOfElement(candidatemail, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
    wait.clickOnElement(candidatemail, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
    WebElement yesbuttonforcandidatemail = driver.findElement(By.xpath("//strong[text()='Yes']"));
	wait.displayStatusOfElement(yesbuttonforcandidatemail, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.clickOnElement(yesbuttonforcandidatemail, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	
	//Result
	
	public void Result() throws InterruptedException 
	{
		
		 Readconfig read = new Readconfig();
		    
	applicantsearchfield.sendKeys(read.applicant_search_field());
	
	wait = new ExplicitwaitMethods(driver);
	
	wait.waitForVisibilityOfElement(Resultplusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.clickOnElement(Resultplusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement inter1 = driver.findElement(By.xpath("(//textarea)[1]"));
	wait.waitForVisibilityOfElement(inter1, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.typeTextIntoElementforclearingtext(inter1, "ok with candidate", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement Submit1 = driver.findElement(By.xpath("(//button[text()='Submit'])[1]"));
	wait.waitForVisibilityOfElement(Submit1, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.clickOnElement(Submit1, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement inter2 = driver.findElement(By.xpath("(//textarea)[3]"));
	wait.waitForVisibilityOfElement(inter2, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.typeTextIntoElementforclearingtext(inter2, "ok ok with candidate", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement Submit2	= driver.findElement(By.xpath("(//button[text()='Submit'])[2]"));
	wait.waitForVisibilityOfElement(Submit2, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.clickOnElement(Submit2, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement inter3 = driver.findElement(By.xpath("(//textarea)[5]"));
	wait.waitForVisibilityOfElement(inter3, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.typeTextIntoElementforclearingtext(inter3, "ok ok ok with candidate",ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME  );
	
	WebElement Submit3 = driver.findElement(By.xpath("(//button[text()='Submit'])[3]"));
	wait.waitForVisibilityOfElement(Submit3, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.clickOnElement(Submit3, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	Thread.sleep(1500);
	WebElement Hrcomment = driver.findElement(By.xpath("(//textarea)[7]"));
	wait.waitForVisibilityOfElement(Hrcomment, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.typeTextIntoElementforclearingtext(Hrcomment, "Yes with candidate", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME  );

	WebElement Submit4 = driver.findElement(By.xpath("(//button[text()='Submit'])[4]"));
	wait.waitForVisibilityOfElement(Submit4, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.clickOnElement(Submit4, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	//pdf file attach
	
	JavascriptExecutor je = (JavascriptExecutor)driver;
	je.executeScript("window.scrollBy(0,300)","");

	WebElement pdfattach = driver.findElement(By.xpath("//input[@type=\"file\"]"));
	pdfattach.sendKeys("C:\\Users\\arunn\\git\\Acharya_Uniersity_application\\TestData\\Testing blank document.pdf");
	//wait.typeTextIntoElement(pdfattach, "C:\\Users\\arunn\\git\\Acharya_Uniersity_application\\TestData\\Testing blank document.pdf", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement totalmarksfor60 =  driver.findElement(By.xpath("//input[@name=\"marks\"]"));
	wait.waitForVisibilityOfElement(totalmarksfor60, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.typeTextIntoElement(totalmarksfor60, "60", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement submitbutton =   driver.findElement(By.xpath("//h6"));
	wait.waitForVisibilityOfElement(submitbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.clickOnElement(submitbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	
    // here it is redirecting to dashboardpage after clicking it should be on the result page only
	
	JobApplicationPage_University.LandingonJobportalpage();
 
		applicantsearchfield.sendKeys(read.applicant_search_field());
		
		wait.clickOnElement(Resultplusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		je.executeScript("window.scrollBy(0,400)","");
	
	WebElement selected = driver.findElement(By.xpath("//button[text()='Selected']"));
	wait.waitForVisibilityOfElement(selected, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.clickOnElement(selected, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement yesbutton = 	driver.findElement(By.xpath("//strong[text()='Yes']"));
	wait.waitForVisibilityOfElement(yesbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.clickOnElement(yesbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	}
	
	public void salaryBreakUp() throws InterruptedException, ParseException
	{
		 wait = new ExplicitwaitMethods (driver);
		wait.waitForVisibilityOfElement(salaryBreakUp_Plusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		 wait.clickOnElement(salaryBreakUp_Plusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		//driver.navigate().refresh();
		
		 WebElement emptypefield = 	driver.findElement(By.id("mui-component-select-employeeType"));
		 wait.clickOnElement(emptypefield, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		List<WebElement> emptypevalues = driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li"));
		wait.selectdropdownwithnoselecttag(emptypevalues, "Fixed Term Recruitment", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		WebElement school = driver.findElement(By.xpath("(//input[@role=\"combobox\"])[1]"));
		
		commonmethod(school, "ACHARYA INSTITUTE OF TECHNOLOGY");
		
		WebElement Department = driver.findElement(By.xpath("(//*[@autocapitalize=\"none\"])[2]"));
		
		commonmethod(Department, "ERP");
		
	    WebElement Designation = driver.findElement(By.xpath("(//input[@role=\"combobox\"])[3]"));
		
		commonmethod(Designation, "Professor");
		
        WebElement jobtype = driver.findElement(By.xpath("(//input[@role=\"combobox\"])[4]"));
		
		commonmethod(jobtype, "Teaching Admin");
		
		WebElement remarks = driver.findElement(By.xpath("//textarea[@name=\"remarks\"]"));
		wait.typeTextIntoElement(remarks, "testing from erp", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
				
		WebElement fromdatefield = driver.findElement(By.xpath("(//input[@aria-label=\"Choose date\"])[1]"));
		 wait.clickOnElement(fromdatefield, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		
		 WebElement fromdatePenIcon =  driver.findElement(By.xpath("//*[@data-testid=\"PenIcon\"]"));
		 wait.clickOnElement(fromdatePenIcon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		 WebElement fromdatevalue =	driver.findElement(By.xpath("//*[@type=\"tel\"]"));
		 wait.typeTextIntoElement(fromdatevalue, ReuseMethods.getthefreshdate(), ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
				
		 WebElement fromdatevalueokbutton =  driver.findElement(By.xpath("//*[text()='OK']"));
		 wait.clickOnElement(fromdatevalueokbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
			
		 WebElement todatefield  =  driver.findElement(By.xpath("//input[@aria-label=\"Choose date\"]"));
		 wait.clickOnElement(todatefield, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
			
		 WebElement todatePenIcon =  driver.findElement(By.xpath("//*[@data-testid=\"PenIcon\"]"));
		 wait.clickOnElement(todatePenIcon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
				
		 WebElement todatevalue	= driver.findElement(By.xpath("//*[@type=\"tel\"]"));
		 wait.typeTextIntoElement(todatevalue, ReuseMethods.gettheafter184daysfreshdate(), ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
				 
		 WebElement todatokbutton	=  driver.findElement(By.xpath("//*[text()='OK']"));
		 wait.clickOnElement(todatokbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		WebElement salary_structure = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[5]"));
		
		commonmethod(salary_structure, "Special Salary Structure 4");
			
		WebElement basic = 	driver.findElement(By.xpath("//*[@name=\"basic-lumpsum\"]"));
		 wait.typeTextIntoElementforclearingtext(basic, "3000", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);	
	
		 WebElement specialpay = driver.findElement(By.xpath("//*[@name=\"spl_1-lumpsum\"]"));	
		 wait.typeTextIntoElementforclearingtext(specialpay, "2000", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		 WebElement travellingallow = 	driver.findElement(By.xpath("//*[@name='ta-lumpsum']"));
		 wait.typeTextIntoElementforclearingtext(travellingallow, "1000", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		 WebElement submitbutton =	driver.findElement(By.xpath("//button[text()='Submit']"));
		 wait.clickOnElement(submitbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		 WebElement generatectcbutton = driver.findElement(By.xpath("//*[text()='Generate CTC']"));
		 wait.displayStatusOfElement(generatectcbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		 wait.clickOnElement(generatectcbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		 WebElement Salarybreakup = driver.findElement(By.xpath("//button[text()='Salary Breakup']"));
		 wait.displayStatusOfElement(Salarybreakup, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		 wait.clickOnElement(Salarybreakup, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		 WebElement salarybreakupremarks = 	driver.findElement(By.xpath("//*[@name=\"remarks\"]"));
		 wait.typeTextIntoElement(salarybreakupremarks, "test", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		 WebElement salarybreakupsubmitbutton = driver.findElement(By.xpath("//button[text()='Submit']"));
		 wait.clickOnElement(salarybreakupsubmitbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		 WebElement salarybreakupyes = 	driver.findElement(By.xpath("//strong[text() = 'Yes']"));		
		 wait.clickOnElement(salarybreakupyes, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	}
	

	public void validatingofferletter() throws InterruptedException, AWTException
	{
		Readconfig read = new Readconfig();
		
		wait = new ExplicitwaitMethods (driver);
		 wait.clickOnElement(offerletter, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		 
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.urlContains(""));
		 
		Set<String> handels =  driver.getWindowHandles();
		
	Iterator<String> it = 	handels.iterator();
	String parentwindow = it.next();
	String childwindow = it.next();
	
	System.out.println(childwindow);
	

	 Thread.sleep(3000);
	 
	driver.switchTo().window(childwindow);
		 	
		Robot robot = new Robot();
		
		 Thread.sleep(1500);
		
	for(int i=0 ; i<=7; i++)
	{
		Thread.sleep(300);
		robot.keyPress(KeyEvent.VK_TAB);
	}
	
	robot.keyPress(KeyEvent.VK_ENTER);
	 
	for(int i=0 ; i<=2; i++)
	{
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
	}

	robot.keyPress(KeyEvent.VK_ENTER);     
	
	/* Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Clipboard clipboard = toolkit.getSystemClipboard();*/
	    
	    
	}
	

	public void job_offer() throws ParseException, InterruptedException
	{
       	
		wait = new ExplicitwaitMethods (driver);
		
		wait.clickOnElement(Job_offer, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);			
		WebElement reporting_to = driver.findElement(By.xpath("//*[@aria-autocomplete=\"list\"]"));	
		
		Thread.sleep(3000);
		commonmethod(reporting_to, "kaushal12@acharya.ac.in");
		
		WebElement dateof_joining = driver.findElement(By.xpath("//*[@aria-readonly=\"true\"]"));
		wait.clickOnElement(dateof_joining, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		
		WebElement PenIcon = driver.findElement(By.xpath("//*[@data-testid=\"PenIcon\"]"));
		wait.clickOnElement(PenIcon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		
		WebElement dateof_joining_inpopup =	driver.findElement(By.xpath("//*[@type=\"tel\"]"));
		wait.typeTextIntoElementforclearingtext(dateof_joining_inpopup, ReuseMethods.getthefreshdate() , ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
		
		WebElement ok =	driver.findElement(By.xpath("//*[text()='OK']"));
		wait.clickOnElement(ok, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		WebElement comments = 	driver.findElement(By.xpath("//*[@name=\"comments\"]"));
		wait.typeTextIntoElementforclearingtext(comments, "Yes with candidate", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
			
		WebElement save = driver.findElement(By.xpath("//*[text()='Save']"));
		wait.clickOnElement(save, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
		
		WebElement sendmail = driver.findElement(By.xpath("//*[text()=\"Send Mail\"]"));
		wait.clickOnElement(sendmail, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
		
		WebElement yes = driver.findElement(By.xpath("//strong[text()='Yes']"));
		wait.clickOnElement(yes, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
		
		WebElement accepted =	driver.findElement(By.xpath("//span[text()='Accepted']"));
		wait.clickOnElement(accepted, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );	
	}
	
	
	
	
	
	public void FixedTerm_Recruitment()
	{
		 Readconfig read = new Readconfig();
		    
			applicantsearchfield.sendKeys(read.applicant_search_field());
		
   wait = new ExplicitwaitMethods (driver);
   wait.clickOnElement(Recruitment, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
   
   WebElement applicantdetails_button = driver.findElement(By.xpath("//*[text()='Applicant Details']"));
  	wait.clickOnElement(applicantdetails_button, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
  	
  	WebElement crossbutton = driver.findElement(By.xpath("//*[@data-testid=\"HighlightOffIcon\"]"));
  	wait.clickOnElement(crossbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
  	
  	WebElement salary_breakup = driver.findElement(By.xpath("//*[text()='Salary Breakup']"));
  	wait.clickOnElement(salary_breakup, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
  	
	WebElement crossbutton_salarybreakup = driver.findElement(By.xpath("//*[@data-testid=\"HighlightOffIcon\"]"));
  	wait.clickOnElement(crossbutton_salarybreakup, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
  	
   WebElement alternae_phoneno = driver.findElement(By.xpath("//input[@name=\"alternatePhoneNumber\"]"));
	wait.clickOnElement(alternae_phoneno, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
	alternae_phoneno.sendKeys("9456214563");
	
	 WebElement Religion = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[6]"));
	 commonmethod(Religion, "Hinduism");
	
	 WebElement caste_category = driver.findElement(By.id("mui-component-select-caste"));
	 wait.clickOnElement(caste_category, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
	 
	List< WebElement> caste_category_dropdowns = driver.findElements(By.xpath("//*[@id=\"menu-caste\"]/div[3]/ul/li"));
	wait.selectdropdownwithnoselecttag(caste_category_dropdowns, "OBC", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
	
	 WebElement SHIFT = driver.findElement(By.xpath("(//*[@aria-autocomplete=\"list\"])[7]"));
	 commonmethod(SHIFT, "Shift 2(09:00:00-16:45:00)");
	 
	 WebElement LEAVEApprover1 = driver.findElement(By.xpath("(//*[@aria-autocomplete=\"list\"])[9]"));
	 commonmethod(LEAVEApprover1, "divyakumari@acharya.ac.in");
	
	 WebElement LEAVEApprover2 = driver.findElement(By.xpath("(//*[@aria-autocomplete=\"list\"])[10]"));
	 commonmethod(LEAVEApprover2, "arun2870@acharya.ac.in");
	 
	 WebElement procterhead = driver.findElement(By.xpath("(//*[@aria-autocomplete=\"list\"])[11]"));
	 commonmethod(procterhead, "Divya -AI00005-APS");
	 
	 WebElement bloodgroup = driver.findElement(By.xpath("//input[@name=\"bloodGroup\"]"));
	 bloodgroup.sendKeys("o-") ;
	 
	 WebElement panno = driver.findElement(By.name("panNo"));
	 panno.sendKeys("DFGLA9574L") ;
	 
	 WebElement aadharNumber = driver.findElement(By.name("aadharNumber"));
	 aadharNumber.sendKeys("6345289736587") ;
	 
	 WebElement uanNumber = driver.findElement(By.name("uanNumber"));
	 uanNumber.sendKeys("6345289736") ;
	 
	 WebElement preferredName = driver.findElement(By.name("preferredName"));
	 preferredName.sendKeys("ABC") ;
	 
	 WebElement comments = driver.findElement(By.name("comments"));
	 comments.sendKeys("TESTING FOR COMMENTS") ;
	 
	 WebElement phdstatus =  driver.findElement(By.id("mui-component-select-phdStatus"));
	 wait.clickOnElement(phdstatus, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );

	 List<WebElement> phdstatus_dropdowns = driver.findElements(By.xpath("//*[@id=\"menu-phdStatus\"]/div[3]/ul/li"));
	 wait.selectdropdownwithnoselecttag(phdstatus_dropdowns, "PhD Holder", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	 
	WebElement Recruit =  driver.findElement(By.xpath("//*[text()='Recruit']"));
	 wait.clickOnElement(Recruit, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
	
	}

	public void commonmethod(WebElement ele,String str) 
	{
		 wait = new ExplicitwaitMethods (driver);
		
		wait.clickOnElement(ele, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);	
		
		String text;

		do {
		
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);

			text = 	wait.getvalueFromElement(ele, "value", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
			
			if (text.equals(str)) {
				break;
			} else {
				wait.clickOnElement(ele, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
			}
		} while (!text.isEmpty());
	}
        
	
		}
	

	
	

