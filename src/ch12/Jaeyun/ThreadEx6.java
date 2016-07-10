package ch12.Jaeyun;

/*
 * 우선순위
 * 멀티 쓰레드의 우선순위
 */
public class ThreadEx6 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyPrintThread("-"), "t1");
		Thread t2 = new Thread(new MyPrintThread("|"), "t2");
		t2.setPriority(7);
		// t1의 priority를 따로 set하지 않았기 때문에 부모 쓰레드인 main 쓰레드로부터 상속받은 priority(==5)를 가짐
		System.out.println("priority of " + t1.getName() + ": " + t1.getPriority());
		System.out.println("priority of " + t2.getName() + ": " + t2.getPriority());
		t1.start();
		t2.start();
	}

}