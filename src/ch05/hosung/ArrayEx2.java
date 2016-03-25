package ch05.hosung;

public class ArrayEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] score={100,88,100,100,90};
		
		int max=score[0];
		int min=score[0];
		
		for(int i=0; i<score.length; i++){
			if(score[i]>max){
				max=score[i];
			}
			if(score[i]<min){
				min=score[i];
			}
		}
		
		System.out.println("최대값 : "+max);
		System.out.println("최소값 : "+min);
	}

}
