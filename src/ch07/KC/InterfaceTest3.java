package ch07.KC;

/**
 * Created by Daniel on 2016. 5. 1..
 */
public class InterfaceTest3 {
    public static void main(String[] args) {
        A a = new A();
        a.methodA();
    }

}

class A{
    void methodA(){
        I i = InstanceManager.getInstance();
        i.methodB();
    }
}

interface I{
    void methodB();
}

class B implements I{

    @Override
    public void methodB() {
        System.out.println("MethodB in B class");
    }
}

class InstanceManager{
    public static I getInstance(){
        return new B();
    }
}