package ch12.Jaeyun;

/*
 * 쓰레드 상태
 * deprecated api로 실행 제어
 */
public class ThreadEx10 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyPrintThread("*\n", 1000), "t1");
		Thread t2 = new Thread(new MyPrintThread("**\n", 1000), "t2");
		Thread t3 = new Thread(new MyPrintThread("***\n", 100), "t3");
		
		t1.start();
		t2.start();
		t3.start();
		try {
			Thread.sleep(2000);
			t1.suspend(); // t1을 중단시킨다
			Thread.sleep(2000);
			t2.suspend();
			Thread.sleep(2000);
			t1.resume();
			t2.resume();
			Thread.sleep(2000);
			t1.stop();
			t2.stop();
			t3.stop();
			
		} catch (InterruptedException e) {}
	}

}