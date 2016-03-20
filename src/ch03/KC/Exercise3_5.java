package ch03.KC;

/**
 * Created by Daniel on 2016. 3. 20..
 */
public class Exercise3_5 {

    public static void main(String args[]){
        int num = 777;

        System.out.println((num/100*100)  +  (num - (num/100*100)) % 10 * 10 + 1);
    }


}
