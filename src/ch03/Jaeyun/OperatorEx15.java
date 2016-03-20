package ch03.Jaeyun;

public class OperatorEx15 {

	public static void main(String[] args) {
		char c = 'a';
		
		for (int i = 0; i < 26; i++) {
			System.out.print(c++); // 'a'부터 26개의 문자를 출력
		}
		System.out.println();
		c = 'A';
		for (int i = 0; i < 26; i++) {
			System.out.print(c++); // 'A'부터 26개의 문자를 출력
		}
		System.out.println();
		c = '0';
		for (int i = 0; i < 10; i++) {
			System.out.print(c++); // '9'부터 10개의 문자를 출력
		}
		System.out.println(); 
	}

}
