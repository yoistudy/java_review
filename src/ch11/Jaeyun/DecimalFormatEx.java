package ch11.Jaeyun;

import java.text.DecimalFormat;
import java.text.ParseException;

public class DecimalFormatEx {

	public static void main(String[] args) {
		double number = 1234567.89;
		String[] pattern = {
				"0",
				"#",
				"0.0",
				" #.#",
				"0000000000.0000" ,
				"#########.####",
				" #.#- ",
				" -#. #",
				"#,###.##",
				"#,####.##",
				"#E0",
				"0E0",
				"##E0",
				"00E0" ,
				"####E0",
				"0000E0",
				"#.#E0",
				"0.0E0",
				"0.000000000E0",
				"00.00000000E0",
				"000.0000000E0",
				"#.#########E0",
				"##.########E0",
				"###.#######E0",
				"#,###.##+;#,###.##-",
				"#.#%",
				"#.#\u2030",
				"\u00A4 #,###",
				"`#`#,###",
				"``#,###"
		};
		try {
			for (int i = 0; i < pattern.length; i++) {
				DecimalFormat df = new DecimalFormat(pattern[i]);
				String formattedString = df.format(number);
					System.out.printf("%s : \n\t포맷된 문자열 %s,\n"
							+ "\t포맷된 문자열로 부터 추출한 값 %s\n", 
							pattern[i], 
							formattedString, 
							df.parse(formattedString).doubleValue());
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
