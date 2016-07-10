package ch12.Jaeyun;

/*
 * 쓰레드 동기화
 * wait(), notify
 */
public class ThreadEx14 {

	public static void main(String[] args) {
		MySyncThread t1 = new MySyncThread("*");
		MySyncThread t2 = new MySyncThread("**");
		MySyncThread t3 = new MySyncThread("***");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			
			Thread.sleep(2000);
			t1.suspend();
			Thread.sleep(2000);
			t2.suspend();
			Thread.sleep(3000);
			t1.resume();
			Thread.sleep(3000);
			t1.stop();
			t2.resume();
			t2.stop();
			Thread.sleep(2000);
			t3.stop();
		} catch (InterruptedException e) {}
		
	}

}

class MySyncThread implements Runnable {
	// 상태 코드
	static final int RUNNING = 0;
	static final int SUSPENDED = 1;
	static final int STOPPED = 2;
	
	private int state = RUNNING;
	Thread th;
	
	MySyncThread(String name) {
		th = new Thread(this, name);
	}

	// 상태를 설정한다
	public synchronized void setState(int state) {
		this.state = state;
		
		// state가 SUSPENDED였다가 RUNNING으로 변경되면 notify 호출
		if (state == RUNNING) {
			notify();
		} else {
			this.th.interrupt();
		}
	}
	
	public synchronized boolean checkState() {
		// state가 SUSPENDED면 wait 메서드를 호출해서 쓰레드 대기상태로 만들고
		while (state == SUSPENDED) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		// state가 STOPPED이면 true, 그 외에는 false를 리턴
		return state == STOPPED;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		
		while (true) {
			System.out.println(name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			
			// state가 STOPPED이면 checkState()가 true를 반환
			if (checkState()) {
				break;
			}
		}
		System.out.println(name + " - 종료");
		
	}
	
	public void suspend() {
		setState(SUSPENDED);
	}
	
	public void resume() {
		setState(RUNNING);
	}
	
	public void stop() {
		setState(STOPPED);
	}
	
	public void start() {
		this.th.start();
	}
	
	
	
}
