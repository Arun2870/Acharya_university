package com.AcharyaUniversity_ERP.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
	 Properties pro ;
	
	 public Readconfig() 
	{
		File fil =new File(".//configuration//config.properties");
		
		try 
		{
			FileInputStream file = new FileInputStream(fil);
			 pro =new Properties();
			 pro.load(file);
		
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
}


public String geturl()
{
	String urll = pro.getProperty("url");
	return urll;
}

public String getchromepath()
{
	String path = pro.getProperty("chromedriverpath");
	return path;
}

public String getfirefoxpath()
{
	String fpath = pro.getProperty("firefoxpath");
	return fpath;
}

public String getusername()
{
	String Uname = pro.getProperty("Username");
	return Uname;
}

public String getpassword()
{
	String pass = pro.getProperty("password");
	return pass;
}

public String applicant_search_field()
{
	String appsearchfield = pro.getProperty("Applicantsearch");
	return appsearchfield;
}

}






