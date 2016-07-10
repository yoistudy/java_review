package ch12.Jaeyun;

import javax.swing.JOptionPane;

/* 멀티 쓰레드
 * 두개의 작업(입력받은 값을 출력, 감소하는 숫자출력)을 멀티 쓰레드로 실행
 */
public class ThreadEx4 {

	public static void main(String[] args) {
		Thread t = new Thread(new MyPrintDecrementalNumberThread());
		t.start();
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
		System.out.println("입력한 값은 \"" + input + "\"입니다");
	}

}

class MyPrintDecrementalNumberThread implements Runnable {
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
	}
}
