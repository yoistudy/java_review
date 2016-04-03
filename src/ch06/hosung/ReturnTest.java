package ch06.hosung;

public class ReturnTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReturnTest r = new ReturnTest();
		
		int result=r.add(3,5);
		System.out.println(result);
		
		int[] result2={0}; //배열 생성 result2[0] 값 0으로 초기화
 		r.add(3,5,result2); //배열을 add메서드의 매개변수로 전달
		System.out.println(result2[0]);
	}
	
	int add(int a, int b){
		return a+b;
	}
	
	void add(int a, int b, int[] result){
		result[0]=a+b;//매개변수로 넘겨받은 배열에 연산결과를 저장
	}

}
