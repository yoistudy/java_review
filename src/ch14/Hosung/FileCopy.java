package ch14.Hosung;

import java.io.*;

public class FileCopy {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream(args[0]);
		FileOutputStream fos = new FileOutputStream(args[1]);
		
		int data = 0;
		while((data=fis.read())!=-1){
			fos.write(data);
		}
		fis.close();
		fos.close();
	}

}
