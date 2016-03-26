package ch05.Jaeyun;

public class ArrayEx12 {

	public static void main(String[] args) {
		char[] abc = {'A', 'B', 'C', 'D'};
		char[] number = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		char[] result;
		
		System.out.println(new String(abc));
		System.out.println(new String(number));
		result = new char[abc.length + number.length];
		// 배열 abc를 배열 number의 첫 째 위치부터 배열 abc크기 만큼 복사
		System.arraycopy(abc, 0, result, 0, abc.length);
		System.arraycopy(number, 0, result, abc.length, number.length);
		System.out.println(new String(result));

	}

}
