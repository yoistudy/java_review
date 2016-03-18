package com.study.ch03;

public class OperatorEx6 {
	public static void main(String[] args) {
		byte b =10;
		//byte result=~b; // ~의 연산결과가 in라서 byte형 변수에 저장 불가
		byte result=(byte)~b;
		
		System.out.println("b = "+b);
		System.out.println("~b = "+result);
	}
}
