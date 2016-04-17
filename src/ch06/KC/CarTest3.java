package ch06.KC;

/**
 * Created by Daniel on 2016. 4. 16..
 */
class Car3{
    String color;
    String gearType;
    int door;

    Car3(){
        this("white", "auth", 4);
    }


    Car3(Car3 c){
        color = c.color;
        gearType = c.gearType;
        door = c.door;
    }

    Car3(String color){
        this(color, "auth", 4);
    }

    Car3(String color, String gearType, int door){
        this.color=color;
        this.gearType = gearType;
        this.door = door;
    }

}




public class CarTest3 {
    public static void main(String[] args) {
        Car3 c1 = new Car3();
        Car3 c2 = new Car3(c1);

        System.out.println("c1의 color = " + c1.color + ", gearType = " + c1.gearType + ", door = " + c1.door);
        System.out.println("c2의 color = " + c2.color + ", gearType = " + c2.gearType + ", door = " + c2.door);

        c1.color = "red";
        c1.gearType = "manual";
        c1.door = 10;

        System.out.println("c1의 color = " + c1.color + ", gearType = " + c1.gearType + ", door = " + c1.door);
        System.out.println("c2의 color = " + c2.color + ", gearType = " + c2.gearType + ", door = " + c2.door);
    }
}