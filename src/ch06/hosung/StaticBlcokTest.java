package ch06.hosung;

public class StaticBlcokTest {
	
	static int[] arr = new int[10];
	
	static{
		for(int i=0; i<arr.length; i++){
			//1과 10사이의 임의의 값을 배열 arr에 저장
			arr[i]=(int)(Math.random()*10)+1;
			}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<arr.length; i++){
			System.out.println("arr["+i+"] :"+arr[i]);
		}
	}

}
