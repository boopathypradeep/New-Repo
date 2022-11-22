package com.practise.Practise;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Browser1{
public static void main(String[] args) {
	  Calendar now = Calendar.getInstance();
      SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
      String dateNow = formatter.format(now.getTime());
      System.out.println("date Now:"+dateNow);
       String fetch_date = dateNow.replaceAll("/", "_");
       Calendar now = Calendar.getInstance();
       SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
       String dateNow = formatter.format(now.getTime());
       System.out.println("date Now:"+dateNow);
        String fetch_date = dateNow.replaceAll("/", "_");
        Calendar now = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String dateNow = formatter.format(now.getTime());
        System.out.println("date Now:"+dateNow);
         String fetch_date = dateNow.replaceAll("/", "_");
         Calendar now = Calendar.getInstance();
         SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
         String dateNow = formatter.format(now.getTime());
         System.out.println("date Now:"+dateNow);
          String fetch_date = dateNow.replaceAll("/", "_");
             	
}
	

}
