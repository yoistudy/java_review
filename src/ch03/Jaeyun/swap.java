package ch03.Jaeyun;

public class swap {

	public static void main(String[] args) {
		/*
		 * 번외 문제 : 선언된 두 변수로외 temp성 변수를 쓰지말고 두 변수의 값을 교환하기
		 */
		int a = 8;  // 100 (비트의 뒤의 3자리만 본다면)
		int b = 10; // 110
		
		System.out.println("a : " + a + ", b : " + b);
		a ^= b;     // 010
		b ^= a;     // 110
		a ^= b;     // 100
		System.out.println("a : " + a + ", b : " + b);
		
	}
}
