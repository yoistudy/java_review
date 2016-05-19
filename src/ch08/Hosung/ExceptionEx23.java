package ch08.Hosung;


public class ExceptionEx23 {

	public static void main(String[] args) {
		try{
			method1();
		}catch(Exception e){
			System.out.println("main메서드에서 예외 처리 ");
		}
	}
	
	static void method1() throws Exception{
		try{
			throw new Exception();
		}catch(Exception e){
			System.out.println("method1메서드에서 예외가 처리 ");
			throw e; //예외발생 
		}
	}
}
