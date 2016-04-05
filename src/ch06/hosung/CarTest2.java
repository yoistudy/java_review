package ch06.hosung;

class Car2{
	String color; //색상
	String gearType; //변속기 종류
	int door;	//문의 개수 
	
	Car2(){
		this("white","auto",4);
	}
	
	Car2(String color){
		this(color,"auto",4);
	}
	
	Car2(String color, String gear, int door){
		this.color = color;
		this.gearType = gear;
		this.door =door;
	}
}

public class CarTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car2 c1 = new Car2();
		Car2 c2=new Car2("blue");
		
		System.out.println("c1의 color="+c1.color+", gearType="+c1.gearType+", door="+c1.door);
		System.out.println("c2의 color="+c2.color+", gearType="+c2.gearType+", door="+c2.door);
	}

}
