package com.study.ch04;

public class FlowEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int visitCount=5;
			if(visitCount < 1){
				System.out.println("처음 오셨군요. 방문해 주셔서 감사합니다.");	
			}else{
				System.out.println("다시 방문해 주셔서 감사합니다.");
			}
			System.out.println("방문횟수는 "+ ++visitCount +"번 입니다.");
		}
}
