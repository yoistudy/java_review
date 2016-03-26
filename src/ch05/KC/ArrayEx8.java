package ch05.KC;

/**
 * Created by Daniel on 2016. 3. 26..
 */
public class ArrayEx8 {

    public static void main(String[] args) {
        String src = "ABCDE";

        for(int i = 0 ; i < src.length() ; i++){
            System.out.println("src.chatAt(" + i + "):" + src.charAt(i));
        }
    }
}
