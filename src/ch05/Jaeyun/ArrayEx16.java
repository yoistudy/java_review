package ch05.Jaeyun;

import javax.swing.JOptionPane;

public class ArrayEx16 {

	public static void main(String[] args) {
		// 1~100 사이의 임의의 한 값을 얻음
		int answer = (int) (Math.random() * 100) + 1;
		int input = 0;
		String temp = "";
		int count = 0;
		
		do {
			count++;
			temp = JOptionPane.showInputDialog(
					"1~100 사이의 숫자를 입력하세요."
					+ " 끝내려면 -1를 입력하세요."
					);
			
			if (temp == null || temp.equals("-1")) break;
			System.out.print("입력값 : " + temp + ", ");
			input = Integer.parseInt(temp); // 형변환
			if (answer > input) {
				System.out.println("더 큰 수를 입력하세요.");
			} else if (answer < input) {
				System.out.println("더 작은 수를 입력하세요.");
			} else {
				System.out.println("오! 맞췄습니다.");
				System.out.println("시도 횟수는 " + count + "번 입니다.");
				break;
			}
		} while (true);

	}

}
