package ch04.Jaeyun;

public class FlowEx23 {

	public static void main(String[] args) {
		int sum = 0;
		int i = 0;
		while (sum + 1 < 100) {
			sum += ++i; // sum = sum + ++i;
			System.out.println(i + " - " + sum);
			
		}

	}

}
