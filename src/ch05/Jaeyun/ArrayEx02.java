package ch05.Jaeyun;

public class ArrayEx02 {

	public static void main(String[] args) {
		int[] score = {79, 88, 91, 33, 100, 55, 95};
		int max = score[0]; // 배열의 첫 째 값으로 초기화
		int min = score[0]; // 배열의 첫 째 값으로 초기화
		
		// 첫 째 값으로 이미 초기화 되어있다. 
		// 둘 째 값부터 비교하기 위해 인덱스 변수 i를 1로 초기화
		for (int i = 1; i < score.length; i++) { 
			if (score[i] > max) {
				max = score[i];
			}
			if (score[i] < min) {
				min = score[i];
			}
		}
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);

	}

}
