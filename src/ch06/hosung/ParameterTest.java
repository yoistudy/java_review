package ch06.hosung;

class Data{int x;}

public class ParameterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data d = new Data();
		d.x=10;
		System.out.println("main() : x = "+d.x);
		
		change(d.x);
		System.out.println("After change(d.x)");
		System.out.println("main() : x = "+d.x);
	}
	
	static void change(int x){//기본형 매개변수
		x=1000;
		System.out.println("change() : "+x);
	}
}
