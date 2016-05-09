package ch07.KC;

import java.util.Date;

/**
 * Created by Daniel on 2016. 5. 8..
 */
public class SingletonTest {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        instance.printMsg();
        instance.printNumber();

        // 싱글톤 인스턴스 초기화
        Singleton.setInstance(); // null

        instance.printMsg();
        instance.printNumber();


    }


}


class Singleton{

    private static Singleton instance = new Singleton(); //aa

    private Singleton(){
        System.out.println("Singleton constructor");
    }

    public static Singleton getInstance(){
        return instance;
    }


    public static void setInstance(){
        if (instance != null){
            System.out.println("instance null");
            instance = null;
            System.gc();
        }
    }


    public void printMsg(){
        System.out.println("printMsg");
    }

    public void printNumber(){
        System.out.println("printNumber");
    }



}
