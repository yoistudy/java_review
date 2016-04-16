package ch06.KC;

/**
 * Created by Daniel on 2016. 4. 2..
 */
public class TvTest3 {

    public static void main(String[] args) {
        Tv t1 = new Tv();
        Tv t2 = new Tv();
        String hello = "Hello World";

        System.out.println();
        System.out.println("t1의 channel값은 " + t1.channel + "입니다.");
        System.out.println("t2의 channel값은 " + t2.channel + "입니다.");

        t2 = t1;
        t1.channel = 7;
        System.out.println("t1의 channel값을 7로 변경하였습니다.");


        System.out.println("t1의 channel값은 " + t1.channel + "입니다.");
        System.out.println("t2의 channel값은 " + t2.channel + "입니다.");
    }

}
