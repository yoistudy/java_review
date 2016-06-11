package ch08.KC;

/**
 * Created by Daniel on 2016. 5. 29..
 */
public class ExceptionEx11 {

    public static void main(String[] args) {

        System.out.println(1);
        System.out.println(2);
        try{
            System.out.println(3);
            System.out.println(4);
        }
        catch (ArithmeticException ae){
            if (ae instanceof ArithmeticException){
                System.out.println("true");
                System.out.println("ArithmeticException");
            }
        }
        catch (RuntimeException ae){
            System.out.println("RuntimeException");
        }
        catch (Exception e){
            System.out.println("Exception");
        }

    }
}
