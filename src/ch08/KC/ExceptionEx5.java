package ch08.KC;

/**
 * Created by Daniel on 2016. 5. 29..
 */
public class ExceptionEx5 {

    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try{
            System.out.println(3);
            System.out.println(0/0);
            System.out.println(4);
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
            System.out.println(5);
        }
        System.out.println(6);


    }

}
