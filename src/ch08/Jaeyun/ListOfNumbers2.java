package ch08.Jaeyun;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

// 알림 : 이 클래스는 컴파일 되지 않는다
public class ListOfNumbers2 {

	private List<Integer> list;
	private static final int SIZE = 10;

	public ListOfNumbers2 () {
		list = new ArrayList<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++) {
			list.add(new Integer(i));
		}
	}

	public void writeList() {
		// FileWriter 생성자는 IOException throw하며 반드시 캐치 해야한다
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("OutFile.txt"));

			for (int i = 0; i < SIZE; i++) {
				// get() 메소드는 IndexOutOfBoundsException throw하며 반드시 캐치 해야한다
				out.println("Value at: " + i + " = " + list.get(i));
			}
			out.close();			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}
	}
}