package ch07.KC;

/**
 * Created by Daniel on 2016. 5. 1..
 */
public class RepairableTest {

    public static void main(String[] args) {
        Tank tank = new Tank();
        DropShip dropship = new DropShip();

        Marine marine = new Marine();
        SCV scv = new SCV();

        scv.repair(tank);
        scv.repair(dropship);
        //scv.repair(marine);
    }
}


interface Repariable{};

class GroundUnit extends CommonUnit{

    GroundUnit(int hp) {
        super(hp);
    }
}

class AirUnit extends CommonUnit{
    AirUnit(int hp) {
        super(hp);
    }
}

class CommonUnit{
    int hitPoint;
    final int MAX_HP;
    CommonUnit(int hp){
        MAX_HP = hp;
    }
}

class Tank extends GroundUnit implements Repariable{
    Tank() {
        super(150);
        hitPoint = MAX_HP;
    }

    @Override
    public String toString() {
        return "Tank";
    }
}

class DropShip extends AirUnit implements Repariable{
    DropShip(){
        super(125);
        hitPoint = MAX_HP;
    }

    @Override
    public String toString() {
        return "DropShip";
    }
}

class Marine extends GroundUnit{
    Marine(){
        super(40);
        hitPoint = MAX_HP;
    }
}

class SCV extends GroundUnit implements Repariable{
    SCV(){
        super(60);
        hitPoint = MAX_HP;
    }

    void repair(Repariable r){
        if(r instanceof CommonUnit){
            CommonUnit u = (CommonUnit) r;
            while (u.hitPoint != u.MAX_HP){
                u.hitPoint++;
            }
            System.out.println(u.toString() + "의 수리가 끝났습니다.");
        }
    }

}



