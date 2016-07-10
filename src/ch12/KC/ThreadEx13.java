package ch12.KC;

/**
 * Created by Daniel on 2016. 7. 10..
 */
public class ThreadEx13 {
    static long startTime=0;

    public static void main(String[] args) {
        ThreadEx13_1 th1 = new ThreadEx13_1();
        ThreadEx13_2 th2 = new ThreadEx13_2();

        th1.start();
        startTime = System.currentTimeMillis();

        try{
            th1.join();
//            th2.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        th2.start();
        System.out.print("소요시간 : " + (System.currentTimeMillis() - ThreadEx13.startTime));
    }

}

class ThreadEx13_1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
    }
}

class ThreadEx13_2 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
        }
    }
}
