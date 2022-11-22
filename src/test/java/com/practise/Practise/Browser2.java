package com.practise.Practise;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Test;

import com.baseclass.BaseClass;

public class Browser2{
	public static void main(String[] args) {
		 String pathvalue = null;
	       try {
	          Calendar now = Calendar.getInstance();
	         SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	         String dateNow = formatter.format(now.getTime());
	         System.out.println("date Now:"+dateNow);
	          String fetch_date = dateNow.replaceAll("/", "_");
	             formatter = new SimpleDateFormat("MMMM");
	             String month = formatter.format(now.getTime());
	           formatter = new SimpleDateFormat("yyyy");
	            String year1 = formatter.format(now.getTime());
	             formatter = new SimpleDateFormat("yy");
	             String year2 = formatter.format(now.getTime());
	          
//	            Utilities.getProperty(Utilities.Properitiesfile, "date");
	        
	             // path = C:\\PK\\Workspace\\TestNG\\;
	            File files = new File("C:\\PK\\Workspace\\TestNG\\" + File.separator + fetch_date+ File.separator+"Image");
	             System.out.println(files.getPath());
	            pathvalue = files.getPath();
	             if (!files.exists() &&
	           files.mkdirs()) {
	                // return pathvalue;
	                 System.out.println("Directories of [" + month + year2 + "] are created for the process run date : [" + dateNow + "]");
	             } else {
	                // return pathvalue;
	            }
	            }
	       catch (Exception e) {
	           
	            // log.error("Got Exception in dateCreation() method ");
	        } finally {
//	            return pathvalue;
	        }
	      

}
	}

