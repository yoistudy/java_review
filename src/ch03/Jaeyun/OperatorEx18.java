package ch03.Jaeyun;

public class OperatorEx18 {

	public static void main(String[] args) {
		float pi = 3.141592f;
		float shortPi = Math.round(pi * 1000) / 1000f; //  Math.round(pi * 1000)에서 소수 첫째점 자리 반올림이 됬다
		
		System.out.println(shortPi);
	}

}
