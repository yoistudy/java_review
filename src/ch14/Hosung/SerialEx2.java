package ch14.Hosung;

import java.io.*;
import java.util.*;

public class SerialEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String fileName = "UserInfo.ser";
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			ObjectInputStream in = new ObjectInputStream(bis);
			
			//객체를 읽을 때는 출력한 순서와 일치해야한다.
			UserInfo u1 = (UserInfo)in.readObject();
			UserInfo u2 = (UserInfo)in.readObject();
			ArrayList list = (ArrayList)in.readObject();
			
			System.out.println(u1);
			System.out.println(u2);
			System.out.println(list);
			in.close();
			System.out.println("직렬화가 잘 끝났습니다.");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
