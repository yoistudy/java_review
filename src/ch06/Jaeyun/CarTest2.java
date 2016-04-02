package ch06.Jaeyun;

class Car2 {
	String color;
	String gearType;
	int door;
	
	public Car2() {
		// 생성자의 이름으로 클래스이름대신 this를 사용
		// 다른 생성자 호출 할 때는 첫 줄에서만 호출 가능
		this("white", "auto", 4); 
	}
	
	public Car2(String color) {
		this(color, "auto", 4);
	}
	
	public Car2(String color, String gearType, int door) {
		// this는 참조변수로 인스턴스 자신을 가리킨다
		// 'this.인스턴스변수'으로 인스턴스 변수를 사용한다
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
}

public class CarTest2 {

	public static void main(String[] args) {
		Car2 c1 = new Car2();
		Car2 c2 = new Car2("black");
		
		System.out.println("c1의 color=" + c1.color + ", gearType=" + c1.gearType + ", door=" + c1.door);
		System.out.println("c2의 color=" + c2.color + ", gearType=" + c2.gearType + ", door=" + c2.door);


	}

}
