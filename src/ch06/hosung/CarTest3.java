package ch06.hosung;

class Car3{
	String color; //색상
	String gearType; //변속기 종류
	int door;	//문의 개수 
	
	Car3(){
		this("white","auto",4);
	}
	
	Car3(Car3 c){//인스턴스의 복사를 위한 생성자
		color = c.color;
		gearType = c.gearType;
		door = c.door;
	}
	
	Car3(String color, String gear, int door){
		this.color = color;
		this.gearType = gear;
		this.door =door;
	}
}

public class CarTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car3 c1 = new Car3();
		Car3 c2=new Car3(c1);
		
		System.out.println("c1의 color="+c1.color+", gearType="+c1.gearType+", door="+c1.door);
		System.out.println("c2의 color="+c2.color+", gearType="+c2.gearType+", door="+c2.door);
		
		c1.door=100;//c1의 인스턴스변수 door의 값을 변경
		System.out.println("c1의 color="+c1.color+", gearType="+c1.gearType+", door="+c1.door);
		System.out.println("c2의 color="+c2.color+", gearType="+c2.gearType+", door="+c2.door);
		
	}

}
