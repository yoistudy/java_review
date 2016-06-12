package ch11.KC;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Daniel on 2016. 6. 11..
 */
public class IteratorEx2 {
    public static void main(String[] args) {
        ArrayList origin = new ArrayList(10);
        ArrayList copy1 = new ArrayList(10);
        ArrayList copy2 = new ArrayList(10);

        for (int i = 0; i < 10; i++) {
            origin.add(i+"");
        }

        Iterator it = origin.iterator();
        while (it.hasNext()){
            copy1.add(it.next());
        }

        System.out.println();
        System.out.println("=Original에서 Copy1로 복사=");
        System.out.println("Original: " + origin);
        System.out.println("copy1: " + copy1);

        // Iterator는 재사용이 안됨
        it = origin.iterator();

        while (it.hasNext()){
            copy2.add(it.next());
            it.remove();
        }
        System.out.println("=Original에서 Copy2로 복사=");
        System.out.println("Original: " + origin);
        System.out.println("copy2: " + copy2);

    }
}
