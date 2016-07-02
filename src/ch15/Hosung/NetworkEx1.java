package ch15.Hosung;

import java.net.*;
import java.util.Arrays;
import java.net.*;

public class NetworkEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress ip =  null;
		InetAddress[] ipArr = null;
		
		try {
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName() :"+ip.getHostName());
			System.out.println("getHostAddress() :"+ip.getHostAddress());
			System.out.println("toString() :"+ip.toString());
			
			byte[] ipAddr = ip.getAddress();
			System.out.println("getAddress() :"+Arrays.toString(ipAddr));
			
			String result = "";
			for(int i=0; i < ipAddr.length; i++){
				result += (ipAddr[i]<0)?ipAddr[i]+256 : ipAddr[i];
				result += ".";
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		try {
			ip = InetAddress.getLocalHost();
			System.out.println("getHostName :"+ip.getHostName());
			System.out.println("getHostAddress :"+ip.getHostAddress());
			System.out.println();
		} catch (UnknownHostException e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		try {
			ipArr = InetAddress.getAllByName("www.naver.com");
			for(int i=0; i < ipArr.length; i++){
				System.out.println("ipArr["+i+"] :"+ipArr[i]);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();// TODO: handle exception
		}
	}

}
