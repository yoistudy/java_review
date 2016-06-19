package ch11.Jaeyun;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFormatEx {

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		// 오늘 날짜를 yyy-MM-dd형 태로 변환하여 반환한다.
		// format 매서드는 Date 인스턴스를 인자로 받는다
		String formattedString = sdf.format(new Date(today.getTimeInMillis()));
		try {
			System.out.printf("포맷패턴 : %s\n", pattern);
			System.out.printf("포맷된 문자열 : %s\n", formattedString);
			System.out.printf("포맷된 문자열로 부터 추출한 값 : : %s\n", sdf.parse(formattedString));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
