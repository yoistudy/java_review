package ch06.Jaeyun;

class Data {
	int x;
}

public class ParameterTest {

	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x = " + d.x);
		
		change(d.x);
		System.out.println("After change(d.x)");
		System.out.println("main() : x = " + d.x);
	}

	static void change(int x) { // 기본형 매개변수
		x = 10000;
		System.out.println("change() : x = " + x);
		
	}

}
