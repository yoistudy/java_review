package ch05.Jaeyun;

public class ArrayEx13 {

	public static void main(String[] args) {
		// args에는 공백문자로 구분된 입력값들이 들어온다
		// 공백이 들어간 하나의 입력값이라면 ""로 감싸준다
		System.out.println("매개변수의 개수 : " + args.length);
		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "] = \"" + args[i] + "\"");
		}

	}

}
