package ch12.Jaeyun;

/*
 * 쓰레드 상태
 * sleep, suspend, resume 메서드를 내부 구현한 쓰레드 작성
 */
public class ThreadEx11 {

	public static void main(String[] args) {
		MyNewPrintThread t1 = new MyNewPrintThread("*");
		MyNewPrintThread t2 = new MyNewPrintThread("**");
		MyNewPrintThread t3 = new MyNewPrintThread("***");
		
		t1.start();
		t2.start();
		t3.start();
		try {
			Thread.sleep(2000);
			t1.suspend(); // t1을 중단시킨다
			Thread.sleep(2000);
			t2.suspend();
			Thread.sleep(3000);
			t1.resume();
			Thread.sleep(3000);
			t1.stop();
			t2.stop();
			Thread.sleep(2000);
			t3.stop();
			
		} catch (InterruptedException e) {}
	}

}


class MyNewPrintThread implements Runnable {
	
	private String printingString;
	
	private long intervalMillis;
		
	// 쓰레드 상태
	private boolean suspended = false;
	
	private boolean stopped = false;
	
	private Thread th;
	
	MyNewPrintThread() {
		this("|");
	}
	
	MyNewPrintThread(String printingString) {
		this(printingString, 1000);
	}
	
	MyNewPrintThread(String printingString, long intervalMillis) {
		this.printingString = printingString;
		this.intervalMillis = intervalMillis;
		this.th = new Thread(this);
	}
	
	public void run() {
		while (!stopped) {
			if (!suspended) {
				System.out.println(this.printingString);
				try {
					Thread.sleep(intervalMillis);
				} catch (InterruptedException e) {
					System.out.println("printing \"" + this.printingString + "\" interrupped");
				}
			} else {
				Thread.yield(); // 실행시간을 가지지않고 다른 쓰레드에게 양보
			}
		}
		System.out.println("printing \"" + this.printingString + "\" stopped");
	}
	
	public void suspend() {
		this.suspended = true;
		this.th.interrupt();
		System.out.println("printing \"" + this.printingString + "\" interrupted in suspend()");
	}
	
	public void resume() {
		this.suspended = false;
	}
	
	public void stop() {
		this.stopped = true;
		this.th.interrupt();
		System.out.println("printing \"" + this.printingString + "\" interrupted in stop()");
	}
	
	public void start() {
		this.th.start();
	}
}
