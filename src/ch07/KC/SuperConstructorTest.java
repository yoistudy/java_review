package ch07.KC;

/**
 * Created by Daniel on 2016. 5. 8..
 */
public class SuperConstructorTest {

    public static void main(String[] args) {
        SubConstructor sub = new SubConstructor(10,20);
        sub.printVariable();
    }
}


class SuperConstructor{
    int x;
    int y;


    public SuperConstructor(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


class SubConstructor extends SuperConstructor{
    int x;
    int y;



    public SubConstructor(int x, int y) {
        // 부모 클래스에 생성해놓은 생성자가 있다면, 반드시 super()를 선언해줘야 한다.
        // 기본 생성자의 경우 상관없음.
        super(20,30);
        this.x = x;
        this.y = y;
    }

    void printVariable(){
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("x = " + this.x + ", y = " + this.y);
        System.out.println("x = " + super.x + ", y = " + super.y);
    }

}
