package ch14.Jaeyun;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx1 {

	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile("test.dat", "rw");
			System.out.println("파일 포인터 위치 " + raf.getFilePointer());
			raf.writeInt(100); // int가 4byte이므로 파일포인터 4증가
			System.out.println("파일 포인터 위치 " + raf.getFilePointer());
			raf.writeLong(100L); // long이 8byte이므로 파일포인터 8증가
			System.out.println("파일 포인터 위치 " + raf.getFilePointer());
		} catch (IOException e) {}
		

	}

}
