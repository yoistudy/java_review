package ch03.Jaeyun;

public class OperatorEx12 {

	public static void main(String[] args) {
		int a = 1000000 * 1000000 / 1000000; // 연산방향에 따라 연산 중 오버플로가 발생된다
		int b = 1000000 / 1000000 * 1000000; 
		
		System.out.println(a);
		System.out.println(b);

	}

}
