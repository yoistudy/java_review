package com.study.ch03;

public class OperatorEx10 {
	public static void main(String[] args) {
		int a=1000000;
		int b=2000000;
		long c=a*b; //int * int 형이기때문에 a 나  b 둘중 하나를 long형으로 바꿔야함
		System.out.println(c);
	}
}
