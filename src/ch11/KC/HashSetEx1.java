package ch11.KC;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Daniel on 2016. 6. 12..
 */
public class HashSetEx1 {
    public static void main(String[] args) {

        Object[] objArr = {
                "1",
                new Integer(1),
                "2",
                "2",
                "3",
                "3",
                "4",
                "4",
                "4"
        };

        Set set = new HashSet();

        for (int i = 0; i < objArr.length; i++) {
            set.add(objArr[i]);
        }

        System.out.println(set);
    }
}
