package ch02;

/**
 * Created by Daniel on 2016. 3. 6..
 */
public class CastingEx1 {
    public static void main(String args[]){
        double d = 100.0;
        int i = 100;
        int result = i + (int)d;

        System.out.println("d=" + d);
        System.out.println("i=" + i);
        System.out.println("result=" + result);
    }
}
