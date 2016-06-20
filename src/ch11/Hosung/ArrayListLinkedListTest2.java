package ch11.Hosung;

import java.util.*;

public class ArrayListLinkedListTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al = new ArrayList(1000000);
		LinkedList ll = new LinkedList();
		add(al);
		add(ll);
		
		System.out.println("= 접근 시간 테스트 =");
		System.out.println("ArrayList :"+access(al));
		System.out.println("LinkedList :"+access(ll));
	}

	public static void add(List list){
		for(int i=0; i<100000; i++) list.add(i+"");
	}
	
	public static long access(List list){
		long start = System.currentTimeMillis();
		for(int i=0; i<10000; i++)list.get(i);
		long end=System.currentTimeMillis();
		return end - start;
	}
}
