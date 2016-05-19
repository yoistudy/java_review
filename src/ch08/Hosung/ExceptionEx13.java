package ch08.Hosung;

import java.io.PrintStream;

public class ExceptionEx13 {

	public static void main(String[] args) {
		
		PrintStream ps = null;
		
		try{
			ps = new PrintStream("error.log");
			
			System.out.println(1);
			System.out.println(2);
			System.out.println(3);
			System.out.println(0/0);//예외발
			System.out.println(4); //실행되지 않다.
		}catch(Exception ae){ //ArithmeticException대신 Exception을 사
			ae.printStackTrace(ps);
			System.out.println("예외메시지 : "+ae.getMessage());
		}
		System.out.println(6);
	}//main메서드의 

}
