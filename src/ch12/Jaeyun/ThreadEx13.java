package ch12.Jaeyun;

/*
 * 쓰레드 동기화
 * 쓰레드의 공유된 자원의 사용시 동기화
 */
public class ThreadEx13 {

	public static void main(String[] args) {
		MyBankTxThread r = new MyBankTxThread();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}

}
class Account {
	int balance = 1000;
	
	public void withdraw(int money) {
		if (balance > money) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
			balance -= money;
			System.out.println("balance : " + balance);
		}
	}
	// 동기화된 메서드
	public synchronized void withdrawSync(int money) {
		if (balance > money) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
			balance -= money;
			System.out.println("balance : " + balance);
		}
	}
}

class MyBankTxThread implements Runnable {
	Account acc = new Account();
	
	@Override
	public void run() {
		while (acc.balance > 0) {
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdrawSync(money);
		}
	}
	
}
