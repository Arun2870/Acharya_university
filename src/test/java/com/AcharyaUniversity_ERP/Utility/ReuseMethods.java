package com.AcharyaUniversity_ERP.Utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

import org.openqa.selenium.WebDriver;

public class ReuseMethods {
	
	WebDriver driver;
	
	public ReuseMethods(WebDriver driver) {
		
		this.driver = driver;
			
		}
	
	public static String getthefreshdate() throws ParseException
	 
	  {
	       // Create a SimpleDateFormat object for the input date format
	       SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");

	       // Parse the input date string into a Date object
	       Date inputDate = inputFormat.parse(ReuseMethods.convertdatetostring());

	       // Create a SimpleDateFormat object for the output date format
	       SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");

	       // Format the Date object into the output date string
	       String outputDateString = outputFormat.format(inputDate);

	       // Print the output date string
	       System.out.println(outputDateString);
		return outputDateString;

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
	 
	}
	 


