package com.study.ch03;

public class OperatorEx26 {
	public static void main(String[] args) {
		int x = 3;
		int y = 5;
		
		System.out.println("x는 "+x+"이고, y는 "+y+"이일때, ");
		System.out.println("x | y = "+ (x|y));
		System.out.println("x & y = "+ (x&y));
		System.out.println("x ^ y = "+ (x^y));
		
		System.out.println("true | false = "+ (true|false));
		System.out.println("true & false = "+ (true&false));
		System.out.println("true ^ false = "+ (true^false));
	}
}
