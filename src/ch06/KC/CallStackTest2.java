package ch06.KC;

/**
 * Created by Daniel on 2016. 4. 2..
 */
public class CallStackTest2 {

    public static void main(String[] args) {
        System.out.println("Main Method 실행");
        firstMethod();
        System.out.println("Main Method 종료");
    }

    static void firstMethod(){
        System.out.println("firstMethod start");
        secondMethod();
        System.out.println("firstMethod end");
    }

    static void secondMethod(){
        System.out.println("secondMethod start");
        System.out.println("secondMethod()");
        System.out.println("secondMethod end");
    }

}
