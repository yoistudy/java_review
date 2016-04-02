package ch06.Jaeyun;

class Car3 {
	String color;
	String gearType;
	int door;
	
	public Car3() {
		this("white", "auto", 4);
	}
	
	public Car3(Car3 c) { // 인스턴스 복사를 위한 생성자
		this.color = c.color;
		this.gearType = c.gearType;
		this.door = c.door;
	}
	
	public Car3(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}

public class CarTest3 {

	public static void main(String[] args) {
		Car3 c1 = new Car3();
		Car3 c2 = new Car3(c1);
		
		System.out.println("c1의 color=" + c1.color + ", gearType=" + c1.gearType + ", door=" + c1.door);
		System.out.println("c2의 color=" + c2.color + ", gearType=" + c2.gearType + ", door=" + c2.door);

		c1.gearType = "manual"; // c1의 인스턴스 변수 door의 값을 변경한다
		
		System.out.println("c1의 color=" + c1.color + ", gearType=" + c1.gearType + ", door=" + c1.door);
		System.out.println("c2의 color=" + c2.color + ", gearType=" + c2.gearType + ", door=" + c2.door);

	}

}
