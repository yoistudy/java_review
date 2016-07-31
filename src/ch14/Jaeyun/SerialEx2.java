package ch14.Jaeyun;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerialEx2 {

	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			ObjectInputStream in = new ObjectInputStream(bis);
			
			// 객체 Deserialization
			UserInfo userInfo1 = (UserInfo) in.readObject();
			UserInfo userInfo2 = (UserInfo) in.readObject();
			@SuppressWarnings("unchecked")
			ArrayList<UserInfo> list = (ArrayList<UserInfo>) in.readObject();
			
			System.out.println(userInfo1);
			System.out.println(userInfo2);
			System.out.println(list);
			in.close();
			System.out.println("Deserialization done");
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
		}
	}

}
