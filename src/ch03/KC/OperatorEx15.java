package ch03.KC;

/**
 * Created by Daniel on 2016. 3. 20..
 */
public class OperatorEx15 {

    public static void main(String args[]){
        char c = 'a';
        for(int i = 0 ; i < 26 ; i++){
            System.out.println(c++);
        }

        System.out.println();

        c = 'A';
        for(int i = 0 ; i < 26 ; i++){
            System.out.println(c++);
        }

        System.out.println();

        c = '0';
        for(int i = 0 ; i < 10 ; i++){
            System.out.println(c++);
        }
        System.out.println();





    }

}
