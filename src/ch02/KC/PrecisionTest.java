package ch02.KC;

/**
 * Created by Daniel on 2016. 3. 6..
 */
public class PrecisionTest {

    public static void main(String args[]){
        float f = 1.2345678901234567890f;
        double d = 1.2345678901234567890;

        float f2 = 0.10000000001f;
        double d2 = 0.1000000001;
        double d3 = 0.1000000000000001;

        System.out.println(f);
        System.out.println(d);
        System.out.println(f2);
        System.out.println(d2);
        System.out.println(d3);
    }
}
