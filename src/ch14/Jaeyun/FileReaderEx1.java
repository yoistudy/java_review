package ch14.Jaeyun;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderEx1 {

	public static void main(String[] args) {
		try {
			String fileName = "ch14_test.txt";
			FileInputStream fis = new FileInputStream(fileName);
			FileReader fr = new FileReader(fileName);
			int data = 0;
			while ((data = fis.read()) != -1) {
				System.out.print((char) data);
			}
			System.out.println();
			fis.close();
			
			while ((data = fr.read()) != -1) {
				System.out.print((char) data);
			}
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
