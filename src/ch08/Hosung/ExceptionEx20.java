package ch08.Hosung;

public class ExceptionEx20 {

	public static void main(String[] args) throws Exception{
		try{
			method1();
		}catch(Exception e){
			System.out.println("main 메서드에서 예외가 처리 ");
			e.printStackTrace();
		}
		
	}
	
	static void method1() throws Exception{
		throw new Exception();
	}

}
