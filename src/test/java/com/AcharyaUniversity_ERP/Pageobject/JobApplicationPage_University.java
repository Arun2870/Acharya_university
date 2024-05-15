package com.AcharyaUniversity_ERP.Pageobject;

import java.awt.AWTException;
import java.awt.Robot;
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
	public static WebDriver driver;
	public static ExplicitwaitMethods wait;
	Readconfig read = new Readconfig();;

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
	public static WebElement HRSplusicon;

	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[1]/div[7]/div")
	public WebElement HRStatus;

	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[1]/div[8]/button")
	public WebElement Interviewplusicon;

	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[1]/div[9]/button")
	public WebElement Resultplusicon;

	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[1]/div[10]/button")
	public static WebElement salaryBreakUp_Plusicon;

	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[1]/div[12]/button")
	public static WebElement Job_offer;

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

	@FindBy(xpath = "//*[@class = 'MuiTable-root css-1dnsaco']//tbody/tr/td[1]")
	public static List<WebElement> salarybreakupfields;

	@FindBy(xpath = "//*[@class = 'MuiTable-root css-1dnsaco']//tbody/tr/td[2]")
	public static List<WebElement> salarybreakupfieldvalues;

	public static void LandingonJobportalpage() throws InterruptedException {
		
		wait = new ExplicitwaitMethods(driver);
		driver.navigate().refresh();

		wait.clickOnElement(employee, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		Actions act = new Actions(driver);
		
		act.moveToElement(Hrsupport).click().perform();

		wait.clickOnElement(jobportal, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		Readconfig read = new Readconfig();

		applicantsearchfield.sendKeys(read.applicant_search_field());

	}

	/*
	 * public void rowssize() throws InterruptedException, ParseException {
	 * 
	 * wait = new ExplicitwaitMethods(driver);
	 * 
	 * Thread.sleep(3000);
	 * 
	 * String text = totalrows.getText(); System.out.println(text);
	 * 
	 * int inte = Integer.parseInt(text.substring(8)); System.out.println(inte);
	 * 
	 * //nextpage.click();
	 * 
	 * }
	 */

	public void updating_HR_status() throws InterruptedException, ParseException {
		
		 read = new Readconfig();
		wait = new ExplicitwaitMethods(driver);
		
		wait.clickOnElement(HRSplusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		wait.clickOnElement(status, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		List<WebElement> stadropdowns = driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li"));

		wait.selectdropdownwithnoselecttag(stadropdowns, "Shortlisted", 3000);

		Thread.sleep(1500);
		wait.clickOnElement(Hrstatuscomments, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		wait.typeTextIntoElementforclearingtext(Hrstatuscomments, "candidate shortlisted",
				ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement HrstatusUpdatebutton = driver.findElement(By.xpath("//button[text()='Update']")); // update button
		wait.clickOnElement(HrstatusUpdatebutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		String Hrsstatus = wait.getTextFromElement(HRStatus, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		System.out.println(Hrsstatus);

		Assert.assertEquals(Hrsstatus, "Shortlisted");

	}

	public void Scheduling_interview() throws ParseException, AWTException {
		
		wait = new ExplicitwaitMethods(driver);
		wait.clickOnElement(Interviewplusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		
		for (int i = 0; i<10; i++) 
		{
			wait.clickOnElement(interviewer, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
			Robot rb = new Robot();			
			rb.keyPress(KeyEvent.VK_BACK_SPACE);
		}

		for (int i = 0; i<1; i++) 
		{
			wait.waitForVisibilityOfElement(interviewer, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
			wait.clickOnElement(interviewer, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
			
			wait.typeTextIntoElementactionclass(interviewer, "abcde13@acharya.ac.in", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
			wait.typeTextIntoElementactionclass(interviewer, "abcde15@acharya.ac.in",ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
			wait.typeTextIntoElementactionclass(interviewer, "abcde30@acharya.ac.in",ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		}

		commonmethod(position, "Librarian");

		wait.clickOnElement(interview_date, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		/*WebElement PenIcon = driver.findElement(By.xpath("//*[@data-testid=\"PenIcon\"]"));// pencil icon
		wait.displayStatusOfElement(PenIcon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		wait.clickOnElement(PenIcon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);*/
		
		
		wait.
		

		WebElement date = driver.findElement(By.xpath("//*[@placeholder=\"dd/mm/yyyy hh:mm (a|p)m\"]"));
		wait.typeTextIntoElementforclearingtext(date, ReuseMethods.getthefreshdatewithHrs(), ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement okbutton = driver.findElement(By.xpath("//button[text()='OK']"));
		wait.displayStatusOfElement(okbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		wait.clickOnElement(okbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement Comments = driver.findElement(By.name("comments"));
		wait.typeTextIntoElementforclearingtext(Comments, "candidate shortlisted", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement savebutton = driver.findElement(By.xpath("//button[text()='Save']"));
		wait.displayStatusOfElement(savebutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		wait.clickOnElement(savebutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement sendmailtointerviewer = driver .findElement(By.xpath("//button[text()=\"Send mail to Interviewer\"]"));
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

	// Result

	public void Result() throws InterruptedException {

		read = new Readconfig();

		applicantsearchfield.sendKeys(read.applicant_search_field());

		wait = new ExplicitwaitMethods(driver);

		wait.waitForVisibilityOfElement(Resultplusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		wait.clickOnElement(Resultplusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		
		 Thread.sleep(3000);
		 WebElement inter1 = driver.findElement(By.xpath("(//textarea)[1]"));
		 wait.waitForVisibilityOfElement(inter1,ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		wait.typeTextIntoElementforclearingtext(inter1, "ok with candidate",ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		WebElement Submit1 = driver.findElement(By.xpath("(//button[text()='Submit'])[1]"));
		wait.waitForVisibilityOfElement(Submit1,ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		wait.clickOnElement(Submit1,ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		WebElement inter2 = driver.findElement(By.xpath("(//textarea)[3]"));
		wait.waitForVisibilityOfElement(inter2,ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		wait.typeTextIntoElementforclearingtext(inter2, "ok ok with candidate",ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		WebElement Submit2 = driver.findElement(By.xpath("(//button[text()='Submit'])[2]"));
		wait.waitForVisibilityOfElement(Submit2,ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME); 
		wait.clickOnElement(Submit2,ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		WebElement inter3 = driver.findElement(By.xpath("(//textarea)[5]"));
		wait.waitForVisibilityOfElement(inter3,ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		wait.typeTextIntoElementforclearingtext(inter3,"ok ok ok with candidate",ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
		
		WebElement Submit3 = driver.findElement(By.xpath("(//button[text()='Submit'])[3]"));
		wait.waitForVisibilityOfElement(Submit3,
		ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME); wait.clickOnElement(Submit3,
		 ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		WebElement inter4 = driver.findElement(By.xpath("(//textarea)[7]"));
		wait.waitForVisibilityOfElement(inter3,
		ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		wait.typeTextIntoElementforclearingtext(inter4,
		"ok ok ok ok with candidate",ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
		
		WebElement Submit4 = driver.findElement(By.xpath("(//button[text()='Submit'])[4]"));
		wait.waitForVisibilityOfElement(Submit4,
		ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME); wait.clickOnElement(Submit4,
		ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		Thread.sleep(1500); WebElement Hrcomment = driver.findElement(By.xpath("(//textarea)[9]"));
		wait.waitForVisibilityOfElement(Hrcomment,
		ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		wait.typeTextIntoElementforclearingtext(Hrcomment, "Yes with candidate",
		ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
		
		WebElement Submit5 = driver.findElement(By.xpath("(//button[text()='Submit'])[5]"));
		wait.waitForVisibilityOfElement(Submit5,
		ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME); wait.clickOnElement(Submit5,
		ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		//pdf file attach
		
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,300)","");
		
		WebElement pdfattach = driver.findElement(By.xpath("//input[@type=\"file\"]")); pdfattach.
		sendKeys("C:\\Users\\admin\\git\\Acharya_Uniersity_application\\TestData\\Testing blank document.pdf"); 
		
		wait.typeTextIntoElement(pdfattach,"C:\\Users\\arunn\\git\\Acharya_Uniersity_application\\TestData\\Testing blank document.pdf", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		WebElement totalmarksfor60 = driver.findElement(By.xpath("//input[@name=\"marks\"]"));
		wait.waitForVisibilityOfElement(totalmarksfor60,
		ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		wait.typeTextIntoElement(totalmarksfor60, "60",
		 ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		 
		 WebElement submitbutton = driver.findElement(By.xpath("//h6"));
		  wait.waitForVisibilityOfElement(submitbutton,
		ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		  wait.clickOnElement(submitbutton,
		  ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
		
		 // here it is redirecting to dashboardpage after clicking it should be on th result page only
		 
		 JobApplicationPage_University.LandingonJobportalpage();
		  
		  applicantsearchfield.sendKeys(read.applicant_search_field());
		 
		  wait.clickOnElement(Resultplusicon,
		 ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		 
		JavascriptExecutor je1 = (JavascriptExecutor) driver;
		je1.executeScript("window.scrollBy(0,300)", "");

		WebElement selected = driver.findElement(By.xpath("//button[text()='Selected']"));
		wait.waitForVisibilityOfElement(selected, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		wait.clickOnElement(selected, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement yesbutton = driver.findElement(By.xpath("//strong[text()='Yes']"));
		wait.waitForVisibilityOfElement(yesbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		wait.clickOnElement(yesbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void salaryBreakUp() throws InterruptedException, ParseException 
	{
		wait = new ExplicitwaitMethods(driver);
		wait.waitForVisibilityOfElement(salaryBreakUp_Plusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		wait.clickOnElement(salaryBreakUp_Plusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		// driver.navigate().refresh();

		WebElement emptypefield = driver.findElement(By.id("mui-component-select-employeeType"));
		wait.clickOnElement(emptypefield, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		List<WebElement> emptypevalues = driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li"));
		wait.selectdropdownwithnoselecttag(emptypevalues, "Fixed Term Recruitment",
				ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

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

		WebElement fromdatePenIcon = driver.findElement(By.xpath("//*[@data-testid=\"PenIcon\"]"));
		wait.clickOnElement(fromdatePenIcon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement fromdatevalue = driver.findElement(By.xpath("//*[@type=\"tel\"]"));
		wait.typeTextIntoElement(fromdatevalue, ReuseMethods.getthefreshdate(),
				ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement fromdatevalueokbutton = driver.findElement(By.xpath("//*[text()='OK']"));
		wait.clickOnElement(fromdatevalueokbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement todatefield = driver.findElement(By.xpath("//input[@aria-label=\"Choose date\"]"));
		wait.clickOnElement(todatefield, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement todatePenIcon = driver.findElement(By.xpath("//*[@data-testid=\"PenIcon\"]"));
		wait.clickOnElement(todatePenIcon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement todatevalue = driver.findElement(By.xpath("//*[@type=\"tel\"]"));
		wait.typeTextIntoElement(todatevalue, ReuseMethods.gettheafter184daysfreshdate(),
				ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement todatokbutton = driver.findElement(By.xpath("//*[text()='OK']"));
		wait.clickOnElement(todatokbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement salary_structure = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[5]"));

		commonmethod(salary_structure, "Special Salary Structure 4");

		WebElement basic = driver.findElement(By.xpath("//*[@name=\"basic-lumpsum\"]"));

		wait.typeTextIntoElementforclearingtext(basic, basicamount, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement specialpay = driver.findElement(By.xpath("//*[@name=\"spl_1-lumpsum\"]"));

		wait.typeTextIntoElementforclearingtext(specialpay, specialpayamount,
				ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement travellingallow = driver.findElement(By.xpath("//*[@name='ta-lumpsum']"));
		wait.typeTextIntoElementforclearingtext(travellingallow, travellingallowanceamount,
				ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement submitbutton = driver.findElement(By.xpath("//button[text()='Submit']"));
		wait.clickOnElement(submitbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement generatectcbutton = driver.findElement(By.xpath("//*[text()='Generate CTC']"));
		wait.displayStatusOfElement(generatectcbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		wait.clickOnElement(generatectcbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement Salarybreakup = driver.findElement(By.xpath("//button[text()='Salary Breakup']"));
		wait.displayStatusOfElement(Salarybreakup, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		wait.clickOnElement(Salarybreakup, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement salarybreakupremarks = driver.findElement(By.xpath("//*[@name=\"remarks\"]"));
		wait.typeTextIntoElement(salarybreakupremarks, "test", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement salarybreakupsubmitbutton = driver.findElement(By.xpath("//button[text()='Submit']"));
		wait.clickOnElement(salarybreakupsubmitbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement salarybreakupyes = driver.findElement(By.xpath("//strong[text() = 'Yes']"));
		wait.clickOnElement(salarybreakupyes, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	}

	// DA(Dear Allowance) = 50% of Basic
	static int DearAllowanceno = (50 * Readconfig.basicpay()) / 100;
	static String DearAllowanceamt = ReuseMethods.convetinginttostring(DearAllowanceno);

	// HRA(House rent allowance) = 40% of Basic
	static int Houserentallowanceno = (40 * 15000) / 100;
	static String HRAnoamt = ReuseMethods.convetinginttostring(Houserentallowanceno);

	// Gross earning = Basic + special pay + dear allowance + house rent +
	// Travelling allowance
	static int grossearno = 15000 + 5000 + DearAllowanceno + Houserentallowanceno + 2000;
	static String grossearamt = ReuseMethods.convetinginttostring(grossearno);

	// EPF employee contribution (for employee deduction) = 12%(basic+da)
	// if (Basic + DA) is greater than 15000 we apply 12%(limit value = 15000)
	// here greater than 15000 so 12%(15000)
	
	static int epfemployeno = (15000 * 12 )/ 100;
	static String epfemployeamt = ReuseMethods.convetinginttostring(epfemployeno);

	// EPF employer contribution (for employer management its like earning) =
	// 12%(basic+da)
	// if (Basic + DA) is greater than 15000 we apply 12%(limit value = 15000)
	// here greater than 15000 so 12%(15000)
	static int epfemployerno = (15000 * 12) / 100;
	static String epfemployeramt = ReuseMethods.convetinginttostring(epfemployerno);

	// ESI employee  0.75(basic+splpay+da+hra+ta)
	//if total of (basic+splpay+da+hra+ta) is greater than 21000 than esi is not applicable
	//if total of (basic+splpay+da+hra+ta) is lesser than 21000 than total*0.75/100 
	static double esiemployeeno = (15000 + 5000 + DearAllowanceno + Houserentallowanceno + 2000) * 0.75 / 100;
    static int totamt = (15000 + 5000 + DearAllowanceno + Houserentallowanceno + 2000);
    
    static double esiamtemployee  =  JobApplicationPage_University.checkingamtlimitvalue(totamt);
   
	static String esiemployeeamt = ReuseMethods.convetingdoubletostring(esiamtemployee);

	// ESI employer  3.25(basic+splpay+da+hra+ta)
	//if total of (basic+splpay+da+hra+ta) is greater than 21000 than esi is not applicable
		//if total of (basic+splpay+da+hra+ta) is lesser than 21000 than total*0.75/100

	static double esiemployerno = (15000 + 5000 + DearAllowanceno + Houserentallowanceno + 1000) * 3.25 / 100;
	
	
	static double esiamtemployer  =  JobApplicationPage_University.checkingamtlimitvalue(totamt);
	
	public static double checkingamtlimitvalue(int value)
	{	
	
		double esiempleamt = 0;
		
		for(int i=0; i<1; i++)	
		{
			double esiemployeeandemployeramt = 0 ;
			
			if(value<21000)
			{
				esiemployeeandemployeramt = totamt * 0.75 / 100;
			}
			else if(value>21000)			
			{
				esiemployeeandemployeramt = 0;
				
			}
		 esiempleamt = esiemployeeandemployeramt ;
		}
		return esiempleamt;	
	}
	
	static String esiemployeramt = ReuseMethods.convetingdoubletostring(esiamtemployer);
	
	
	
	// management contribution total
	static double managementcontotno = (esiamtemployer + epfemployerno);
	static String managementcontotamt = ReuseMethods.convetingdoubletostring(managementcontotno);

	// CTC (cost to company) = Gross earning + management contribution total
	static double ctcno = grossearno + (esiemployerno + epfemployerno);
	static String ctcamt = ReuseMethods.convetingdoubletostring(ctcno);

	// Net pay = gross earning – total deduction
	static double Netpayno = grossearno + (esiemployerno + epfemployerno);
	static String Netpayamt = ReuseMethods.convetingdoubletostring(Netpayno);

	static String basicamount = ReuseMethods.convetinginttostring(Readconfig.basicpay());
	static String specialpayamount = ReuseMethods.convetinginttostring(Readconfig.specialpay());
	static String DearAllowance = DearAllowanceamt;
	static String Houserentallowance = HRAnoamt;
	static String travellingallowanceamount = ReuseMethods.convetinginttostring(Readconfig.trallowance());
	static String Grossearning = grossearamt;
	static String managementtotal = managementcontotamt;
	static String EPFemployeecontribution = epfemployeamt;
	static String ProfessionalTax = "200";
	static String EPFemployercontribution = epfemployeramt;
	static String ESIemployee = esiemployeeamt;
	static String ESIemployer = esiemployeramt;
	static String PT = "200";
	static String costtocompany = ctcamt;
	static String Netpay = Netpayamt;

	public static void salaryBreakUp_validation() {
		
		wait = new ExplicitwaitMethods(driver);
		wait.waitForVisibilityOfElement(salaryBreakUp_Plusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		wait.clickOnElement(salaryBreakUp_Plusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		comnmethodtovalidatesalarybreakup("Basic", basicamount, "Basic");
		comnmethodtovalidatesalarybreakup("Special Pay", specialpayamount, "Special Pay");
		comnmethodtovalidatesalarybreakup("Dearness Allowance", DearAllowance, "Dearness Allowance");
		comnmethodtovalidatesalarybreakup("House Rent Allowance", Houserentallowance, "House Rent Allowance");
		comnmethodtovalidatesalarybreakup("Travelling Allowance", travellingallowanceamount, "Travelling Allowance");
		comnmethodtovalidatesalarybreakup("Gross Earning", Grossearning, "Gross Earning");
		comnmethodtovalidatesalarybreakup("EPF Employee Contribution", EPFemployeecontribution,
				"EPF Employee Contribution");

		// comnmethodtovalidatesalarybreakup("Professional Tax", "200", 7);
		// comnmethodtovalidatesalarybreakup("Total Deductions", "2000",8);

		comnmethodtovalidatesalarybreakup("EPF Employer Contribution", EPFemployercontribution, "EPF Employer Contribution");
		comnmethodtovalidatesalarybreakup("Total Management Contribution", managementtotal, "Total Management Contribution");
		comnmethodtovalidatesalarybreakup("Cost to Company", costtocompany, "Cost to Company");
		comnmethodtovalidatesalarybreakup("Net Pay", Netpay, "Net Pay");

	}

	public void validatingofferletter() throws InterruptedException, AWTException {
		Readconfig read = new Readconfig();

		wait = new ExplicitwaitMethods(driver);
		wait.clickOnElement(offerletter, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.urlContains(""));

		Set<String> handels = driver.getWindowHandles();

		Iterator<String> it = handels.iterator();
		String parentwindow = it.next();
		String childwindow = it.next();

		System.out.println(childwindow);

		Thread.sleep(3000);

		driver.switchTo().window(childwindow);

		Robot robot = new Robot();

		Thread.sleep(1500);

		for (int i = 0; i <= 7; i++) {
			Thread.sleep(300);
			robot.keyPress(KeyEvent.VK_TAB);
		}

		robot.keyPress(KeyEvent.VK_ENTER);

		for (int i = 0; i <= 2; i++) {
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_TAB);
		}

		robot.keyPress(KeyEvent.VK_ENTER);

	}

	public void job_offer() throws ParseException, InterruptedException {

		wait = new ExplicitwaitMethods(driver);

		wait.clickOnElement(Job_offer, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		WebElement reporting_to = driver.findElement(By.xpath("//*[@aria-autocomplete=\"list\"]"));

		Thread.sleep(3000);
		commonmethod(reporting_to, "kaushal12@acharya.ac.in");

		WebElement dateof_joining = driver.findElement(By.xpath("//*[@aria-readonly=\"true\"]"));
		wait.clickOnElement(dateof_joining, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement PenIcon = driver.findElement(By.xpath("//*[@data-testid=\"PenIcon\"]"));
		wait.clickOnElement(PenIcon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement dateof_joining_inpopup = driver.findElement(By.xpath("//*[@type=\"tel\"]"));
		wait.typeTextIntoElementforclearingtext(dateof_joining_inpopup, ReuseMethods.getthefreshdate(),
				ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement ok = driver.findElement(By.xpath("//*[text()='OK']"));
		wait.clickOnElement(ok, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement comments = driver.findElement(By.xpath("//*[@name=\"comments\"]"));
		wait.typeTextIntoElementforclearingtext(comments, "Yes with candidate",
				ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement save = driver.findElement(By.xpath("//*[text()='Save']"));
		wait.clickOnElement(save, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement sendmail = driver.findElement(By.xpath("//*[text()=\"Send Mail\"]"));
		wait.clickOnElement(sendmail, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement yes = driver.findElement(By.xpath("//strong[text()='Yes']"));
		wait.clickOnElement(yes, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement accepted = driver.findElement(By.xpath("//span[text()='Accepted']"));
		wait.clickOnElement(accepted, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void FixedTerm_Recruitment() {
		Readconfig read = new Readconfig();

		applicantsearchfield.sendKeys(read.applicant_search_field());

		wait = new ExplicitwaitMethods(driver);
		wait.clickOnElement(Recruitment, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement applicantdetails_button = driver.findElement(By.xpath("//*[text()='Applicant Details']"));
		wait.clickOnElement(applicantdetails_button, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement crossbutton = driver.findElement(By.xpath("//*[@data-testid=\"HighlightOffIcon\"]"));
		wait.clickOnElement(crossbutton, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement salary_breakup = driver.findElement(By.xpath("//*[text()='Salary Breakup']"));
		wait.clickOnElement(salary_breakup, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement crossbutton_salarybreakup = driver.findElement(By.xpath("//*[@data-testid=\"HighlightOffIcon\"]"));
		wait.clickOnElement(crossbutton_salarybreakup, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement alternae_phoneno = driver.findElement(By.xpath("//input[@name=\"alternatePhoneNumber\"]"));
		wait.clickOnElement(alternae_phoneno, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		alternae_phoneno.sendKeys("9456214563");

		WebElement Religion = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[6]"));
		commonmethod(Religion, "Hinduism");

		WebElement caste_category = driver.findElement(By.id("mui-component-select-caste"));
		wait.clickOnElement(caste_category, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		List<WebElement> caste_category_dropdowns = driver.findElements(By.xpath("//*[@id=\"menu-caste\"]/div[3]/ul/li"));
		wait.selectdropdownwithnoselecttag(caste_category_dropdowns, "OBC",ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement SHIFT = driver.findElement(By.xpath("(//*[@aria-autocomplete=\"list\"])[7]"));
		commonmethod(SHIFT, "Shift 2(09:00:00-16:45:00)");

		WebElement LEAVEApprover1 = driver.findElement(By.xpath("(//*[@aria-autocomplete=\"list\"])[9]"));
		commonmethod(LEAVEApprover1, "divyakumari@acharya.ac.in");

		WebElement LEAVEApprover2 = driver.findElement(By.xpath("(//*[@aria-autocomplete=\"list\"])[10]"));
		commonmethod(LEAVEApprover2, "arun2870@acharya.ac.in");

		WebElement procterhead = driver.findElement(By.xpath("(//*[@aria-autocomplete=\"list\"])[11]"));
		commonmethod(procterhead, "Divya -AI00005-APS");

		WebElement bloodgroup = driver.findElement(By.xpath("//input[@name=\"bloodGroup\"]"));
		bloodgroup.sendKeys("o-");

		WebElement panno = driver.findElement(By.name("panNo"));
		panno.sendKeys("DFGLA9574L");

		WebElement aadharNumber = driver.findElement(By.name("aadharNumber"));
		aadharNumber.sendKeys("6345289736587");

		WebElement uanNumber = driver.findElement(By.name("uanNumber"));
		uanNumber.sendKeys("6345289736");

		WebElement preferredName = driver.findElement(By.name("preferredName"));
		preferredName.sendKeys("ABC");

		WebElement comments = driver.findElement(By.name("comments"));
		comments.sendKeys("TESTING FOR COMMENTS");

		WebElement phdstatus = driver.findElement(By.id("mui-component-select-phdStatus"));
		wait.clickOnElement(phdstatus, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		List<WebElement> phdstatus_dropdowns = driver
				.findElements(By.xpath("//*[@id=\"menu-phdStatus\"]/div[3]/ul/li"));
		wait.selectdropdownwithnoselecttag(phdstatus_dropdowns, "PhD Holder",
				ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		WebElement Recruit = driver.findElement(By.xpath("//*[text()='Recruit']"));
		wait.clickOnElement(Recruit, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void commonmethod(WebElement ele, String str) {
		wait = new ExplicitwaitMethods(driver);

		wait.clickOnElement(ele, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

		String text;

		do {

			ele.sendKeys(Keys.ARROW_DOWN);
			ele.sendKeys(Keys.ENTER);

			text = wait.getvalueFromElement(ele, "value", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);

			if (text.equals(str)) {
				break;
			} else {
				wait.clickOnElement(ele, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
			}
		} while (!text.isEmpty());
	}

	public static String giverowno(String value) {
		WebElement table = driver.findElement(By.xpath("//table[@class=\"MuiTable-root css-1dnsaco\"]"));
		WebElement tbody = table.findElement(By.tagName("tbody"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		String rowno = "";

		for (int i = 0; i < rows.size(); i++) {
			WebElement row = tbody
					.findElement(By.xpath("//tbody[@class=\"MuiTableBody-root css-1xnox0e\"]/tr[" + (i + 1) + "]"));

			if (row.getText().trim().contains(value)) {
				rowno = Integer.toString(i + 1);
				break;
			}

		}

		return rowno;

	}

	public static String giveamtvalue(String value) {
		WebElement table = driver.findElement(By.xpath("//table[@class=\"MuiTable-root css-1dnsaco\"]"));
		WebElement tbody = table.findElement(By.tagName("tbody"));

		String rowno = JobApplicationPage_University.giverowno(value);

		int no = Integer.parseInt(rowno);

		String st = "";
		for (int i = 0; i < 1; i++) {

			WebElement row = tbody
					.findElement(By.xpath("//tbody[@class=\"MuiTableBody-root css-1xnox0e\"]/tr[" + no + "]"));

			if (row.getText().trim().contains(value)) {
				String str = row.getText();
				String ind = str.replace(value, "");
				st = ind.replaceAll("\\s", "");

			}

		}

		return st;
	}

	public static void comnmethodtovalidatesalarybreakup(String value, String expamtvalue, String val) {
		for (WebElement ele : salarybreakupfields) {
			if (ele.getText().equals(value)) {
				System.out.println("getting text from webelement " + ele.getText());
				System.out.println("for this  element " + value + " we are validing");
				System.out.println("expected amount " + expamtvalue);
				System.out.println("actual amount " + giveamtvalue(val));
				Assert.assertEquals(expamtvalue, giveamtvalue(val));

			}
		}
	}
}
