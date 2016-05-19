package ch08.Hosung;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

public class ExceptionEx14 {

	public static void main(String[] args) {
		PrintStream ps = null;
		FileOutputStream fos=null;
		try{
			fos = new FileOutputStream("error.log",true);
			ps = new PrintStream(fos);
			System.setErr(ps);
			
			System.out.println(1);
			System.out.println(2);
			System.out.println(3);
			System.out.println(0/0);//예외발
			System.out.println(4); //실행되지 않다.
		}catch(Exception ae){ //ArithmeticException대신 Exception을 사
			System.out.println("--------------------------");
			System.out.println("예외발생시간 : "+new Date());
			ae.printStackTrace(System.err);
			System.out.println("예외메시지 : "+ae.getMessage());
			System.out.println("--------------------------");
		}
		System.out.println(6);
	}//main메서드의 

}
