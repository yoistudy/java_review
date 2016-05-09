package ch07.KC;

/**
 * Created by Daniel on 2016. 5. 8..
 */
public class ClassVariableTest{



    public static void main(String[] args) {
        SuperClass obj = new SubClass();
        obj.returnMsg();
        obj.returnMsg2();
    }


}


class SuperClass{
    public static int superVariable = 10;

    public static void returnMsg(){
        System.out.println("Hello Static Method super");
    }

    public void returnMsg2(){
        System.out.println("Hello Instance Method super");

    }
}


class SubClass extends SuperClass{

    @Override
    public void returnMsg2() {
        System.out.println("Hello Instance Method sub");
    }

    public static void returnMsg(){
        System.out.println("Hello Static Method sub");
    }

}
