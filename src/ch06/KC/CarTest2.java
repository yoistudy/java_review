package ch06.KC;

/**
 * Created by Daniel on 2016. 4. 16..
 */


class Car1{
    String color;
    String gearType;
    int door;

    Car1(){
        this("white", "auth", 4);
    }

    Car1(String color){
        this(color, "Auth", 4);
    }

    Car1(String color, String gearType, int door){
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

}


public class CarTest2 {



}
