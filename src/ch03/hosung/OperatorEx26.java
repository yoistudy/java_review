package ch03.hosung;

public class OperatorEx26 {
	public static void main(String[] args) {
		int x = 3;
		int y = 5;
		
		System.out.println("x�� "+x+"�̰�, y�� "+y+"���϶�, ");
		System.out.println("x | y = "+ (x|y));
		System.out.println("x & y = "+ (x&y));
		System.out.println("x ^ y = "+ (x^y));
		
		System.out.println("true | false = "+ (true|false));
		System.out.println("true & false = "+ (true&false));
		System.out.println("true ^ false = "+ (true^false));
	}
}
