package ch12.Jaeyun;

/*
 * 싱글 쓰레드
 * 두개의 작업을 싱글 쓰레드로 실행
 */
public class ThreadEx3 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 300; i++) {
			System.out.print("|");
		}
		System.out.println("작업1 " + Thread.currentThread().getName() 
				+ "쓰레드 소요시간 " + (System.currentTimeMillis() - startTime));
		for (int i = 0; i < 300; i++) {
			System.out.print("-");
		}
		System.out.println("작업2 " + Thread.currentThread().getName() 
				+ "쓰레드 소요시간 " + (System.currentTimeMillis() - startTime));

	}

}