package com.study.ch03;

public class OperatorEx11 {
	public static void main(String[] args) {
		long a=1000000 * 1000000; //int * int 형이기때문
		long b=1000000 * 1000000L;
		System.out.println(a);
		System.out.println(b);
	}
}
