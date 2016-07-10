package ch12.Jaeyun;

/*
 * 쓰레드 그룹
 * 쓰레드의 그룹 생성과 포함 
 */
public class ThreadEx7 {

	public static void main(String[] args) {
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup tGrp1 = new ThreadGroup("TreadGroup1");
		ThreadGroup tGrp2 = new ThreadGroup("TreadGroup2");
		ThreadGroup childTGrp1 = new ThreadGroup(tGrp1, "ChildTreadGroup1");
		
		// 최대 우선순위를 3으로 변경
		tGrp1.setMaxPriority(3); 
		
		Thread t1 = new Thread(tGrp1, "Thread1");
		Thread t2 = new Thread(childTGrp1, "Thread2");
		Thread t3 = new Thread(tGrp2, "Thread3");
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("list of thread group : " + main.getName()
				+ ",\t active thread group : " + main.activeGroupCount()
				+ ",\t active thread : " + main.activeCount());
		main.list();
		
		
	}

}