package ch11.Jaeyun;

import java.text.ChoiceFormat;

public class ChoiceFormatEx {

	public static void main(String[] args) {
		double[] limits = {60, 70, 80, 90};
		String[] formats = {"D", "C", "B", "A"};
		int[] scores = {100, 95, 88, 30, 20, 50, 70, 64};
		// ChoiceFormat 생성자 
		// 첫번째 인자는 double 타입의 배열로 범위를 표현하기 때문에 오름차순이어야 함
		// 두번째 인자는 String 타입의 배열로 첫번째 인자의 범위에 해당하는 포맷
		// 첫번째 인자와 두번째 인자의 배열길이는 서로 같아야 한다
		ChoiceFormat cf = new ChoiceFormat(limits, formats);
		
		for (int i = 0; i < scores.length; i++) {
			String formattedString = cf.format(scores[i]);
			System.out.printf("%d : %s\n", scores[i], formattedString);
		}
	}

}
