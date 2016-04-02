package ch06.KC;

/**
 * Created by Daniel on 2016. 4. 2..
 */
public class ParameterTest3 {

    public static void main(String[] args) {
        int[] x = {10};
        System.out.println("main() : x = " + x[0]);

        change(x);
        System.out.println("After change(d)");
        System.out.println("main() : x = " + x[0]);


    }

    static void change(int[] x){
        x[0] = 1000;
        System.out.println("change() : x = " + x[0]);
    }

}
