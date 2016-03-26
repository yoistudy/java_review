package ch05.Jaeyun;

public class ArrayEx01 {

	public static void main(String[] args) {
		int sum = 0;
		float average = 0f;
		
		int[] score = {100, 88, 100, 100, 90};
		
		for (int i = 0; i < score.length; i++) {
			sum += score[i];
		}
		average = (float)sum / score.length; // 계산 결과를 float으로 얻기 위해 형변환
		
		System.out.println("총점 : " + sum);
		System.out.println("총점 : " + average);
	}

}
