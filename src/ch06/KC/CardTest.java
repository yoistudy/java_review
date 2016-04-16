package ch06.KC;

/**
 * Created by Daniel on 2016. 4. 2..
 */
public class CardTest {

    public static void main(String[] args) {

        /**
         * 클래스 변수에 접근하는 방법
         * [클래스명].[클래스변수]
         */
        System.out.println("Card.width = " + Card.width);
        System.out.println("Card.height = " + Card.height);

        /**
         * 인스턴스 생성
         */
        Card c1 = new Card();
        c1.kind = "Heart"; // 인스턴스 변수
        c1.number = 7;     // 인스턴스 변수

        Card c2 = new Card();
        c2.kind = "Spade"; // 인스턴스 변수
        c2.number = 4;     // 인스턴스 변수

        System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
        System.out.println("c2은 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");

        c1.width = 50;
        c1.height = 80;


        /**
         * 즉, 클래스 변수(static변수)는 모든 인스턴스에서 그 값을 공유한다.
         */
        System.out.println("Card.width / Card.height 변경 후");
        System.out.println("c1은 " + c1.kind + ", " + c1.number + "이며, 크기는 (" + c1.width + ", " + c1.height + ")");
        System.out.println("c2은 " + c2.kind + ", " + c2.number + "이며, 크기는 (" + c2.width + ", " + c2.height + ")");
    }


}


class Card{
    String kind; // 인스턴스 변수
    int number;
    static int width = 100; // 클래스 변수
    static int height= 250;
}