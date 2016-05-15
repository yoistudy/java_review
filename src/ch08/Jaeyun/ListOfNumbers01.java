package ch08.Jaeyun;

import java.io.*;
import java.util.List;
import java.util.ArrayList;


public class ListOfNumbers01 {

	private List<Integer> list;
	private static final int SIZE = 10;

	public ListOfNumbers01 () {
		list = new ArrayList<Integer>(SIZE);
		for (int i = 0; i < SIZE; i++) {
			list.add(new Integer(i));
		}
	}
	
	// 알림 : 이 메서드를 주석 풀면 컴파일 되지 않는다
//	public void writeList() {
//		// FileWriter 생성자는 IOException throw하며 반드시 캐치 해야한다
//		PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
//
//		for (int i = 0; i < SIZE; i++) {
//			// get() 메소드는 IndexOutOfBoundsException throw하며 반드시 캐치 해야한다
//			out.println("Value at: " + i + " = " + list.get(i));
//		}
//		out.close();
//	}
}