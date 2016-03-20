package ch03.Jaeyun;

public class OperatorEx22 {

	public static void main(String[] args) {
		int temp;
		
		System.out.println(-8);
		System.out.println(Integer.toBinaryString(-8));
		System.out.println();

		temp = -8 << 1;
		System.out.println("-8 << 1 = " + temp);
		System.out.println(Integer.toBinaryString(temp));
		System.out.println();
		
		temp = -8 << 2;
		System.out.println("-8 << 2 = " + temp);
		System.out.println(Integer.toBinaryString(temp));
		System.out.println();
		
		System.out.println(-8);
		System.out.println(Integer.toBinaryString(-8));
		System.out.println();

		temp = -8 >> 1;
		System.out.println("-8 >> 1 = " + temp);
		System.out.println(Integer.toBinaryString(temp));
		System.out.println();
		
		temp = -8 >> 2;
		System.out.println("-8 >> 2 = " + temp);
		System.out.println(Integer.toBinaryString(temp));
		System.out.println();
		
		System.out.println(-8);
		System.out.println(Integer.toBinaryString(-8));
		System.out.println();
		
		// >>> 연산자는 쉬프트 후 부호에 상관없이 빈자리를 0으로 채운다
		temp = -8 >>> 1; 
		System.out.println("-8 >>> 1 = " + temp);
		System.out.println(Integer.toBinaryString(temp)); // 0으로 채워진 앞자리는 출력시 생략됨
		System.out.println();
		
		temp = -8 >>> 2;
		System.out.println("-8 >>> 2 = " + temp);
		System.out.println(Integer.toBinaryString(temp)); // 0으로 채워진 앞자리는 출력시 생략됨
		System.out.println();
	}

}
