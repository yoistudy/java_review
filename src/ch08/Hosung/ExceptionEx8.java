package ch08.Hosung;

public class ExceptionEx8 {

	public static void main(String[] args) {
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}//Exception을 강제로 발생시
	}//main메서드의 

}
