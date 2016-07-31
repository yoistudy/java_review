package ch14.Hosung;

import java.io.*;

public class FileReaderEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String fileName = "test.txt";
			FileInputStream fis = new FileInputStream(fileName);
			FileReader fr = new FileReader(fileName);
			
			int data = 0;
			//FileInputStream 이용 파일 내용을 읽어서 출력
			while((data=fis.read())!=-1){
				System.out.print((char)data);
			}
			System.out.println();
			fis.close();
			
			//FileInputStream 이용 파일 내용을 읽어서 출력
			while((data=fr.read())!=-1){
				System.out.print((char)data);
			}
			System.out.println();
			fr.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
