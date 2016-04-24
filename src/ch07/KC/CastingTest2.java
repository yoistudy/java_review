package ch07.KC;

/**
 * Created by Daniel on 2016. 4. 24..
 */
public class CastingTest2 {
    public static void main(String[] args) {
        CastingCar car = new CastingCar();
        CastingCar car2 = null;
        CastingFireEngine fe = null;

        car.drive();
        //fe = (CastingFireEngine) car;
        //fe.drive();
        //car2 = fe;
        //car2.drive();
    }
}
