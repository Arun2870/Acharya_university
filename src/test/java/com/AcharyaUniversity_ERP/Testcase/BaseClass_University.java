package com.AcharyaUniversity_ERP.Testcase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Appender;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.AcharyaUniversity_ERP.Utility.Readconfig;

public class BaseClass_University {
	
	Readconfig read = new Readconfig();

	public static Logger log;
	public static WebDriver driver;
	ChromeOptions ops; 
	
	
@Parameters("browser")
@BeforeMethod
public void setup(String br) throws IOException
{
	if(br.equals("chrome"))
	{
	//System.setProperty("webdriver.chrome.driver", read.getchromepath());
	
	 ops = new ChromeOptions();  
	ops.addArguments("--remote-allow-origins=*");
	ops.addArguments("--disable-notifications");
	
	
      driver = new ChromeDriver(ops);
      
	}
	
	else if(br.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", read.getfirefoxpath());
		 driver = new FirefoxDriver();
	}
			 
	 driver.manage().window().maximize();
	
	 
	  log = Logger.getLogger(BaseClass_University.class);
	 PropertyConfigurator.configure("Log4j.properties");
	 
	 Layout layout = new PatternLayout("%d  %c %m  %n");
	Appender appender = new FileAppender(layout, ".//log//Logging.log");
	BasicConfigurator.configure(appender);
	
	driver.get(read.geturl());
	log.info("url is opened");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 ;		
}

public  String randomString() {
	String generateString1 = RandomStringUtils.randomAlphabetic(5);
	return (generateString1);

}
	
@AfterMethod
public void teardown() 
{
	//driver.quit();
}


public  static String takeScreenshot(String testName, WebDriver driver) 
{
TakesScreenshot ts = (TakesScreenshot) driver;                                                     
File source = ts.getScreenshotAs(OutputType.FILE);
File target = new File(System.getProperty("user.dir")+"\\Screenshots\\"+testName+Timestamp()+".png"); 
try {
	FileUtils.copyFile(source, target);
} catch (IOException e) {
	e.printStackTrace();
}
return target.getAbsolutePath();
}

public static String Timestamp()
{
Date date = new Date();
return date.toString().replace(" ","_" ).replace(":", "_");

}



public void downloadtospecificpath()
{
 
String location = "C:\\Users\\admin\\git\\Acharya_Uniersity_application\\Document";
	
	 Map<String, Object> prefs = new HashMap<>();
	 prefs.put("download.default_directory", location);
	 
	 ops = new ChromeOptions(); 
	 ops.setExperimentalOption(location, prefs);

	 WebElement downloadbutton =  driver.findElement(By.id("download"));
	 
	 Actions act = new Actions(driver);
	 act.moveToElement(downloadbutton).click().perform();
	
}

}




