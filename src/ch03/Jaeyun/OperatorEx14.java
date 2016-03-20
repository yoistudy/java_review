package ch03.Jaeyun;

public class OperatorEx14 {

	public static void main(String[] args) {
		char c1 = 'a';
		// char c2 = c1 + 1; 컴파일 에러
		char c2 = 'a' + 1; // 리터럴간 연산은 컴파러가 컴파일때 미리 계산한 값으로 대체됨
		
		System.out.println(c2);
	}

}
