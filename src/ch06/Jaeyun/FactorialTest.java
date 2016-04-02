package ch06.Jaeyun;

public class FactorialTest {

	public static void main(String[] args) {
		System.out.println(factorial2(4));
	}

	static long factorial(int n) {
		long result = 0;
		
		if (n == 1) {
			result = 1;
		} else {
			result = n * factorial(n - 1);
		}
		
		return result;
	}
	
	static long factorial2(int n) {
		return (n == 1) ? 1 : n * factorial2(n - 1); // 삼항 연산자를 이용
	}

}
