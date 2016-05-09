package ch07.KC;

/**
 * Created by Daniel on 2016. 5. 1..
 */
public class InterfaceTest1 {
    public static void main(String[] args) {
        User user = new User();
        ProviderA a = new ProviderA();
        ProviderB b = new ProviderB();

        user.userMethod(a);
        user.userMethod(b);

    }
}


class User{

    void userMethod(ProviderInterface i){
        i.method();
    }
}
class ProviderA implements ProviderInterface{
    @Override
    public void method() {
        System.out.println("ProviderA Method");
    }

    @Override
    public String toString() {
        return "ProviderA";
    }
}
class ProviderB implements ProviderInterface{

    @Override
    public void method() {
        System.out.println("ProviderB Method");
    }

    @Override
    public String toString() {
        return "ProviderB";
    }
}

interface ProviderInterface{
    void method();
}