package ch10.Hosung;

import java.util.*;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2,"Database");
		list.add("iBatis");
		
		int size=list.size();
		System.out.println("총 갯수: "+size);
		System.out.println();
		
		String skill=list.get(2);
		System.out.println("2: "+skill);
		System.out.println();
		
		for(int i=0; i<list.size();i++){
			String str = list.get(i);
			System.out.println(i+":"+str);
		}
		System.out.println();
		
		list.remove(2);
		list.remove(2);
		list.remove("iBatis");
		
		for(int i=0; i<list.size();i++){
			String str = list.get(i);
			System.out.println(i+":"+str);
		}
	}

}
