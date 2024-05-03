package com.AcharyaUniversity_ERP.Utility;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.AcharyaUniversity_ERP.Testcase.BaseClass_University;

public class ReuseMethods extends BaseClass_University {
	
	WebDriver driver;
	
	public ReuseMethods(WebDriver driver) {
		
		this.driver = driver;
			
		}
	
	public static String getthefreshdatewithHrs() throws ParseException
	 
	  {
	       // Create a SimpleDateFormat object for the input date format
	       SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");

	       // Parse the input date string into a Date object
	       Date inputDate = inputFormat.parse(ReuseMethods.convertdatetostring());

	       // Create a SimpleDateFormat object for the output date format
	       SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
	      // SimpleDateFormat outputFormat = new SimpleDateFormat("DD/MM/YYYY hh:mm:ss a");
	   

	       // Format the Date object into the output date string
	       String outputDateString = outputFormat.format(inputDate);

	       // Print the output date string
	       System.out.println(outputDateString);
		return outputDateString +" AM";

	  }
	
	public static String getthefreshdate() throws ParseException
	 
	  {
	       // Create a SimpleDateFormat object for the input date format
	       SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");

	       // Parse the input date string into a Date object
	       Date inputDate = inputFormat.parse(ReuseMethods.convertdatetostring());

	       // Create a SimpleDateFormat object for the output date format
	       SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

	       // Format the Date object into the output date string
	       String outputDateString = outputFormat.format(inputDate);

	       // Print the output date string
	       System.out.println(outputDateString);
		return outputDateString;

	  }
	
	
	public static String gettheafter184daysfreshdate() throws ParseException
	 
	  {
	       // Create a SimpleDateFormat object for the input date format
	       SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");

	       // Parse the input date string into a Date object
	       Date inputDate = inputFormat.parse(ReuseMethods.convertnext184datetostring());

	       // Create a SimpleDateFormat object for the output date format
	       SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

	       // Format the Date object into the output date string
	       String outputDateString = outputFormat.format(inputDate);

	       // Print the output date string
	       System.out.println(outputDateString);
		return outputDateString;

	  }
	
	
	
	
	 public static LocalDate getNext184days(LocalDate date)
	  {
	        LocalDate nextDate = date.plusDays(184);
	        while (nextDate.getDayOfWeek() == DayOfWeek.SATURDAY || nextDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
	            nextDate = nextDate.plusDays(1);
	        }
	        return nextDate;
	  }
	
	 public static String convertnext184datetostring()
	 {
	 
	        LocalDate currentDate = LocalDate.now();   //gets current date
	                                           
	        LocalDate nextWeekday = getNext184days(currentDate);    //getting next week day
	     
	               
	       String dateto_string = nextWeekday.toString();            //converting date to string
	       return dateto_string;
	 
	    }
	

	  public static LocalDate getNextWeekday(LocalDate date)
	  {
	        LocalDate nextDate = date.plusDays(1);
	        while (nextDate.getDayOfWeek() == DayOfWeek.SATURDAY || nextDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
	            nextDate = nextDate.plusDays(1);
	        }
	        return nextDate;
	  }
	   
	 public static String convertdatetostring()
	 {
	 
	        LocalDate currentDate = LocalDate.now();   //gets current date
	                                           
	        LocalDate nextWeekday = getNextWeekday(currentDate);    //getting next week day
	     
	               
	       String dateto_string = nextWeekday.toString();            //converting date to string
	       return dateto_string;
	 
	    }
	 
	 public static String convetinginttostring(int value)
	 {
		String str =  Integer.toString(value);
		return str;
	
		 
	 }

	 public static String convetingdoubletostring(double esiemployeeno)
	 {
			double a = esiemployeeno;
			double roundOff = Math.round(a*100)/100;
			
		String doubletostring = Double.toString(roundOff);
		String value = doubletostring.substring(0, 3);
			
		System.out.println(value);
		return value;
	
		 
	 }
	
	 
	}
	 


