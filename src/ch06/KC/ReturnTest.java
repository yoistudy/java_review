package ch06.KC;

/**
 * Created by Daniel on 2016. 4. 2..
 */
public class ReturnTest {

    public static void main(String[] args) {
        ReturnTest r= new ReturnTest();

        int result = r.add(3,5);
        System.out.println(result);

        /**
         * 중요!
         */
        int[] result2 = {0}; // 배열 객체 초기화(ch04 참고)
        r.add(3,5,result2);  // 배열 객체의 주소 값을 넘김

    }

    /*
    *
    * add [매서드 오버로딩]
    * */
    int add(int a, int b){
        return a+b;
    }

    void add(int a, int b, int[] result){
        result[0] = a+b;
    }

}
