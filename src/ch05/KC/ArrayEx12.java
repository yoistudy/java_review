package ch05.KC;

/**
 * Created by Daniel on 2016. 3. 26..
 */
public class ArrayEx12 {

    public static void main(String[] args) {
        char[] abc = {'A', 'B', 'C', 'D'};
        char[] number = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        System.out.println(new String(abc));
        System.out.println(new String(number));
        System.out.println();

        char[] result = new char[abc.length + number.length];
        System.arraycopy(abc, 0, result, 0, abc.length);
        System.arraycopy(number, 0, result, abc.length, number.length);
        System.out.println(result);

        System.arraycopy(abc, 0 , number, 0, abc.length);
        System.out.println(new String(number));

        System.arraycopy(abc, 0, number, 6, 3);
        System.out.println(new String(number));

    }
}
