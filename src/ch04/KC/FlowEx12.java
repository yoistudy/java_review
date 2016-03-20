package ch04.KC;

/**
 * Created by Daniel on 2016. 3. 20..
 */
public class FlowEx12 {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 10 ; i++) {
            sum += i;
            System.out.println(i + "까지의 합 : " + sum);
        }

        /*
        for (int i = 1; i <= 10 ; i++) {
            sum += 1;
        }
        System.out.println(i-1 + "까지의 합 : " + sum);
        */

    }
}
