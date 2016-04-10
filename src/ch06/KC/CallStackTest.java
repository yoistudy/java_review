package ch06.KC;

/**
 * Created by Daniel on 2016. 4. 2..
 */
public class CallStackTest {
    public static void main(String[] args) {
        firstMethod();
    }

    static void firstMethod(){
        secondMethod();
    }

    static void secondMethod(){
        System.out.println("secondMethod()");
    }


}
