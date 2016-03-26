package ch05.KC;

/**
 * Created by Daniel on 2016. 3. 27..
 */
public class ArrayEx13 {

    public static void main(String[] args) {
        System.out.println("매개변수의 개수:" + args.length);
        for(int i = 0 ; i < args.length ; i++){
            System.out.println("args[i" + i + "] = \"" + args[i] + "\"");
        }
    }
}
