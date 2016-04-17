package ch07.KC;

/**
 * Created by Daniel on 2016. 4. 16..
 */

class Tv1{
    boolean power;
    int channel;

    void power(){

    }

    void channelUP(){

    }

    void channelDown(){

    }
}

class VCR{
    boolean power;
    int counter = 0;
    void power(){}
    void play(){}
    void stop(){}
    void rew(){}
    void ff(){}
}

public class TVCR extends Tv1{
    VCR vcr = new VCR();
    int counter = vcr.counter;

    void play(){
        vcr.play();
    }

    void stop(){
        vcr.stop();
    }

    void rew(){
        vcr.rew();
    }

    void ff(){
        vcr.ff();
    }
}
