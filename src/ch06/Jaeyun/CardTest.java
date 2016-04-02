package ch06.Jaeyun;
class Card {
	String kind;
	int number;
	static int width = 100;
	static int height = 250;
}

public class CardTest {

	public static void main(String[] args) {
		// 클래스 변수(static 변수)는 객체생성 없이 '클래스이름.클래스변수'로 직접 사용가능
		System.out.println("Card.width = " + Card.width);
		System.out.println("Card.width = " + Card.height);
		
		Card c1 = new Card();
		c1.kind = "Heart";
		c1.number = 7;
		
		Card c2 = new Card();
		c2.kind =  "Spade";
		c2.number = 4;
		
		System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며 크기는 (" + c1.width + ", " + c1.height + ")");
		System.out.println("c2은 " + c2.kind + ", " + c2.number + "이며 크기는 (" + c2.width + ", " + c2.height + ")");
		System.out.println("c1의 width와 height를 각각 50, 80으로 변경합니다.");
		// 사용할 때 '인스턴스.클래스변수'로 접근하는 것보다 '클래스.클래스변수'로 사용하면 클래스변수 사용의 의미가 더 명확해진다  
		c1.width = 50; // Card.width = 50;
		c1.height = 80; // Card.height = 80; 
		System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며 크기는 (" + c1.width + ", " + c1.height + ")");
		System.out.println("c2은 " + c2.kind + ", " + c2.number + "이며 크기는 (" + c2.width + ", " + c2.height + ")");
				

	}

}
