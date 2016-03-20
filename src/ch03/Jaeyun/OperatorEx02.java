package ch03.Jaeyun;

public class OperatorEx02 {

	public static void main(String[] args) {
		int i = 5;
		int j = 0;
		
		j = i++; // j에 먼저 할당되고 i의 값이 1 증가한다
		System.out.println("j = i++ 실행 후, i=" + i + ", j=" + j);
		
		//다시 초기화
		i = 5;
		j = 0;
		j = ++i; // i의 값이 1 증가하고 j에 할당 된다
		System.out.println("j = ++i 실행 후, i=" + i + ", j=" + j);

	}

}
