package ch14.Jaeyun;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx3 {

	public static void main(String[] args) {
		int sum = 0;
		
		try {
			RandomAccessFile raf = new RandomAccessFile("score2.dat", "r");
			int i = 4;
			
			while (true) {
				raf.seek(i);
				sum += raf.readInt();
				i += 16;
			}
		} catch (EOFException e) {
			System.out.println("sum : " + sum);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
