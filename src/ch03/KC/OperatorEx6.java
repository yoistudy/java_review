package ch03.KC;

/**
 * Created by Daniel on 2016. 3. 20..
 */
public class OperatorEx6 {

    public static void main(String args[]){
        byte b = 10;

        // 피연산자의 타입이 int보다 작으면, int형으로 변환 후 연산을 하기 떄문에, 타입 캐스팅을 해야 함.
        // byte result = ~b;

        byte result = (byte)~b;

        System.out.println("b = " + b);
        System.out.println("~b = " + result);
    }
}
