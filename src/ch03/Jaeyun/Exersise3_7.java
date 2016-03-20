package ch03.Jaeyun;

public class Exersise3_7 {

	public static void main(String[] args) {
		/*
		 * 문제 : 화씨를 섭씨로 변환하는 코드이다
		 * 변환 공식이 C = 5/9 x (F - 32)라고 할때
		 * celsius 변수를 알맞게 선언하시오
		 */
		int fahrenheigt = 100;
		float celsius = (((fahrenheigt - 32) * 5000/ 9 ) + 5) / 10 / 100f;
		
		System.out.println("faherenheigt : " + fahrenheigt);
		System.out.println("Celsius : " + celsius);

	}

}
