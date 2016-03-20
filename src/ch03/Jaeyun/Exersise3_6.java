package ch03.Jaeyun;

public class Exersise3_6 {

	public static void main(String[] args) {
		/*
		 * 문제 : num의 값보다 크면서 가장 가까운 10의 배수에서
		 * num의 값을 뺀 나머지를 구하는 코드
		 * num이 64라면 70 - 64 = 6이 출력
		 */
		int num = 24;
		System.out.println(10 - (num % 10));

	}

}
