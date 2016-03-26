package ch05.KC;

/**
 * Created by Daniel on 2016. 3. 26..
 */
public class ArrayEx11 {

    public static void main(String[] args) {
        int[] number = {1,2,3,4,5};
        int[] newNumber = new int[10];

        for(int i = 0 ; i < number.length ; i++){
            newNumber[i] = number[i];
        }

        for (int i = 0; i < newNumber.length; i++) {
            System.out.print(newNumber[i]);

        }

    }
}
