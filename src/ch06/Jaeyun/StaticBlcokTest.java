package ch06.Jaeyun;

public class StaticBlcokTest {
	
	static int[] arr = new int[10];
	
	static {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10) + 1; // 1 ~ 10 사이의 임의의 값을 배열 arr에 저장
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] : " + arr[i]);
		}

	}

}
