package ch06.Jaeyun;

public class PowerTest {

	public static void main(String[] args) {
		int x = 2;
		int n = 5;
		long total = 0;
		
		for (int i = 1; i <= n; i++) {
			long result = power(x, i);
			System.out.println("power(" + x + ", " + i + ") = " + result);
			total += result;
		}
		System.out.println(total);

	}

	 static long power(int x, int n) {
		if (n == 1) {
			return x;
		}
		return x * power(x, n - 1);
	}

}
