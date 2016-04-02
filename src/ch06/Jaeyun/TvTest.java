package ch06.Jaeyun;

class Tv {
	String color;
	boolean power;
	int channel;
	
	void power() { power = !power; }
	void channerlUp() { ++channel; } 
	void channerlDown() { --channel; }
}

public class TvTest {

	public static void main(String[] args) {
		Tv t; // Tv타입 변수 t 선언
		
		t = new Tv(); // new 연산자로 Tv타입 인스턴스를 생헝
		t.channel = 7; // 인스턴스의 멤버변수 접근
		t.channerlDown(); // 인스턴스의 메서드 호출
		System.out.println("현재 채널은 " + t.channel + "입니다.");

	}

}
