package ch06.Jaeyun;

public class ParameterTest3 {

	public static void main(String[] args) {
		int[] x = {10};
		System.out.println("main() : x = " + x[0]);
		
		change(x);
		System.out.println("Ater change(x)");
		System.out.println("main() : x = " + x[0]);

	}

	static void change(int[] x) { // 참조형 매개변수
		x[0] = 1000;
		System.out.println("change() : x = " + x[0]);
		
	}

}
