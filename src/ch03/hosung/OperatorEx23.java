package com.study.ch03;

public class OperatorEx23 {
	public static void main(String[] args) {
		if(10 == 10.0f){
			System.out.println("10과 10.0f는 같다");
		}
		
		if('0' != 0){
			System.out.println("'0'과 0은 같지 않다.");
		}
		
		if('A' == 65){
			System.out.println("'A'는  65와 같다.");
		}
		
		int num=5;
		if(num > 0 && num < 9){
			System.out.println("5는 0보다 크고 , 9보다는 작다.");
		}
	
	}
}
