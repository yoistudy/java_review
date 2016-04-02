package ch06.Jaeyun;

public class CallStactTest {

	public static void main(String[] args) {
		firstMethod();

	}

	static void firstMethod() {
		secondMethod();
		
	}

	static void secondMethod() {
		System.out.println("secondMethod was called");
	}
	
	

}
