package ch14.Hosung;

import java.io.*;

public class StnadardIOEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintStream ps =null;
		FileOutputStream fos =null;
		
		try {
			fos = new FileOutputStream("test.txt");
			ps = new PrintStream(fos);
			System.setOut(ps); //System.out의 출력대상을 test.txt파일로 변
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("File not found.");
		}
		
		System.out.println("Hello by System.out");
		System.err.println("Hello by System.err");
		
	}

}
