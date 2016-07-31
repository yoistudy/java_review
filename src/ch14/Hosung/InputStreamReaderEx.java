package ch14.Hosung;

import java.io.*;

public class InputStreamReaderEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line = "";
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println("사용중인 OS의 인코딩 :"+isr.getEncoding());
			
			do{
				System.out.print("문장을 입력하세요. 마치시려면 q를 입력하세요.");
				line = br.readLine();
				System.out.println("입력하신 문장 :"+line);
			}while(!line.equals("q"));
			
			//br.close();//System.in과 같은 표준입출력은 닫지 않아도된다.
			System.out.println("프로그램을 종료합니다.");
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
