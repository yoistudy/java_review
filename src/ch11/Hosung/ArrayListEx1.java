package ch11.Hosung;

import java.util.*;

public class ArrayListEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list1 = new ArrayList(10);
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1,list2);
		
		Collections.sort(list1);//list1과 list2를 정렬한다.
		Collections.sort(list2);//Collections.sort(List l)
		print(list1,list2);
		
		System.out.println("list1.containsAll(list2):"
				+list1.containsAll(list2));
		
		list2.add("B");
		list2.add("C");
		list2.add(3,"A");
		
		list2.set(3,"AA");
		print(list1,list2);
		
		//list1에서 list2와 겹치 부분만 남기고 나머지는 삭제한다.
		System.out.println("list1.retainAll(list2):"
				+list1.retainAll(list2));
		print(list1,list2);
	}
	
	static void print(ArrayList list1, ArrayList list2){
		System.out.println("list1:"+list1);
		System.out.println("list2:"+list2);
		System.out.println();
	}

}
