package ch14.Jaeyun;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerialEx1 {

	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			ObjectOutputStream out = new ObjectOutputStream(bos);
			
			UserInfo userInfo1 = new UserInfo("yoiyoy", "yyxx", 29);
			UserInfo userInfo2 = new UserInfo("Jaeyun", "jjxx", 29);
			
			ArrayList<UserInfo> list = new ArrayList<>();
			list.add(userInfo1);
			list.add(userInfo2);
			
			// 객체 Serialization
			out.writeObject(userInfo1);
			out.writeObject(userInfo2);
			out.writeObject(list);
			out.close();
			System.out.println("Serialization done");
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {}
		
	}

}
