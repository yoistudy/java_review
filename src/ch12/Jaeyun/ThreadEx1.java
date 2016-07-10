package ch12.Jaeyun;

/*
 * 쓰레드 작성과 생성
 * Thread를 확장한 MyThread1과 Runnable을 구현한 MyThread2의 사용
 */
public class ThreadEx1 {

	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1();
		Thread t2 = new Thread(new MyThread2());
		// 이름을 지정한 쓰레드들
		MyThread1 tn1 = new MyThread1("yoiyoy");
		Thread tn2 = new Thread(new MyThread2(), "Jaeyun");
		t1.start();
		t2.start();
		tn1.start();
		tn2.start();
	}

}

class MyThread1 extends Thread {
	
	public MyThread1() {
		super();
	}
	
	public MyThread1(String string) {
		super(string);
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("thread name : " + getName());
		}
	}
}

class MyThread2 implements Runnable{
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("thread name : " + Thread.currentThread().getName());
		}
	}
}