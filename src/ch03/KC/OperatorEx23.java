package ch03.KC;

/**
 * Created by Daniel on 2016. 3. 20..
 */
public class OperatorEx23 {

    public static void main(String args[]){


        // int, float => float으로 변환
        if(10 == 10.0f){
            System.out.println("10과 10.0f는 같다.");
        }

        // '0'의 경우 바인딩 된 코드 값(정수)와 0은 다름
        if('0' != 0){
            System.out.println("'0'과 0은 같지 않다.");
        }


        // 서로 가지는 정수 값이 같으므로 True
        if('A' == 65){
            System.out.println("'A'는 65와 같다.");
        }

        int num = 5;

        if(num > 0 && num < 9){
            System.out.println("5는 0보다 크고, 9보다는 작다.");
        }


    }

}
