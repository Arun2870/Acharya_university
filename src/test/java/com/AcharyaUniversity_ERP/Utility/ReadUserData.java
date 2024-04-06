package com.AcharyaUniversity_ERP.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadUserData {
	
	Properties pro;
	
	public ReadUserData() throws IOException
	{
		File file = new File(".//com.AcharyaERP.Utility//ReadUserData");
		
		try {
			FileInputStream fil = new FileInputStream(file);
			pro = new Properties();
			pro.load(fil);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
						
	} 

	public String geturl()
	{
		String url = pro.getProperty("URL");
		return url;
	}
	
	public String getChromedriverpath()
	{
		String url = pro.getProperty("Chromedriverpath");
		return url;
	}
	
	public String getUsername()
	{
		String url = pro.getProperty("Username");
		return url;
	}
	
	public String getpassword()
	{
		String url = pro.getProperty("password");
		return url;
	}
	
}
