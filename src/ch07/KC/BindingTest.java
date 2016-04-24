package ch07.KC;

/**
 * Created by Daniel on 2016. 4. 24..
 */
public class BindingTest {
    public static void main(String[] args) {
        Parent1 p = new Child3();
        Child3 c = new Child3();

        System.out.println("p.x = " + p.x);
        p.method();

        System.out.println("c.x = " + c.x);
        c.method();
    }


}

class Parent1{
    int x = 100;

    void method(){
        System.out.println("Parent Method");
    }
}

class Child3 extends Parent1{
    int x = 200;

    void method(){
        System.out.println("Child Method");
    }
}
