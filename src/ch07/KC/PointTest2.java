package ch07.KC;

/**
 * Created by Daniel on 2016. 4. 17..
 */
public class PointTest2 {
    public static void main(String[] args) {
        Point23D p3 = new Point23D();
        System.out.println("p3.x=" + p3.x);
        System.out.println("p3.y=" + p3.y);
        System.out.println("p3.z=" + p3.z);
    }

}


class Point2{
    int x = 10;
    int y = 20;

    Point2(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Point23D extends Point2{
    int z = 30;

    Point23D(){
        this(100,200,300);
    }

    Point23D(int x, int y, int z){
        super(x,y);
        this.z = z;
    }
}