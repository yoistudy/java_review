package ch02;

/**
 * Created by Daniel on 2016. 3. 6..
 */
public class CodeToChar {
    public static void main(String args[]){
        int code = 65;

        // char 형 변수에 저장되는 값은 부호없는 정수의 형태로 저장된다.
        char ch = (char)code;

        System.out.println(code);
        System.out.println(ch);
    }
}
