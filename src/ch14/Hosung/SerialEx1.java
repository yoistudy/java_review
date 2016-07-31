package ch14.Hosung;

import java.io.*;
import java.util.*;

public class SerialEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String fileName = "UserInfo.ser";
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			ObjectOutputStream out = new ObjectOutputStream(bos);
			
			UserInfo u1 = new UserInfo("JavaMan","1234",30);
			UserInfo u2 = new UserInfo("JaWoaMan","1234",30);
			
			ArrayList list = new ArrayList();
			list.add(u1);
			list.add(u2);
			
			//객체를 직렬화한다.
			out.writeObject(u1);
			out.writeObject(u2);
			out.writeObject(list);
			out.close();
			System.out.println("직렬화가 잘 끝났습니다.");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
