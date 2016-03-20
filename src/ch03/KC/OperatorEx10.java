package ch03.KC;

/**
 * Created by Daniel on 2016. 3. 20..
 */
public class OperatorEx10 {

    public static void main(String args[]){
        int a = 1000000;
        int b = 2000000;


        // a와 b는 int타입이기 떄문에, 해당 범위를 초과하는 값을 가짐
        long c = a * b;
        System.out.println(c);
    }


}
