package ch06.KC;

/**
 * Created by Daniel on 2016. 4. 2..
 */
public class FactorialTest {
    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(factorialAnother(4));
    }
    // 4*3*2*1
    static long factorial(int n){
        if(n == 1){
            return 1;
        }
        else{
            return n * factorial(n-1);
        }
    }

    static long factorialAnother(int n){
        return n == 1 ? 1 : n * factorialAnother(n-1);
    }
}
