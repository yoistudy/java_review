package com.study.ch03;

public class OperatorEx8 {
	public static void main(String[] args) {
		byte a = 10;
		byte b = 20;
		byte c = (byte) (a + b); //byte c = a + b // -> 에러발생 형변화 필요  
		System.out.println(c);
	}
}
