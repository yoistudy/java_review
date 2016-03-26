package ch05.Jaeyun;

public class MorseConverter {

	public static void main(String[] args) {
		String source = "";
		String[] morse = {
				".-", "-...", "-.-.", "-..", ".",
				"..-.", "--.", "....", "..", ".---",
				"-.-", ".-..", "--", "-.", "---",
				".--.", "--.-", ".-.", "...", "-",
				"..-", "...-", ".--", "-..-", "-.--",
				"--.."
		};
		String result = "";
		
		if (args.length != 1) {
			System.out.println("사용법 ---");
			System.out.println("하나의 영문 문자열을 입력해주세요");
			System.out.println("하나의 영문 문자열을 모스부호들로 변환합니다.");
			System.out.println("영문 문자가 아닌 입력은 생략됩니다");
			System.exit(0);
		}
		System.out.println("source : " +args[0]);
		source = args[0].toUpperCase();
		for (int i = 0; i < source.length(); i++) {
			int pos = source.charAt(i) - 'A';
			
			if(pos > 0 && pos < morse.length){
				result += morse[pos] + " ";
			}
		}
		System.out.println("morse : " + result);

	}

}
