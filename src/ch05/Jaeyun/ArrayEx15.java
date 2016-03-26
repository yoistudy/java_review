package ch05.Jaeyun;

public class ArrayEx15 {

	public static void main(String[] args) {
		int result = 0;
		int num1;
		int num2;
		char op;
		
		if (args.length != 3) {
			System.out.println("사용법 ---");
			System.out.println("intNum1 사칙연산자 intNum2");
			System.out.println("입력받은 정수를 사칙 연산합니다");
			System.exit(0);
		}
		
		// 연산을 위한 형변환
		num1 = Integer.parseInt(args[0]);
		num2 = Integer.parseInt(args[2]);
		op = args[1].charAt(0);
		
		try {
			switch (op) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			default:
				System.out.println("\'" + op +"\'는 지원되지 않는 연산입니다");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("에러 : " + e.getMessage());
			System.exit(0);
		}
		
		System.out.println(num1 + " " + op + " " + num2 + " = " + result);
		

	}

}
