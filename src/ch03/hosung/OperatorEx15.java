package com.study.ch03;

public class OperatorEx15 {
	public static void main(String[] args) {
		char c = 'a';
		for(int i=0; i<26; i++){
			System.out.print(c++);//'a'부터 26개 문자 출력
		}
		
		System.out.println();//줄바꿈
		
		c = 'A';
		for(int i=0; i<26; i++){
			System.out.print(c++);//'A'부터 26개 문자 출력
		}
		
		System.out.println();//줄바꿈
		
		c='0';
		for(int i=0; i<10; i++){
			System.out.print(c++);//'0'부터 10개 문자 출력
		}
		System.out.println();
	}
}
