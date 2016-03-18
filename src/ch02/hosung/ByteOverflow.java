package com.study.ch02;

public class ByteOverflow {
	public static void main(String[] args) {
		byte b = 0; //byte형 변수 b를 선언하고 0으로 초기화
		int i = 0;
		
		//반복문 이용 b의 값을 1씩, 0부터 270까지 증가
		for(int x=0; x<=270; x++){
			System.out.print(b++);
			System.out.print('\t');
			System.out.println(i++);
		}
	}
}
