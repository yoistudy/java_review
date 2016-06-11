package ch08.KC;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Daniel on 2016. 5. 29..
 */
public class ExceptionEx2 {
    public static void main(String[] args) {
        int number = 100;
        int result = 0;

        List<String> strList = new ArrayList<String>();

        strList.stream()
                .forEach();

        for (int i = 0; i < 10; i++) {
            result = number / (int)(Math.random() * 10);
            System.out.println(result);
        }
    }
}
