package ch14.Hosung;

import java.io.*;

public class DataInputStreamEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream fis = new FileInputStream("sample.dat");
			DataInputStream dis = new DataInputStream(fis);
			
			System.out.println(dis.readInt());
			System.out.println(dis.readFloat());
			System.out.println(dis.readBoolean());
			
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();// TODO: handle exception
		}
		
	}

}
