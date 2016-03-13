package ch02.Jaeyun;

public class PrecisionTest {

	public static void main(String[] args) {
		float f = 1.2345678901234567890f;
		double d = 1.2345678901234567890;
		float f2 = 0.100000001f; // 0.1
		double d2 = 0.100000001;
		double d3 = 0.1000000000000001;
		
		System.out.println(f);
		System.out.println(d);
		System.out.println(f2);
		System.out.println(d2);
		System.out.println(d3);
	}

}
