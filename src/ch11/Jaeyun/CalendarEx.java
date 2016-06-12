package ch11.Jaeyun;

import java.util.Calendar;

public class CalendarEx {

	public static void main(String[] args) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal1.set(Calendar.YEAR, 2016);
		cal1.set(Calendar.MONTH, 5);
		cal1.set(Calendar.DATE, 19);
		cal1.set(Calendar.HOUR_OF_DAY, 14);
		cal1.set (Calendar.MINUTE , 10 );
		cal1.set (Calendar.SECOND, 30 );
		cal2.set(2016 , 5, 19 , 14, 10, 30);
		
		cal1.add(Calendar.DATE, 14);
		cal2.roll(Calendar.DATE, 14);
		System.out.println("cal1이 cal2보다 " + (cal1.after(cal2) ? "이 후" : "이 전") + " 날짜" );
	}

}
