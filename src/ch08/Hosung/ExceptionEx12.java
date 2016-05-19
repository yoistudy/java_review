package ch08.Hosung;

public class ExceptionEx12 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try{
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4); //실행되지 않느다.
		}catch(ArithmeticException ae){ //ArithmeticException대신 Exception을 사
			ae.printStackTrace();
			System.out.println("예외메시지 : "+ae.getMessage());
		}
		System.out.println(6);
	}//main메서드의 

}
