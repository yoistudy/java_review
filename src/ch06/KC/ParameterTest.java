package ch06.KC;

/**
 * Created by Daniel on 2016. 4. 2..
 */
public class ParameterTest {

    public static void main(String[] args) {
        Data d = new Data();
        d.x = 10;
        System.out.println("main() : x = " + d.x);

        change(d.x);
        System.out.println("After change(d.x)");
        System.out.println("main() : x = " + d.x);

    }

    static void change(int x){
        x = 1000;
        System.out.println("change() : x = " + x);
    }
}

class Data{
    int x;
}

