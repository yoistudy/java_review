package ch06.hosung;

public class ParameterTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data d = new Data();
		d.x=10;
		System.out.println("main() : x = "+d.x);
		
		change(d);
		System.out.println("After change(d.x)");
		System.out.println("main() : x = "+d.x);
	}
	
	static void change(Data d){//기본형 매개변수
		d.x=1000;
		System.out.println("change() : "+d.x);
	}
}
