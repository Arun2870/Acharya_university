package com.AcharyaUniversity_ERP.Pageobject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AcharyaUniversity_ERP.Utility.ExplicitwaitMethods;

public class JobApplicationPage_University {
	public  WebDriver driver;
	public  ExplicitwaitMethods wait;

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
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[19]/div[6]/button")
	public WebElement HRSgreentick;
	
	@FindBy(id = "mui-component-select-hrStatus")
	public WebElement status;
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[19]/div[8]/button")
	public WebElement Interviewplusicon;
	
	@FindBy(xpath = "(//input[@autocapitalize=\"none\"])[1]")
	public WebElement interviewer;
	
	@FindBy(xpath = "(//input[@autocapitalize=\"none\"])[2]")
	public WebElement position;
	
	@FindBy(xpath = "//input[@aria-label=\"Choose date\"]")
	public WebElement interview_date;
	
	@FindBy(id = ":r34:")
	public WebElement comments;
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[19]/div[9]/button")
	public WebElement Resultplusicon;
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[19]/div[10]/button")
	public WebElement salaryBreakUp_Plusicon;
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[19]/div[12]/button")
	public WebElement Job_offer;
	
	public void employee() {
			
		employee.click();
		
		}
	
	public void Hrsupport() {
		
		Hrsupport.click();	
		
		}
	
   public void jobportal() {
		
	jobportal.click();	
	
		}

	public void rowssize() throws InterruptedException, ParseException {
		
		wait = new ExplicitwaitMethods(driver);
		
		Thread.sleep(3000);
		
		String text = totalrows.getText();
		System.out.println(text);
		
		int inte = Integer.parseInt(text.substring(8));
		System.out.println(inte);
		
		//nextpage.click();
		
	}
	
	public void updating_HR_status()
	{
		
		HRSgreentick.click();
		
		status.click();
		
		List<WebElement> stadropdowns = driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li"));
		
	wait.selectdropdownwithnoselecttag(stadropdowns, "Shortlisted" , 3000);
		
		
	WebElement ele1 = driver.findElement(By.xpath("//textarea[@name='description']"));
	ele1.click();
	
	ele1.sendKeys(Keys.CONTROL + "a");
	ele1.sendKeys(Keys.DELETE);
	ele1.sendKeys("candidate shortlisted");
 
	driver.findElement(By.xpath("//button[text()='Update']")).click();  // update button
	}
	
