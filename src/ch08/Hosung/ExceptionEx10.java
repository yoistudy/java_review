package ch08.Hosung;

public class ExceptionEx10 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try{
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4); //실행되지 않느다.
		}catch(Exception e){ //ArithmeticException대신 Exception을 사
			System.out.println(5);
		}//try-catch end
		System.out.println(6);
	}//main메서드의 

}
