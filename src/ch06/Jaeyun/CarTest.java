package ch06.Jaeyun;

class Car1 {
	String color;
	String gearType;
	int door;
	
	public Car1() { }
	
	public Car1(String c, String g, int d) {
		color = c;
		gearType = g;
		door = d;
	}
	
}

public class CarTest {

	public static void main(String[] args) {
		Car1 c1 = new Car1();
		c1.color  = "white";
		c1.gearType = "auto";
		c1.door = 4;
		
		Car1 c2 = new Car1("black", "manual", 2);
		
		System.out.println("c1의 color=" + c1.color + ", gearType=" + c1.gearType + ", door=" + c1.door);
		System.out.println("c2의 color=" + c2.color + ", gearType=" + c2.gearType + ", door=" + c2.door);

	}

}