	public void Scheduling_interview()
	{
	 
	Interviewplusicon.click();
			
	//List<WebElement> mailids = driver.findElements(By.xpath("//label[@id=\":r2u:-label\"]//parent::div/div/div/span"));

	for(int i=0; i<1; i++)
	{	
		wait.clickOnElement(interviewer, 3000);
	
		interviewer.sendKeys("divyakumari@acharya.ac.in");
		interviewer.sendKeys(Keys.ARROW_DOWN);
		interviewer.sendKeys(Keys.ENTER);

		wait.clickOnElement(interviewer, 3000);
		interviewer.sendKeys("hanumanthab@acharya.ac.in");
		interviewer.sendKeys(Keys.ARROW_DOWN);
		interviewer.sendKeys(Keys.ENTER);
		
		wait.clickOnElement(interviewer, 3000);
		interviewer.sendKeys("kaushal12@acharya.ac.in");
		interviewer.sendKeys(Keys.ARROW_DOWN);
		interviewer.sendKeys(Keys.ENTER);
		
	}	
		
	
			
		commonmethod(position, "Professor");
		
		interview_date.click();
		
		
	
 driver.findElement(By.xpath("//*[@data-testid=\"PenIcon\"]")).click();// pencil icon
	
	 driver.findElement(By.xpath("//*[@placeholder=\"dd/mm/yyyy hh:mm (a|p)m\"]")).sendKeys("09/04/2024 02:00 AM"); //enter date
	 
	driver.findElement(By.xpath("//button[text()='OK']")).click();
	
	driver.findElement(By.name("comments")).sendKeys("testing for automation");
	
	driver.findElement(By.xpath("//button[text()='Save']")).click();
	
	driver.findElement(By.xpath("//button[text()=\"Send mail to Interviewer\"]")).click();
	
	driver.findElement(By.xpath("//strong[text() = 'Yes']")).click();
	
	WebElement candidatemail = driver.findElement(By.xpath("//button[text() = 'Send mail to Candidate']"));
	
wait.clickOnElement(candidatemail, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	driver.findElement(By.xpath("//strong[text()='Yes']")).click();
		
	}
	
	
	//Result
	
	public void Result() 
	{
	
	wait = new ExplicitwaitMethods(driver);
	
	wait.clickOnElement(Resultplusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	WebElement inter1 = driver.findElement(By.xpath("(//textarea)[1]"));
	inter1.sendKeys(Keys.CONTROL + "a");
	inter1.sendKeys(Keys.DELETE);
	inter1.sendKeys("ok with candidate");
	
	driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
	

	WebElement inter2 = driver.findElement(By.xpath("(//textarea)[3]"));
	inter2.sendKeys(Keys.CONTROL + "a");
	inter2.sendKeys(Keys.DELETE);
	inter2.sendKeys("ok ok with candidate");
	
	driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
	
	WebElement inter3 = driver.findElement(By.xpath("(//textarea)[5]"));
	inter3.sendKeys(Keys.CONTROL + "a");
	inter3.sendKeys(Keys.DELETE);
	inter3.sendKeys("ok ok ok with candidate");
	
	driver.findElement(By.xpath("(//button[text()='Submit'])[3]")).click();
	
	WebElement Hrcomment = driver.findElement(By.xpath("(//textarea)[7]"));
	Hrcomment.sendKeys(Keys.CONTROL + "a");	
	Hrcomment.sendKeys(Keys.DELETE);
	Hrcomment.sendKeys("Yes with candidate");
	
	driver.findElement(By.xpath("(//button[text()='Submit'])[4]")).click();
	
	
	
	
	
	//pdf file attach
//	driver.findElement(By.xpath("//input[@type=\"file\"]")).sendKeys("C:\\Users\\admin\\eclipse-workspace\\AcharyaUniversity_ERP\\TestData\\Testing blank document.pdf");
	
//	driver.findElement(By.xpath("//input[@name=\"marks\"]")).sendKeys("60");
//	driver.findElement(By.xpath("//h6")).click();
	
	driver.findElement(By.xpath("//button[text()='Selected']")).click();
	
	driver.findElement(By.xpath("//strong[text()='Yes']")).click();
	
	}
	
	public void salaryBreakUp() throws InterruptedException
	{
		 wait = new ExplicitwaitMethods (driver);
		wait.clickOnElement(salaryBreakUp_Plusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		driver.findElement(By.id("mui-component-select-employeeType")).click();
		
		Thread.sleep(3000);
		
		List<WebElement> emptype = driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li"));
		wait.selectdropdownwithnoselecttag(emptype, "Fixed Term Recruitment", ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
		
		WebElement school = driver.findElement(By.xpath("(//input[@role=\"combobox\"])[1]"));
		
		commonmethod(school, "ACHARYA INSTITUTE OF TECHNOLOGY");
		
		WebElement Department = driver.findElement(By.xpath("(//*[@autocapitalize=\"none\"])[2]"));
		
		commonmethod(Department, "ERP");
		
	    WebElement Designation = driver.findElement(By.xpath("(//input[@role=\"combobox\"])[3]"));
		
		commonmethod(Designation, "Professor");
		
        WebElement jobtype = driver.findElement(By.xpath("(//input[@role=\"combobox\"])[4]"));
		
		commonmethod(jobtype, "Teaching Admin");
		
		driver.findElement(By.xpath("//textarea[@name=\"remarks\"]")).sendKeys("testing from erp");
		
		
		
		driver.findElement(By.xpath("(//input[@aria-label=\"Choose date\"])[1]")).click();
		
		driver.findElement(By.xpath("//*[@data-testid=\"PenIcon\"]")).click();
		
		driver.findElement(By.xpath("//*[@type=\"tel\"]")).sendKeys("09/04/2024");
		
		driver.findElement(By.xpath("//*[text()='OK']")).click();
		
		
       driver.findElement(By.xpath("//input[@aria-label=\"Choose date\"]")).click();
		
		driver.findElement(By.xpath("//*[@data-testid=\"PenIcon\"]")).click();
		
		driver.findElement(By.xpath("//*[@type=\"tel\"]")).sendKeys("10/10/2024");
		
		driver.findElement(By.xpath("//*[text()='OK']")).click();
		
		WebElement salary_structure = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[5]"));
		
		commonmethod(salary_structure, "Special Salary Structure 4");
		
		
		driver.findElement(By.xpath("//*[@name=\"basic-lumpsum\"]")).sendKeys("3000");
		
		driver.findElement(By.xpath("//*[@name=\"spl_1-lumpsum\"]")).sendKeys("2000");
		
		driver.findElement(By.xpath("//*[@name='ta-lumpsum']")).sendKeys("1000");
		
	
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		driver.findElement(By.xpath("//*[text()='Generate CTC']")).click();
		
		driver.findElement(By.xpath("//button[text()='Salary Breakup']")).click();
		
		driver.findElement(By.xpath("//*[@name=\"remarks\"]")).sendKeys("test");
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		driver.findElement(By.xpath("//strong[text() = 'Yes']")).click();		
	
	}
	
	
	public void job_offer()
	{
		wait = new ExplicitwaitMethods (driver);
		
		Job_offer.click();
		
		WebElement reporting_to = driver.findElement(By.xpath("//*[@aria-autocomplete=\"list\"]"));	
		
		commonmethod(reporting_to, "kaushal12@acharya.ac.in");
		
		driver.findElement(By.xpath("//*[@aria-readonly=\"true\"]")).click();
		
		driver.findElement(By.xpath("//*[@data-testid=\"PenIcon\"]")).click();
		
		driver.findElement(By.xpath("//*[@type=\"tel\"]")).sendKeys("10/04/2024");
		
		driver.findElement(By.xpath("//*[text()='OK']")).click();
		
		WebElement comments = 	driver.findElement(By.xpath("//*[@name=\"comments\"]"));
		comments.sendKeys(Keys.CONTROL + "a");	
		comments.sendKeys(Keys.DELETE);
		comments.sendKeys("Yes with candidate");
		
		
		WebElement save = driver.findElement(By.xpath("//*[text()='Save']"));
		wait.clickOnElement(save, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
		
		//WebElement sendmail = driver.findElement(By.xpath("//*[text()=\"Send Mail\"]"));
		//wait.clickOnElement(sendmail, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
		
		//WebElement yes = driver.findElement(By.xpath("//strong[text()='Yes']"));
		//wait.clickOnElement(yes, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );
		
		WebElement accepted =	driver.findElement(By.xpath("(//*[@type=\"radio\"])[1]"));
		wait.clickOnElement(accepted, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME );	
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
	

	
	

