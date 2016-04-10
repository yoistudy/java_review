package ch06.hosung;

public class CallStackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		firstMethod();
	}

	static void firstMethod(){
		secondMethod();
	}
	
	static void secondMethod(){
		System.out.println("secondMethod()");
	}
}
