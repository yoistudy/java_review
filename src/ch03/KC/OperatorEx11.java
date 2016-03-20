package ch03.KC;

/**
 * Created by Daniel on 2016. 3. 20..
 */
public class OperatorEx11 {

    public static void main(String args[]){
        long a = 1000000 * 1000000;

        // 피연산자 한쪽이 long타입일 경우, 자동으로 타입캐스팅이 이뤄짐.
        long b = 1000000 * 1000000L;
        System.out.println(a);
        System.out.println(b);
    }

}
