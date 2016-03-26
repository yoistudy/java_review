package ch05.Jaeyun;

public class ArrayEx03 {

	public static void main(String[] args) {
		int[] number = new int[10];
		
		for (int i = 0; i < number.length; i++) {
			number[i] = i;
			System.out.print(number[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < 100; i++) {
			int n = (int) (Math.random() * 10); // 0~9 사이의 임의의 한 값을 얻음 
			int temp = number[0];
			
			number[0] = number[n]; // 임의의 요소의 값을 첫 번째 요소에 할당 
			number[n] = temp; // 첫 번째 요소의 값이 할당된 temp로 임의의 요소에 값을 할당
		}
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + " ");
		}

	}

}
