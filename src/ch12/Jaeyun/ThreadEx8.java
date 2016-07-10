package ch12.Jaeyun;

import java.util.Iterator;
import java.util.Map;

/*
 * 대몬 쓰레드
 * auto save 기능의 대몬 쓰레드 실행
 */
public class ThreadEx8 {

	public static void main(String[] args) {
		MyAutoSaveDeamonThread r1 =  new MyAutoSaveDeamonThread();
		Thread t1 = new Thread(r1, "AutoSaveDeamonThread");
		t1.setDaemon(true); 
		t1.start();
		
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println(i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			
			if (i == 2) {
				r1.setAutoSave(true);
			}
		}
		
		
		// 실행 중 또는 대기 상태의 모든 완료 되지 않은 쓰레드의 호출 스택 출력하여 
		// 쓰레드의 이름과 쓰레드 그룹, 대몬 쓰레드 여부를 확인
		
		Map map = Thread.getAllStackTraces();
		Iterator it = map.keySet().iterator();
		
		int x = 0;
		while (it.hasNext()) {
			Object obj = it.next();
			Thread t = (Thread)(obj);
			StackTraceElement[] ste = (StackTraceElement[])(map.get(obj));
			
			System.out.println("[" + ++x + "]\tname : " + t.getName()
					+ "\n\t group : " + t.getThreadGroup()
					+ "\n\t deamon : " + t.isDaemon());
			for (int i = 0; i < ste.length; i++) {
				System.out.println(ste[i]);
			}
			System.out.println();
		}
		
		
	}

}

class MyAutoSaveDeamonThread implements Runnable {
		
	private boolean autoSave;

	public void run() {
		
		while (true) {
			try {
				Thread.sleep(3 * 1000);
			} catch (InterruptedException e) {}
			
			if (isAutoSave()) {
				save();
			}
		}
	}
	
	private void save() {
		System.out.println("저장 되었습니다.");
	}

	public boolean isAutoSave() {
		return autoSave;
	}

	public void setAutoSave(boolean isAutoSave) {
		this.autoSave = isAutoSave;
		System.out.println("auto save " +  (isAutoSave ? "on" : "off"));
	}
	
	
	
	
}
