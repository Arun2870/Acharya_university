package com.AcharyaUniversity_ERP.Pageobject;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.AcharyaUniversity_ERP.Utility.ExplicitwaitMethods;
import com.AcharyaUniversity_ERP.Utility.Readconfig;
import com.AcharyaUniversity_ERP.Utility.ReuseMethods;

public class JobApplicationPage_University {
	public  WebDriver driver;
	public  ExplicitwaitMethods wait;
	public ReuseMethods reuse;

	public JobApplicationPage_University(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"root\"]//div[4]/button[2]")
	public WebElement employee;

	@FindBy(xpath = "//div[text()='HR Support']")
	public WebElement Hrsupport;
	
	@FindBy(xpath = "//div[text()='Job Portal']")
	public WebElement jobportal;
	
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
	public WebElement applicantsearchfield;
	
	
	public void LandingonJobportalpage() throws InterruptedException
	{
		wait = new ExplicitwaitMethods(driver);
		
		wait.clickOnElement(employee, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		Actions act = new Actions(driver);
		act.moveToElement(Hrsupport).click().perform();
		
		wait.clickOnElement(jobportal, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);	
		
        Readconfig read = new Readconfig();
		
		applicantsearchfield.sendKeys(read.applicant_search_field());
		
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
	
		applicantsearchfield.sendKeys(read.applicant_search_field());

		Thread.sleep(3000);
		 wait = new ExplicitwaitMethods(driver);
		 wait.clickOnElement(HRSplusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		 
		 
		 wait.clickOnElement(status, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		
		List<WebElement> stadropdowns = driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li"));
		
	wait.selectdropdownwithnoselecttag(stadropdowns, "Shortlisted" , 3000);
		
		
	WebElement ele1 = driver.findElement(By.xpath("//textarea[@name='description']"));
	ele1.click();
	
	ele1.sendKeys(Keys.CONTROL + "a");
	ele1.sendKeys(Keys.DELETE);
	ele1.sendKeys("candidate shortlisted");
 
	driver.findElement(By.xpath("//button[text()='Update']")).click();  // update button
	
	String Hrsstatus = HRStatus.getText();
	System.out.println(Hrsstatus);
	
	Assert.assertEquals(Hrsstatus, "Shortlisted");
	
	}
	
	
	
	public void Scheduling_interview() throws ParseException
	{
		wait = new ExplicitwaitMethods(driver);
		wait.clickOnElement(Interviewplusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		

	for(int i=0; i<1; i++)
	{		
	WebElement element = driver.findElement(By.xpath("(//div[@class=\"MuiFormControl-root MuiFormControl-fullWidth MuiTextField-root css-feqhe6\"]/div/div/span)[1]"));
		
	if(element.getText() != null)
	{
		
	WebElement crossmark = 	driver.findElement(By.xpath("(//*[@data-testid=\"CloseIcon\"])[2]"));
	
	Actions act = new Actions(driver);
	act.moveToElement(crossmark).click().perform();	
		
	}
		
		
		wait.clickOnElement(interviewer, 3000);
	
		interviewer.sendKeys("divyakumari@acharya.ac.in");
		interviewer.sendKeys(Keys.ARROW_DOWN);
		interviewer.sendKeys(Keys.ENTER);

		wait.clickOnElement(interviewer, 3000);
		interviewer.sendKeys("arun2870@acharya.ac.in");
		interviewer.sendKeys(Keys.ARROW_DOWN);
		interviewer.sendKeys(Keys.ENTER);
		
		wait.clickOnElement(interviewer, 3000);
		interviewer.sendKeys("kaushal12@acharya.ac.in");
		interviewer.sendKeys(Keys.ARROW_DOWN);
		interviewer.sendKeys(Keys.ENTER);
		
	}	
			
		commonmethod(position, "Librarian");
		
		wait.clickOnElement(interview_date, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		
    WebElement PenIcon =  driver.findElement(By.xpath("//*[@data-testid=\"PenIcon\"]"));// pencil icon
	wait.displayStatusOfElement(PenIcon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
    wait.clickOnElement(PenIcon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
    
   
    WebElement date = 	driver.findElement(By.xpath("//*[@placeholder=\"dd/mm/yyyy hh:mm (a|p)m\"]"));
    date.sendKeys(Keys.CONTROL + "a");
    date.sendKeys(Keys.DELETE);
    date.sendKeys("candidate shortlisted");
    
    date.sendKeys(ReuseMethods.getthefreshdatewithHrs()); //enter date
	 
	WebElement okbutton = driver.findElement(By.xpath("//button[text()='OK']"));
	wait.displayStatusOfElement(okbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.clickOnElement(okbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement Comments = driver.findElement(By.name("comments"));
	Comments.sendKeys(Keys.CONTROL + "a");
	Comments.sendKeys(Keys.DELETE);
	Comments.sendKeys("candidate shortlisted");
	
	
	
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
	wait = new ExplicitwaitMethods(driver);
	
	wait.clickOnElement(Resultplusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement inter1 = driver.findElement(By.xpath("(//textarea)[1]"));
	inter1.sendKeys(Keys.CONTROL + "a");
	inter1.sendKeys(Keys.DELETE);
	inter1.sendKeys("ok with candidate");
	
	WebElement Submit1 = driver.findElement(By.xpath("(//button[text()='Submit'])[1]"));
	wait.clickOnElement(Submit1, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	

	WebElement inter2 = driver.findElement(By.xpath("(//textarea)[3]"));
	inter2.sendKeys(Keys.CONTROL + "a");
	inter2.sendKeys(Keys.DELETE);
	inter2.sendKeys("ok ok with candidate");
	
	WebElement Submit2	= driver.findElement(By.xpath("(//button[text()='Submit'])[2]"));
	wait.clickOnElement(Submit2, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement inter3 = driver.findElement(By.xpath("(//textarea)[5]"));
	inter3.sendKeys(Keys.CONTROL + "a");
	inter3.sendKeys(Keys.DELETE);
	inter3.sendKeys("ok ok ok with candidate");
	
	WebElement Submit3 = driver.findElement(By.xpath("(//button[text()='Submit'])[3]"));
	wait.clickOnElement(Submit3, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement Hrcomment = driver.findElement(By.xpath("(//textarea)[7]"));
	Hrcomment.sendKeys(Keys.CONTROL + "a");	
	Hrcomment.sendKeys(Keys.DELETE);
	Hrcomment.sendKeys("Yes with candidate");
	
	WebElement Submit4 = driver.findElement(By.xpath("(//button[text()='Submit'])[4]"));
	wait.clickOnElement(Submit4, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	//pdf file attach
	
	WebElement pdfattach = driver.findElement(By.xpath("//input[@type=\"file\"]"));
	wait.waitForVisibilityOfElement(pdfattach, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	wait.typeTextIntoElement(pdfattach, "C:\\Users\\admin\\eclipse-workspace\\AcharyaUniversity_ERP\\TestData\\Testing blank document.pdf", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement totalmarksfor60 =  driver.findElement(By.xpath("//input[@name=\"marks\"]"));
	wait.typeTextIntoElement(totalmarksfor60, "60", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	
    // here it is redirecting to dashboardpage after clicking it should be on the result page only
    
	WebElement submitbutton =   driver.findElement(By.xpath("//h6"));
	wait.clickOnElement(submitbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement selected = driver.findElement(By.xpath("//button[text()='Selected']"));
	wait.clickOnElement(selected, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement yesbutton = 	driver.findElement(By.xpath("//strong[text()='Yes']"));
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
		remarks.sendKeys(Keys.CONTROL + "a");	
		remarks.sendKeys(Keys.DELETE);
		wait.typeTextIntoElement(remarks, "testing from erp", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
				
		WebElement fromdatefield	 = driver.findElement(By.xpath("(//input[@aria-label=\"Choose date\"])[1]"));
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
		basic.sendKeys(Keys.CONTROL + "a");	
		basic.sendKeys(Keys.DELETE);
		 wait.typeTextIntoElement(basic, "3000", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		 WebElement specialpay = driver.findElement(By.xpath("//*[@name=\"spl_1-lumpsum\"]"));
		 specialpay.sendKeys(Keys.CONTROL + "a");	
		 specialpay.sendKeys(Keys.DELETE);
		 wait.typeTextIntoElement(specialpay, "2000", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		 WebElement travellingallow = 	driver.findElement(By.xpath("//*[@name='ta-lumpsum']"));
		 travellingallow.sendKeys(Keys.CONTROL + "a");	
		 travellingallow.sendKeys(Keys.DELETE);
		 wait.typeTextIntoElement(travellingallow, "1000", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
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
	
	
	
	public void validatingofferletter()
	{
		 wait = new ExplicitwaitMethods (driver);
		 wait.clickOnElement(offerletter, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		 
		 reuse = new ReuseMethods(driver);
		 reuse. downloadtospecificpath();
		 
		// wait.clickOnElement(downloadbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);	 
		
	}
	
	
	public void job_offer()
	{
		wait = new ExplicitwaitMethods (driver);
		
		wait.clickOnElement(Job_offer, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
			
		WebElement reporting_to = driver.findElement(By.xpath("//*[@aria-autocomplete=\"list\"]"));	
		
		commonmethod(reporting_to, "kaushal12@acharya.ac.in");
		
		WebElement dateof_joining = driver.findElement(By.xpath("//*[@aria-readonly=\"true\"]"));
		wait.clickOnElement(dateof_joining, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		
		WebElement PenIcon = driver.findElement(By.xpath("//*[@data-testid=\"PenIcon\"]"));
		wait.clickOnElement(PenIcon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		
		WebElement dateof_joining_inpopup =	driver.findElement(By.xpath("//*[@type=\"tel\"]"));
		dateof_joining_inpopup.sendKeys(Keys.CONTROL + "a");	
		dateof_joining_inpopup.sendKeys(Keys.DELETE);		
		dateof_joining_inpopup.sendKeys("20/04/2024");
		
		WebElement ok =	driver.findElement(By.xpath("//*[text()='OK']"));
		wait.clickOnElement(ok, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		WebElement comments = 	driver.findElement(By.xpath("//*[@name=\"comments\"]"));
		comments.sendKeys(Keys.CONTROL + "a");	
		comments.sendKeys(Keys.DELETE);
		comments.sendKeys("Yes with candidate");
		
		
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
	 commonmethod(LEAVEApprover2, "hanumanthab@acharya.ac.in");
	 
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
	 
	// WebElement Recruit =  driver.findElement(By.xpath("//*[text()='Recruit']"));
	// wait.clickOnElement(Recruit, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
	
	}

	public void commonmethod(WebElement ele,String str) 
	{
		 wait = new ExplicitwaitMethods (driver);
		
		wait.clickOnElement(ele, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);	

		String text;

		do {
			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);

			text = ele.getAttribute("value");

			if (text.equals(str)) {
				break;
			} else {
				wait.clickOnElement(ele, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
			}
		} while (!text.isEmpty());
	}
        
	
		}
	

	
	

