package ch06.KC;

/**
 * Created by Daniel on 2016. 4. 2..
 */
public class TvTest {

    public static void main(String[] args) {
        Tv tv;
        tv = new Tv();

        tv.channel = 7;
        tv.channelUp();
        tv.channelDown();
        System.out.println(tv.channel);
    }

}


class Tv{
    String color;
    boolean power;
    int channel;

    void power(){
        power = !power;
    }

    void channelUp(){
        ++channel;
    }

    void channelDown(){
        --channel;
    }

}