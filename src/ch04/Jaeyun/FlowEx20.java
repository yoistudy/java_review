package ch04.Jaeyun;

public class FlowEx20 {

	public static void main(String[] args) {
		System.out.println("카운트 다운 시작");
		for (int i = 10; i >= 0; i--) {
			for (int j = 0; j < 1000000000; j++) {
				;
			}
			System.out.println(i);
		}
		System.out.println("Game Over");

	}

}
