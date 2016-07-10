package ch12.Jaeyun;

/*
 * 쓰레드 상태
 * 두 쓰레드를 순차적으로 실행
 */
public class ThreadEx9 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyPrintThread("-"), "t1");
		Thread t2 = new Thread(new MyPrintThread("|"), "t2");
		
		t1.start();
		try {
			t1.join(); // t1 쓰레드를 실행한다. t1의 작업이 끝나야 다른쓰레드가 실행될 수  있다
		} catch (InterruptedException e) {}
		t2.start();
	}

}