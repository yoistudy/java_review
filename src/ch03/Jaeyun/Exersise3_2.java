package ch03.Jaeyun;

public class Exersise3_2 {

	public static void main(String[] args) {
		/*
		 * 문제 : 사과를 담는데 필요한 바구니의 수를 구하는 코드
		 * 만일 사과의 수가 123개이고 
		 * 10개 사과를 담을 수 있는 바구니가 있다면
		 * 13개의 바구니를 구해야한다   
		 */
		int numOfApples = 131;
		int sizeOfBucket = 10;
		int numOfBucket = (numOfApples + 9) / sizeOfBucket;
		System.out.println("필요한 바구니의 수 : " + numOfBucket);

	}

}
