package coreJavaExample.dateandCalender;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAndCalender {

	public static void main(String[] args) {
//		//Calendar
//		Calendar calendar = Calendar.getInstance();
//        System.out.println("The Current Date is: " + calendar.getTime());
//     // Demonstrate Calendar's get()method
//        System.out.println("Current Calendar's Year: " + calendar.get(Calendar.YEAR));
//        System.out.println("Current Calendar's Day: " + calendar.get(Calendar.DATE));
//        System.out.println("Current MINUTE: " + calendar.get(Calendar.MINUTE));
//        System.out.println("Current SECOND: " + calendar.get(Calendar.SECOND));
//        
//        
//        int max = calendar.getMaximum(Calendar.DAY_OF_WEEK);
//        System.out.println("Maximum number of days in a week: " + max);
//          
//        max = calendar.getMaximum(Calendar.WEEK_OF_YEAR);
//        System.out.println("Maximum number of weeks in a year: " + max);
//
//        calendar.add(Calendar.DATE, -15);
//        System.out.println("15 days ago: " + calendar.getTime());
//        calendar.add(Calendar.MONTH, 4);
//        System.out.println("4 months later: " + calendar.getTime());
//        calendar.add(Calendar.YEAR, 2);
//        System.out.println("2 years later: " + calendar.getTime());
		 // Instantiate a Date object
	      Date date = new Date();  
	      System.out.println(date.toString());
	 
	      SimpleDateFormat ft = 
	      new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

	      System.out.println("Current Date: " + ft.format(date));
        
	}

}
