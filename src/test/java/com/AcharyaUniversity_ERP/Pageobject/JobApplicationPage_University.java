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
	
	
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[20]/div[6]/button")
	public WebElement HRSgreentick;
	
	@FindBy(id = "mui-component-select-hrStatus")
	public WebElement status;
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[20]/div[8]/button")
	public WebElement Interviewplusicon;
	
	@FindBy(xpath = "(//input[@autocapitalize=\"none\"])[1]")
	public WebElement interviewer;
	
	@FindBy(xpath = "(//input[@autocapitalize=\"none\"])[2]")
	public WebElement position;
	
	@FindBy(xpath = "//input[@aria-label=\"Choose date\"]")
	public WebElement interview_date;
	
	@FindBy(id = ":r34:")
	public WebElement comments;
	
	@FindBy(xpath = "//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div[1]/div[9]/button")
	public WebElement Resultplusicon;
	
	
	
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
		
		HRSgreentick.click();
		
		status.click();
		
		List<WebElement> stadropdowns = driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li"));
		
	wait.selectdropdownwithnoselecttag(stadropdowns, "Shortlisted" , 3000);
		
		
	WebElement ele1 = driver.findElement(By.xpath("//textarea[@name='description']"));
	ele1.click();
	
	ele1.sendKeys(Keys.CONTROL + "a");
	ele1.sendKeys(Keys.DELETE);
	//ele1.clear();
	ele1.sendKeys("candidate shortlisted");
 
	driver.findElement(By.xpath("//button[text()='Update']")).click();  // update button
	 
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
		
		//driver.findElement(By.xpath("//*[@id=\":r2r:\"]")).click();
		
	//driver.findElement(By.xpath("(//*[@role=\"dialog\"]//button)[5]")).click(); //inter date
	
 driver.findElement(By.xpath("//*[@data-testid=\"PenIcon\"]")).click();// pencil icon
	
/*Date date = new Date();
	SimpleDateFormat sip = new SimpleDateFormat("dd/MM/Y hh:m a");
	System.out.println(sip);
   String st =  sip.format(date);
    
  int dat =  Integer.parseInt(st.substring(0, 2));
  int mon = Integer.parseInt(st.substring(3, 5));
  int year = Integer.parseInt(st.substring(6, 10));


  String emtered_date = "05/04/2024 02:00 AM";
  
  int edat =  Integer.parseInt(st.substring(0, 2));
  int emon = Integer.parseInt(st.substring(3, 5));
  int eyear = Integer.parseInt(st.substring(6, 10));
    
  if(eyear>year)
  {
	  emtered_date.substring(6, 10).replace(2025, 0);
  }*/
   
   
    
  
	
/*	WebElement dateele = driver.findElement(By.xpath("//*[@id=\":r2v:\"]"));// pencil icon
	
	Date date = new Date();
	SimpleDateFormat sip = new SimpleDateFormat("dd/MM/Y hh:m a");
   
	String st =  sip.format(date);
   String db =  "05/04/2024 02:00 AM";
   
   System.out.println(st);
   System.out.println(db);
   
  Date a =  sip.parse(st);
  Date b =  sip.parse(db);
  
  boolean c = b.after(a);
  
  System.out.println(a);
  System.out.println(b);
  
   if (a.equals(b))
   {
	   dateele.sendKeys(b.)
   }

else if (a.after(b))
  System.out.println("Date a comes after Date b");
// Checking for before case
else if (a.before(b))
  System.out.println("Date a comes before Date b");*/
	
	
	 driver.findElement(By.xpath("//*[@placeholder=\"dd/mm/yyyy hh:mm (a|p)m\"]")).sendKeys("08/04/2024 02:00 AM"); //enter date
	driver.findElement(By.xpath("//button[text()='OK']")).click();
	
	driver.findElement(By.name("comments")).sendKeys("testing for automation");
	
	driver.findElement(By.xpath("//button[text()='Save']")).click();
	
	driver.findElement(By.xpath("//button[text()=\"Send mail to Interviewer\"]")).click();
	
	driver.findElement(By.xpath("//strong[text() = 'Yes']")).click();
	
	WebElement candidatemail = driver.findElement(By.xpath("//button[text() = 'Send mail to Candidate']"));
	
wait.clickOnElement(candidatemail, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	driver.findElement(By.xpath("//strong[text()='Yes']")).click();
		
	//Result
	
	wait.clickOnElement(Resultplusicon, ExplicitwaitMethods.EXPLICIT_WAIT_BASIC_TIME);
	
	driver.findElement(By.id(":r5l:")).sendKeys("ok with candidate ");
	
	driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();

	driver.findElement(By.id(":r5m:")).sendKeys("ok ok with candidate ");
	
	driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
	
	driver.findElement(By.id(":r5n:")).sendKeys("ok ok ok with candidate ");
	
	driver.findElement(By.xpath("(//button[text()='Submit'])[3]")).click();
	
	

	
	


	

	}
	
	
		//int rowscount = sheetrows.size();
        //System.out.println(rowscount);
	
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
	

	
	

