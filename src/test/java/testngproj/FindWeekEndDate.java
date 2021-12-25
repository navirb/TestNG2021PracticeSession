package testngproj;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FindWeekEndDate {
	
	public static void main(String[] args) {
		System.out.println(getNearestWeekend());
		//System.out.println("Is Weekend :" + isWeekend(today));
	}
	private static Date getNearestWeekend()
	{
	    try {
	        Calendar c = Calendar.getInstance();
	        Date myDate = new Date();
	        c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        
	        String weekendDate = sdf.format(myDate);
	        Date dt = sdf.parse(weekendDate);
	        return dt;
	    } catch (ParseException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}
