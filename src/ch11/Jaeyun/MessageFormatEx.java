package ch11.Jaeyun;

import java.text.MessageFormat;
import java.text.ParseException;

public class MessageFormatEx {

	public static void main(String[] args) {
		String pattern = " 이름 : {0}\n 전화번호 : {1}\n 나이  : {2}\n 등록일 : {3}";
		Object[] arguments = {
				"yoiyoy",
				"010-1234-5678",
				"29",
				"2016-06-19"
		};
		MessageFormat mf = new MessageFormat(pattern);
		// MessageFormat 클래스의 스태틱 메서드 format을 사용한다
		// 첫번째 인자는 String 타입으로 패턴으로 {0으로 시작하는 숫자}가 포함되어야 한다
		// 두번째 인자는 Object 타입 배열로 인덱스는 패턴의 숫자에 대응하며 포매팅 될 값이 지정되어야 한다
		String formattedString = MessageFormat.format(pattern, arguments);
		
		try {
			System.out.println(formattedString);
			Object[] valus = mf.parse(formattedString);
			System.out.println("포맷된 문자열로 부터 추출한 값 : ");
			for (Object value : valus) {
				System.out.printf("%s\n", value);
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
