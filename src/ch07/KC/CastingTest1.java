package ch07.KC;

/**
 * Created by Daniel on 2016. 4. 24..
 */
public class CastingTest1 {

    public static void main(String[] args) {
        CastingCar car = null;
        CastingFireEngine fe = new CastingFireEngine();
        CastingFireEngine fe2 = null;

        fe.water();
        car = fe; // 자손->조상(UpCasting)
        //car.water() // error; // 참조할 수 있는 맴버가 아님
        fe2 = (CastingFireEngine)car; // 조상->자손(DownCasting)
        fe2.water(); // 자손 맴버에 속하기 때문에, 참조가능.

    }
}

class CastingCar{
    String color;
    int door;
    void drive(){
        System.out.println("drive, brrrr");
    }

    void stop(){
        System.out.println("Stop!!!!");
    }
}

class CastingFireEngine extends CastingCar{
    void water(){
        System.out.println("Water!!!!");
    }
}

