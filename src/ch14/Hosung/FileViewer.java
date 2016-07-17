package ch14.Hosung;

import java.io.*;

public class FileViewer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream(args[0]);
		int data = 0;
		while((data=fis.read())!=-1){
			char c =(char)data;
			System.out.println(c);
		}
	}

}
