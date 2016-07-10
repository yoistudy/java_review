package ch12.Jaeyun;

/*
 * 멀티 쓰레드
 * 두개의 작업을 멀티 쓰레드로 실행
 */
public class ThreadEx2 {

	public static void main(String[] args) {
		Thread t = new Thread(new MyPrintThread());
		t.start();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 300; i++) {
			System.out.print("-");
		}
		System.out.println("작업2 " + Thread.currentThread().getName() 
				+ "쓰레드 소요시간 " + (System.currentTimeMillis() - startTime));

	}

}

class MyPrintThread implements Runnable {
	
	private String printingString;
	
	private long intervalMillis;
	
	private boolean limitless = false;
	
	MyPrintThread() {
		this("|", 100);
	}
	
	MyPrintThread(String printingString) {
		this.printingString = printingString;
	}
	
	MyPrintThread(String printingString, long intervalMillis) {
		this.printingString = printingString;
		this.intervalMillis = intervalMillis;
		this.limitless = true;
	}
	
	public void run() {
		if (limitless) {
			while(true) {
				System.out.print(this.printingString);
				try {
					Thread.sleep(intervalMillis);
				} catch (InterruptedException e) {}
			}
		} else {
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < 100; i++) {
				System.out.print(this.printingString);
			}
			System.out.println("작업1 " + Thread.currentThread().getName() 
					+ "쓰레드 소요시간 " + (System.currentTimeMillis() - startTime));
		}
	}
}
