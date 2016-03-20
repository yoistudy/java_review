package ch03.Jaeyun;

public class OperatorEx10 {

	public static void main(String[] args) {
		int a = 1000000; // 1,000,000
		int b = 2000000; // 1,000,000
		long c = a * b; // 2,000,000,000,000가 아니라 int의 오버플로된 값이 할당
		
		System.out.println(c);
		
		long product = (long)1000000 * 2000000L; // '(long)'이나 'L'으로 피연산자들을 형변환해야 한다 
		long intRangeSize = (long) Math.pow(2, 32);
		long intRangeTo = (long) Math.pow(2, 31) - 1;
		long intRangeFrom = -(long) Math.pow(2, 31);
		long overflewValue = (product - (intRangeTo + 1)) % intRangeSize;
		
		System.out.println(intRangeFrom + overflewValue); // 오버플로된 값 확인
		System.out.println(product); // 바른 결과
	}

}
