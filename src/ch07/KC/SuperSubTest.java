package ch07.KC;

/**
 * Created by Daniel on 2016. 4. 24..
 */
public class SuperSubTest {
    public static void main(String[] args) {

        /*
        * 슈퍼클래스 참조 변수 -> 서브클래스 인스턴스
        * */
        SuperClassTest sup = new SubClassTest();
        System.out.println(sup.superMsg);

        /*
        * 서브클래스 참조 변수 -> 슈퍼클래스 인스턴스
        * 참조 불가(캐스팅 안됨)
        * */
        // SubClassTest sub = (SubClassTest) new SuperClassTest();
        // System.out.println(sub.superMsg);

        // SubClassTest sub = new SubClassTest();
        // SuperClassTest sup1 = new SuperClassTest();

        // 슈퍼클래스 참조변수 -> 서브클래스 인스턴스
        // sup1 = sup;
        //System.out.println(sup1.superMsg);

        SuperClassTest sup1 = sup;
        sup1 = (SuperClassTest)sup;

    }
}



class SuperClassTest{
    String superMsg = "슈퍼클래스";
}

class SubClassTest extends SuperClassTest{
    String subMsg = "서브클래스";
}