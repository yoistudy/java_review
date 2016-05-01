package ch07.KC;

/**
 * Created by Daniel on 2016. 4. 24..
 */
public class InstanceofTest {

    public static void main(String[] args) {
        CastingFireEngine fe = new CastingFireEngine();

        if(fe instanceof CastingFireEngine){
            System.out.println("This is a FireEngine instance");
        }

        if(fe instanceof CastingCar){
            CastingCar ct = new CastingFireEngine();
            ct = (CastingFireEngine)ct;
            ((CastingFireEngine) ct).water();
            System.out.println("This is a Car instance");
        }

        if(fe instanceof Object){
            System.out.println("This is an Object instance");
        }

    }
}
