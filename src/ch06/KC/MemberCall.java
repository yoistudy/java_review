package ch06.KC;

/**
 * Created by Daniel on 2016. 4. 16..
 */
public class MemberCall {

    int iv = 10;
    static int cv = 20;

    int iv2 = cv;
    // static int cv2 = iv;
    static int cv2 = new MemberCall().iv;

    /**
     * 클래스 맴버가 인스턴스 맴버르 참조하는 경우는 드물다.
     * 그러므로, 클래스 맴버가 인스턴스 맴버를 참조하는 경우 클래스 구조에 대해서 다시 파악하여
     * 문제가 있는지 없는지 다시 확인하여야 한다.
     */
    static void staticMethod1(){
        System.out.println(cv);
        //System.out.println(iv);
        MemberCall c = new MemberCall();
        System.out.println(c.iv);
    }

    void instanceMethod1(){
        System.out.println(cv);
        System.out.println(iv);
    }

    static void staticMethod2(){
        staticMethod1();
        //instanceMethod1();
        MemberCall c = new MemberCall();
        c.instanceMethod1();
    }

    void instanceMethod2(){
        staticMethod1();
        instanceMethod1();
    }

}
