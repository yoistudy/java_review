package ch03.KC;

/**
 * Created by Daniel on 2016. 3. 20..
 */
public class OperatorEx25 {

    public static void main(String args[]){
        char x = 'j';

        if((x>= 'a' && x <= 'z') || (x>'A' && x <= 'Z')){
            System.out.println("유효한 문자입니다.");
        }
        else{
            System.out.println("유효하지 않은 문자입니다.");
        }
    }

}
