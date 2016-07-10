package ch12.Jaeyun;

/*
 * 쓰레드 동기화
 * 쓰레드의 공유된 자원의 사용
 */
public class ThreadEx12 {

	public static void main(String[] args) {
		MyCounterThread r = new MyCounterThread();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}

}

class MyCounterThread implements Runnable {
	int instanceVar = 0; // 인스턴스 변수
	
	@Override
	public void run() {
		int localVar = 0; // 로컬 변수
		String name = Thread.currentThread().getName();
		
		while (localVar < 3) {
			System.out.println(name + "local var : " + (++localVar));
			System.out.println(name + "instance var : " + (++instanceVar));
			System.out.println();
		}
		
	}
	
}
