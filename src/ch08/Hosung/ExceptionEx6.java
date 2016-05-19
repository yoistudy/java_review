package ch08.Hosung;

public class ExceptionEx6 {

	public static void main(String[] args) {
		try{
			Exception e = new Exception("고의로 발생 시킴 ");
			throw e;//예외를 발시킴
			//throw new Exception("고의로 발생시킴 ");
		}catch(Exception e){
			System.out.println("에러 메세지 : "+e.getMessage());
			e.printStackTrace();
		}//try-catch end
		System.out.println("프로그램 정상 종");
	}//main메서드의 

}
